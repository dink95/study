package com.example.backend.controller;

import com.example.backend.service.OembedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class OembedController {


    OembedService service;


    @Autowired
    public OembedController(OembedService service) {
        this.service = service;
    }

    @GetMapping("/site/{url}")
    public ResponseEntity<Map<String,Object>> oEmbed(@PathVariable("url")String url){

        return null;
    }

}
