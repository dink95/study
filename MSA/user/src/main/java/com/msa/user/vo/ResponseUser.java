package com.msa.user.vo;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL) //null인 내용은 포함하지 않는다.
public class ResponseUser {


    private String email;
    private String name;
    private String userId;

    private List<ResponseOrder> orders;



}
