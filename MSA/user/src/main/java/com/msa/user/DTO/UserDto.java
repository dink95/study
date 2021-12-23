package com.msa.user.DTO;

import com.msa.user.vo.ResponseOrder;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private String email;
    private String pwd;
    private String name;
    private String userId;
    private  Data createAt;

    private String encryptedPwd;

    private List<ResponseOrder> orders;

}
