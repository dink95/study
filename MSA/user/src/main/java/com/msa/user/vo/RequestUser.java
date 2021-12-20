package com.msa.user.vo;


import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
public class RequestUser {

    @Email
    @NotNull(message = "cannot be null")
    @Size(min = 2,message = "more than 2 characters")
    private String email;

    @NotNull(message = "cannot be null")
    @Size(min = 2,message = "more than 2 characters")
    private String name;

    @NotNull(message = "cannot be null")
    @Size(min = 8,message = "more than 8 characters")
    private String pwd;



}
