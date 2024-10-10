package com.kora.healthdataservice.AnxietyBiometricData.domain.persistence;

import com.kora.healthdataservice.AnxietyBiometricData.domain.model.entity.PhysiologicalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PhysiologicalDataRepository extends JpaRepository<PhysiologicalData,Integer> {

    Optional<PhysiologicalData> findById(Integer physiologicalDataId);

    List<PhysiologicalData> findByPatientId(Integer patientId);
}
