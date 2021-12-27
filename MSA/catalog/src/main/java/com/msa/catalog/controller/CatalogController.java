package com.msa.catalog.controller;

import com.msa.catalog.jpa.CatalogEntity;
import com.msa.catalog.service.CatalogService;
import com.msa.catalog.vo.ResponseCatalog;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/catalog-service")
public class CatalogController {

    Environment env;
    CatalogService catalogService;

    @Autowired
    public CatalogController(Environment env, CatalogService service) {
        this.env = env;
        this.catalogService = service;
    }

    @GetMapping("/health_check")
    public String status(){
        return String.format("it's working on port number %s",env.getProperty("local.server.port"));
    }


    @GetMapping("/catalogs")
    public ResponseEntity<List<ResponseCatalog>> getUsers(){

        Iterable<CatalogEntity> userList = catalogService.getAllCatalogs();
        List<ResponseCatalog> list= new ArrayList<>();

        userList.forEach(v->{
            list.add(new ModelMapper().map(v,ResponseCatalog.class));
        });
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }



}
