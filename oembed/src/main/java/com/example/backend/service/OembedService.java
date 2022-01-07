package com.example.backend.service;

import org.springframework.http.HttpEntity;

import java.net.URISyntaxException;
import java.util.Map;

public interface OembedService {

    HttpEntity<Map<String, Object>> callEmbedProcess(String paramUrl);
}
