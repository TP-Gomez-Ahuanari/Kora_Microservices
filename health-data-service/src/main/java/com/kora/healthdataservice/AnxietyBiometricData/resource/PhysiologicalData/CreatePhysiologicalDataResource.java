package com.kora.healthdataservice.AnxietyBiometricData.resource.PhysiologicalData;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreatePhysiologicalDataResource {
    private Integer id;
    private Integer heartRate;
    private Integer bloodOxygen;
    private Integer sleepHours;
}
