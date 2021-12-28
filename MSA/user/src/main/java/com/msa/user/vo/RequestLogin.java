package com.msa.user.vo;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RequestLogin {


    @NotNull(message = "Email cannot be null")
    @Size(min = 2,message = "Email not be less than two char")
    @Email
    private String email;

    @NotNull(message = "Email cannot be null")
    @Size(min = 8,message = "Email not be less than 8 char")
    private String password;


}
