package com.kora.identityaccessservice.Authentication.service;

import com.kora.healthdataservice.Shared.Exception.ResourceNotFoundException;
import com.kora.healthdataservice.Shared.Exception.ResourceValidationException;
import com.kora.identityaccessservice.Authentication.domain.model.entity.Patient;
import com.kora.identityaccessservice.Authentication.domain.persistence.PatientRepository;
import com.kora.identityaccessservice.Authentication.domain.service.PatientService;
import com.kora.identityaccessservice.Authentication.resource.CreatePatientResource;
import com.kora.identityaccessservice.Authentication.resource.UpdatePatientResource;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PatientServiceImpl implements PatientService {
    private static final String ENTITY = "Patient";
    private final PatientRepository patientRepository;
    private final Validator validator;

    public PatientServiceImpl(PatientRepository patientRepository, Validator validator) {
        this.patientRepository = patientRepository;
        this.validator = validator;
    }


    @Override
    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    @Override
    public Page<Patient> getAll(Pageable pageable) {
        return patientRepository.findAll(pageable);
    }

    @Override
    public Patient getById(Integer patientId) {
        return patientRepository.findById(patientId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, patientId));
    }

    @Override
    public Patient create(String jwt, CreatePatientResource patientResource) {
        Set<ConstraintViolation<CreatePatientResource>> violations = validator.validate(patientResource);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);


        Patient patient = new Patient();
        patient.setFullName(patientResource.getFullName());
        patient.setEmail(patientResource.getEmail());
        patient.setPhotoUrl(patientResource.getPhotoUrl());

        return patientRepository.save(patient);
    }

    @Override
    public Patient update(String jwt, Integer patientId, UpdatePatientResource request) {
        Patient patient = getById(patientId);

        if(patient == null)
            throw new ResourceValidationException(ENTITY,
                    "Not found Patient with ID:"+ patientId);

        if (request.getFullName() != null) {
            patient.setFullName(request.getFullName());
        }
        if (request.getEmail() != null) {
            patient.setEmail(request.getEmail());
        }
        if (request.getPhotoUrl() != null) {
            patient.setPhotoUrl(request.getPhotoUrl());
        }
        return patientRepository.save(patient);
    }

    @Override
    public ResponseEntity<?> delete(String jwt, Integer patientId) {
        return patientRepository.findById(patientId).map(patient -> {
            patientRepository.delete(patient);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, patientId));
    }
}
