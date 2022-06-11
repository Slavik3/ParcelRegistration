package com.post.parcel_registration.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PostOfficeManagementServiceClientImpl implements PostOfficeManagementServiceClient {

    @Override
    public boolean isPostOfficeAvailable(long id) {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://192.168.59.100:30163/post-office/" + id + "/availability";
        ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl, String.class);
        String responseJson = response.getBody();
        return Boolean.parseBoolean(responseJson);
    }
}
