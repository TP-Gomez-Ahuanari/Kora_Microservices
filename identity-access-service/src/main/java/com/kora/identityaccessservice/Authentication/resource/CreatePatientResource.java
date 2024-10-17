package com.kora.identityaccessservice.Authentication.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreatePatientResource {
    private Integer id;
    private String fullName;
    private String email;
    private String photoUrl;
}
