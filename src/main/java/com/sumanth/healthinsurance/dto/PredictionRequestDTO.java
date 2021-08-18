package com.sumanth.healthinsurance.dto;

import com.sumanth.healthinsurance.model.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;

@Data
@AllArgsConstructor
public class PredictionRequestDTO {
    private Double age;
    private Double bloodPressure;
    private Double specificGravity;
    private Integer albumin;
    private Integer sugar;
    private Integer redBloodCells;
    private Integer pusCell;
    private Integer pusCellClumps;
    private Integer bacteria;
    private Double bloodGlucoseRandom;
    private Double bloodUrea;
    private Double serumCreatinine;
    private Double sodium;
    private Double potassium;
    private Double haemoglobin;
    private Double packedCellVolume;
    private Double whiteBloodCellCount;
    private Double redBloodCellCount;
    private Double hypertension;
    private Double diabetesMellitus;
    private Double coronaryArteryDisease;
    private Double appetite;
    private Double pedalEdema;
    private Double anemia;
}
