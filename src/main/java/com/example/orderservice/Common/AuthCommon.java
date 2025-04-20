package com.example.orderservice.Common;

import com.example.orderservice.DTOS.UserDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class AuthCommon {
    private RestTemplate restTemplate;
    public AuthCommon(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserDto validate(String tokenValue){
        String token = tokenValue.replace("Bearer ", "").trim();
        String url = "http://USERSELFSERVICE/users/validate/" + token;
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<UserDto> response = restTemplate.exchange(url , HttpMethod.GET, new HttpEntity<>(headers), UserDto.class);
        if(!response.hasBody()){
            return null;
        }
        return  response.getBody();

    }

}
