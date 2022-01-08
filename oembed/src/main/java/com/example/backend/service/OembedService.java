package com.example.backend.service;

import com.example.backend.dto.EmbedDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.util.Map;

public interface OembedService {

    /* HTML RETURN */
    ResponseEntity<Map<String, Object>> callEmbedProcess(String url);
    /* HTML RETURN */
    ResponseEntity<Map<String, Object>> getFacebookHTML(String url, String type);
    /* 모든 DATA RETURN */
    EmbedDto callEmbedData(String url);



}
