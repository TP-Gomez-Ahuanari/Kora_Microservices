package com.kora.healthdataservice.AnxietyBiometricData.domain.model.entity.External;

import jakarta.persistence.Column;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    private Integer id;
    private String fullName;
    private String email;
    private String photoUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
