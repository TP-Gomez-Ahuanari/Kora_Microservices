package com.kora.healthdataservice.AnxietyBiometricData.resource.AnxietyAssessment;

import com.kora.healthdataservice.AnxietyBiometricData.domain.model.entity.External.Patient;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateAnxietyAssessmentResource {
    private Integer id;
    private Integer staiScore;
}
