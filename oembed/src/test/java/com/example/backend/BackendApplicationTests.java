package com.example.backend;

import com.example.backend.controller.OembedController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;


import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;





@WebMvcTest(controllers = OembedController.class)
@SpringBootTest
class BackendApplicationTests {


    String youtube ="https://www.youtube.com/watch?v=bz5q5gl2uZA";
    String instagram ="https://www.instagram.com/p/CYaWhleNeiC/?utm_medium=share_sheet";
    String tweet = "https://twitter.com/elonmusk/status/1479236333516165121";
    String tiktok ="https://www.tiktok.com/@michaelmejeh/video/7035709035756309766";

    /*불가*/
    String facebook ="https://www.facebook.com/Manbou-102092055701951";


    @Autowired
    private MockMvc mockMvc;



    @Test
    void contextLoads() throws Exception {

               mockMvc.perform(MockMvcRequestBuilders.get("/site?url="+youtube));


    }

}
