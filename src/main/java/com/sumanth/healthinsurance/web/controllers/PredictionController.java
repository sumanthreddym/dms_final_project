package com.sumanth.healthinsurance.web.controllers;

import com.sumanth.healthinsurance.dto.PredictionRequestDTO;
import com.sumanth.healthinsurance.service.PredictionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequestMapping("/prediction")
public class PredictionController {

    PredictionService predictionService;

    @Autowired
    public PredictionController(PredictionService predictionService){
        this.predictionService = predictionService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createQuoteRequest(@RequestBody PredictionRequestDTO predictionRequestDTO){
        return new ResponseEntity<>(predictionService.predictKidneyDisease(predictionRequestDTO), HttpStatus.OK);
    }
}
