package com.example.backend.controller;

import com.example.backend.dto.EmbedDto;
import com.example.backend.service.OembedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class OembedController {


    OembedService service;


    @Autowired
    public OembedController(OembedService service) {
        this.service = service;
    }

    @GetMapping("/site")
    public ResponseEntity<Map<String,Object>> oEmbed(@RequestParam(value = "url") String url){

        if(url.contains("facebook"))
            return service.getFacebookHTML(url,"type");

        return  service.callEmbedProcess(url);
    }

    @GetMapping("/api")
    public EmbedDto getEmbedData(@RequestParam(value = "url") String url){

        return service.callEmbedData(url);
    }

}
