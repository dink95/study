package com.msa.user.DTO;

import lombok.Data;

@Data
public class UserDto {

    private String email;
    private String pwd;
    private String name;
    private String userId;
    private  Data createAt;

    private String encryptedPwd;

}
