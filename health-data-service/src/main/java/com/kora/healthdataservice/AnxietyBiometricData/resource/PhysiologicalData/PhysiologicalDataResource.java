package com.kora.healthdataservice.AnxietyBiometricData.resource.PhysiologicalData;

import com.kora.healthdataservice.AnxietyBiometricData.domain.model.entity.External.Patient;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class PhysiologicalDataResource {
    private Integer id;
    private Patient patient;
    private Integer heartRate;
    private Integer bloodOxygen;
    private Integer sleepHours;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
