package com.kora.identityaccessservice.Authentication.domain.persistence;

import com.kora.identityaccessservice.Authentication.domain.model.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {
    Optional<Patient> findById(Integer patientId);

}
