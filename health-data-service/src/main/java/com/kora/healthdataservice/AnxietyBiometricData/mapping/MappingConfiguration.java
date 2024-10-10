package com.kora.healthdataservice.AnxietyBiometricData.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("healthDataMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public PhysiologicalDataMapper certificationMapper() { return new PhysiologicalDataMapper();}
}
