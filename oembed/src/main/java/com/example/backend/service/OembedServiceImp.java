package com.example.backend.service;

import com.example.backend.dto.EmbedDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

@Service
public class OembedServiceImp implements OembedService {


    private final static String FACEBOOKPAGE = "https://graph.facebook.com/v12.0/oembed_page?url=";
    private final static String FACEBOOKPOST = "https://graph.facebook.com/v12.0/oembed_post?url=";
    private final static String FACEBOOKVIDEO = "https://graph.facebook.com/v12.0/oembed_video?url=";


    //가능
    private final static String INSTAGRAMURL = "https://api.instagram.com/oembed?url=";
    private final static String TWITTERURL = "https://publish.twitter.com/oembed?url=";
    private final static String TIKTOKURL = "https://www.tiktok.com/oembed?url=";
    private final static String YOUTUBEURL = "https://www.youtube.com/oembed?url=";


    @Autowired
    RestTemplate restTemplate;

    public ResponseEntity<Map<String, Object>> callEmbedProcess(String url) {
        Map<String, Object> result = new HashMap<>();

        if (url.contains("instagram")) {
            return getInstagramHTML(url);
        }  else if (url.contains("twitter")) {
            return getTwitterHTML(url);
        } else if (url.contains("tiktok")) {
            return getTiktokHTML(url);
        }else if(url.contains("youtube")) {
            return getYouTubeHTML(url);
        }
        else {
            result.put("result", "Fail");
            result.put("response", "현재 지원하지 않는 Social 이거나, 잘못된 URL 입니다. 다시 확인해주시기 바랍니다.");
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }



    /* https://developers.facebook.com/docs/instagram/oembed-legacy/?locale=ko_KR */
    private ResponseEntity<Map<String, Object>> getInstagramHTML(String url) {
        Map<String, Object> embedResult = new HashMap<>();
        Map<String, Object> result = new HashMap<>();


        boolean isInstagramPost = Pattern.compile("(https://www.instagram.com/p/.*?)").matcher(url).find();
        if (!isInstagramPost) {
            result.put("result", "Fail");
            result.put("response", "지원하지 않는 형식의 Instagram URL 입니다.");
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        // API 요청
        embedResult = restTemplate.getForObject(INSTAGRAMURL + url, Map.class);
        result.put("result", "success");
        result.put("response", embedResult.get("html"));

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    private ResponseEntity<Map<String, Object>> getTwitterHTML(String url) {
        Map<String, Object> embedResult = new HashMap<>();
        Map<String, Object> result = new HashMap<>();

        // 트위터 포스트 확인
        boolean isTwitterPost = Pattern.compile("(https://twitter.com/.*/status/.*?)").matcher(url).find();
        if (!isTwitterPost) {
            result.put("result", "Fail");
            result.put("response", "지원하지 않는 형식의 Twitter URL 입니다.");
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        // API 요청
        RestTemplate template = new RestTemplate();
        embedResult = template.getForObject(TWITTERURL + url, Map.class);

        result.put("result", "success");
        result.put("response", embedResult.get("html"));

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    /* 틱톡은 web page 공유하기로만 가능!
    * https://developers.tiktok.com/doc/embed-videos */
    private ResponseEntity<Map<String, Object>> getTiktokHTML(String url) {
        Map<String, Object> embedResult = new HashMap<>();
        Map<String, Object> result = new HashMap<>();

        // 틱톡 포스트 확인
        boolean isTiktokPost = Pattern.compile("(https://www.tiktok.com/.*/video/.*?)").matcher(url).find();
        if (!isTiktokPost) {
            result.put("result", "Fail");
            result.put("response", "지원하지 않는 형식의 Tiktok URL 입니다.");
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        // API 요청

        embedResult = restTemplate.getForObject(TIKTOKURL + url, Map.class);

        result.put("result", "success");
        result.put("response", embedResult.get("html"));

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    private ResponseEntity<Map<String, Object>> getYouTubeHTML(String url) {
        Map<String, Object> embedResult = new HashMap<>();
        Map<String, Object> result = new HashMap<>();


        boolean isYouTubePost = Pattern.compile("(https://www.youtube.com/.*?)").matcher(url).find();
        if (!isYouTubePost) {
            result.put("result", "Fail");
            result.put("response", "지원하지 않는 형식의 YOUTUBE URL 입니다.");
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }


        embedResult = restTemplate.getForObject(YOUTUBEURL + url, Map.class);

        result.put("result", "success");
        result.put("response", embedResult.get("html"));

        return new ResponseEntity<>(result, HttpStatus.OK);


    }

     public ResponseEntity<Map<String, Object>> getFacebookHTML(String url, String type) {
        Map<String, String> embedResult = new HashMap<>();
        Map<String, Object> result = new HashMap<>();

        String embedResponse;
        if(type.equals("post")) {
            embedResponse = restTemplate.getForObject(FACEBOOKPOST + url + "&access_token=사용자 지정토큰",
                    String.class);
        }else if(type.equals("video")){
             embedResponse = restTemplate.getForObject(FACEBOOKVIDEO + url + "&access_token=사용자 지정토큰",
                    String.class);
        }else{
             embedResponse = restTemplate.getForObject(FACEBOOKPAGE + url + "&access_token=사용자 지정토큰",
                    String.class);
        }

        result.put("result", "success");
        result.put("response", embedResult.get("html"));

        HttpHeaders headers =new HttpHeaders();
        headers.add("Authorization","Bearer "+"사용자토큰");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public EmbedDto callEmbedData(String url) {



        EmbedDto dto = new EmbedDto();
        if (url.contains("instagram")) {
             dto = restTemplate.getForObject(INSTAGRAMURL + url,EmbedDto.class);
        }  else if (url.contains("twitter")) {
             dto = restTemplate.getForObject(TWITTERURL + url,EmbedDto.class);
        } else if (url.contains("tiktok")) {
             dto = restTemplate.getForObject(TIKTOKURL + url,EmbedDto.class);
        }else if(url.contains("youtube")) {
             dto = restTemplate.getForObject(YOUTUBEURL + url,EmbedDto.class);
        }else {
             dto = null;
        }

        return dto;
    }


}
