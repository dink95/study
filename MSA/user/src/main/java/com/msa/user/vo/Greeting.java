package com.msa.user.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class Greeting {


    //방식 2
    @Value("${greeting.message}")
    private String message;


}
