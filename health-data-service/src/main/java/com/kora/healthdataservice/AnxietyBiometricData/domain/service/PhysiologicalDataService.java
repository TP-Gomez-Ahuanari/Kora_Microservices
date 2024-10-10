package com.kora.healthdataservice.AnxietyBiometricData.domain.service;

import com.kora.healthdataservice.AnxietyBiometricData.domain.model.entity.PhysiologicalData;
import com.kora.healthdataservice.AnxietyBiometricData.resource.PhysiologicalData.CreatePhysiologicalDataResource;
import com.kora.healthdataservice.AnxietyBiometricData.resource.PhysiologicalData.UpdatePhysiologicalDataResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PhysiologicalDataService {
    List<PhysiologicalData> getAll();
    Page<PhysiologicalData> getAll(Pageable pageable);
    PhysiologicalData getById(Integer physiologicalDataId);

    List<PhysiologicalData> getByPatientId(Integer patientId);

    PhysiologicalData create(String jwt, CreatePhysiologicalDataResource physiologicalDataResource);
    PhysiologicalData update(String jwt, Integer physiologicalDataId, UpdatePhysiologicalDataResource request);
    ResponseEntity<?> delete(String jwt, Integer physiologicalDataId);
}
