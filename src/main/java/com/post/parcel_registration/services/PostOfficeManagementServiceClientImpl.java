package com.post.parcel_registration.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PostOfficeManagementServiceClientImpl implements PostOfficeManagementServiceClient{

    @Override
    public boolean isPostOfficeAvailable(long postOfficeId) {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://localhost:8081/isPostOfficeAvailable/"+postOfficeId;
        ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl, String.class);
        String responseJson = response.getBody();
        return Boolean.parseBoolean(responseJson);
    }
}
