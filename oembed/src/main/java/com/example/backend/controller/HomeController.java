package com.example.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HomeController {


    @Autowired
    OembedController controller;

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/change")
    public void change(HttpServletResponse response, @RequestParam("input") String input) throws IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        response.getWriter().print("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                        controller.oEmbed(input).getBody().get("response")+
                "</body>\n" +
                "</html>");

       ;
    }


}
