package com.kora.healthdataservice.AnxietyBiometricData.resource.AnxietyAssessment;

import com.kora.healthdataservice.AnxietyBiometricData.domain.model.entity.External.Patient;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class AnxietyAssessmentResource {
    private Integer id;
    private Patient patient;
    private Integer staiScore;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
