package com.msa.user.service;

import com.msa.user.DTO.UserDto;
import com.msa.user.jpa.UserEntity;
import com.msa.user.jpa.UserRepository;
import com.msa.user.vo.ResponseOrder;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UsersServiceImpl implements UserService{


    UserRepository userRepository;
    BCryptPasswordEncoder encoder;

    @Autowired
    public UsersServiceImpl(UserRepository userRepository,BCryptPasswordEncoder encoder ){
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
         userDto.setUserId(UUID.randomUUID().toString());
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity = mapper.map(userDto,UserEntity.class);
        userEntity.setEnPwd(encoder.encode(userDto.getPwd()));//암호화

        userRepository.save(userEntity);

        UserDto userDto1 = mapper.map(userEntity,UserDto.class);
        return userDto1;
    }

    @Override
    public UserDto getUserByUserId(String userId) {
        UserEntity userEntity = userRepository.findByUserId(userId);

        if(userEntity==null)
            throw new UsernameNotFoundException("user not found");

        UserDto userDto = new ModelMapper().map(userEntity,UserDto.class);

        List<ResponseOrder> orders = new ArrayList<>();
        userDto.setOrders(orders);

        return userDto;
    }

    @Override
    public Iterable<UserEntity> getUserByAll() {
        return userRepository.findAll();
    }


}
