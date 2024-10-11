package com.kora.healthdataservice.AnxietyBiometricData.domain.persistence;

import com.kora.healthdataservice.AnxietyBiometricData.domain.model.entity.AnxietyAssessment;
import com.kora.healthdataservice.AnxietyBiometricData.domain.model.entity.PhysiologicalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnxietyAssessmentRepository extends JpaRepository<AnxietyAssessment,Integer> {

    Optional<AnxietyAssessment> findById(Integer anxietyAssessmentId);

    List<AnxietyAssessment> findByPatientId(Integer patientId);
}
