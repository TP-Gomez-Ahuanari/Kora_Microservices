package com.kora.identityaccessservice.Authentication.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("identityAccessMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public PatientMapper patientMapper() { return new PatientMapper();}
}
