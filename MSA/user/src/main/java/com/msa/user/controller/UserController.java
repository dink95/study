package com.msa.user.controller;

import com.msa.user.DTO.UserDto;
import com.msa.user.jpa.UserEntity;
import com.msa.user.service.UserService;
import com.msa.user.vo.RequestUser;
import com.msa.user.vo.ResponseUser;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user-service")
public class UserController {

    private Environment env;//environment 사용한 불러오기
    //component와  value도 사용가능

    private UserService userService;

    @Autowired
    public UserController(Environment e, UserService userService){
        this.env = e;
        this.userService = userService;
    }

    @GetMapping("/welcome")
    public String welcome(HttpServletRequest request){

        return request.getRemoteAddr();
    }

    @GetMapping("/health_check")
    public String status(){
        return String.format("it's working on port number %s",env.getProperty("local.server.port"));
    }


    @PostMapping("/users")
    public ResponseEntity<ResponseUser> createUser(@RequestBody RequestUser user){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        // 요청 내용 -> DTO로 맵핑
        UserDto userDto = mapper.map(user,UserDto.class);
        userService.createUser(userDto);

        ResponseUser responseUser = mapper.map(userDto,ResponseUser.class);

        //201번 SUCCESS
        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);

    }

    @GetMapping("/users")
    public ResponseEntity<List<ResponseUser>> getUsers(){

        Iterable<UserEntity> userList = userService.getUserByAll();
        List<ResponseUser> list= new ArrayList<>();

        userList.forEach(v->{
            list.add(new ModelMapper().map(v,ResponseUser.class));
        });
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<ResponseUser> getUser(@PathVariable("userId")String userId){

        UserDto userDto = userService.getUserByUserId(userId);

        ResponseUser responseUser = new ModelMapper().map(userDto,ResponseUser.class);

        return ResponseEntity.status(HttpStatus.OK).body(responseUser);
    }



}
