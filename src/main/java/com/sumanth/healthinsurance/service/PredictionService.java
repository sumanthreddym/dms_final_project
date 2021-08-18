package com.sumanth.healthinsurance.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sumanth.healthinsurance.dto.PredictionRequestDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PredictionService {
    final String uri = "http://localhost:5000/predict_kidney_disease";

    public String predictKidneyDisease(PredictionRequestDTO predictionRequestDTO){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ObjectMapper objectMapper = new ObjectMapper();

        HttpEntity<String> entity = null;
        try {
            entity = new HttpEntity<>(objectMapper.writeValueAsString(predictionRequestDTO), headers);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return restTemplate.postForObject(uri, entity, String.class);
    }
}
