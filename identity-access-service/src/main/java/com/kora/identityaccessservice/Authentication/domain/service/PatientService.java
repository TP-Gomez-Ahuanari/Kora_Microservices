package com.kora.identityaccessservice.Authentication.domain.service;

import com.kora.identityaccessservice.Authentication.domain.model.entity.Patient;
import com.kora.identityaccessservice.Authentication.resource.CreatePatientResource;
import com.kora.identityaccessservice.Authentication.resource.UpdatePatientResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PatientService {
    List<Patient> getAll();
    Page<Patient> getAll(Pageable pageable);
    Patient getById(Integer patientId);
    Patient create(String jwt, CreatePatientResource patientResource);
    Patient update(String jwt, Integer patientId, UpdatePatientResource request);
    ResponseEntity<?> delete(String jwt, Integer patientId);

}
