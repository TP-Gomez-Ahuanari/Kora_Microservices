package com.kora.identityaccessservice.Authentication.api.rest;


import com.kora.identityaccessservice.Authentication.domain.service.PatientService;
import com.kora.identityaccessservice.Authentication.mapping.PatientMapper;
import com.kora.identityaccessservice.Authentication.resource.CreatePatientResource;
import com.kora.identityaccessservice.Authentication.resource.PatientResource;
import com.kora.identityaccessservice.Authentication.resource.UpdatePatientResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/identity-access/patients", produces = "application/json")
@Tag(name = "Patients", description = "Patients operations: listing, retrieval, creation, update, and deletion")
public class PatientController {

    private final PatientService patientService;
    private final PatientMapper mapper;

    public PatientController(PatientService patientService, PatientMapper mapper) {
        this.patientService = patientService;
        this.mapper = mapper;
    }


    @Operation(summary = "Get all patients", description = "Returns patients list")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully got"),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", description = "Not Found", content = { @Content(schema = @Schema()) })
    })
    @GetMapping
    public Page<PatientResource> getAllPatients(@Parameter(hidden = true) @RequestHeader("Authorization") String jwt, Pageable pageable) {
        return mapper.modelListPage(patientService.getAll(), pageable);
    }

    @Operation(summary = "Get patient by id", description = "Returns patient with a provided id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully got"),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", description = "Not Found", content = { @Content(schema = @Schema()) })
    })
    @GetMapping("{patientId}")
    public PatientResource getPatientById(
            @Parameter(hidden = true) @RequestHeader("Authorization") String jwt,
            @Parameter(description = "Patient Id", required = true, examples = @ExampleObject(name = "patientId", value = "1")) @PathVariable Integer patientId
    ) {
        return mapper.toResource(patientService.getById(patientId));
    }

    @Operation(summary = "Create patient", description = "Register a patient")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created"),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", description = "Not Found", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = { @Content(schema = @Schema()) })
    })
    @PostMapping
    public ResponseEntity<PatientResource> createPatient(
            //@Parameter(hidden = true) @RequestHeader("Authorization") String jwt,
            //@RequestBody CreateCertificationResource resource) {
            //return new ResponseEntity<>(mapper.toResource(certificationService.create(jwt, resource)), HttpStatus.CREATED);
            @RequestBody CreatePatientResource resource,
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            authorizationHeader = authorizationHeader.substring(7);
        }
        return new ResponseEntity<>(mapper.toResource(patientService.create(authorizationHeader,(resource))), HttpStatus.CREATED);
    }


    @Operation(summary = "Update a patient partially", description = "Updates a patient partially based on the provided data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated"),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", description = "Not Found", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = { @Content(schema = @Schema()) })
    })
    @PatchMapping("{patientId}")
    public ResponseEntity<PatientResource> patchPatient(
            @Parameter(hidden = true) @RequestHeader("Authorization") String jwt,
            @Parameter(description = "Patient Id", required = true, examples = @ExampleObject(name = "patientId", value = "1")) @PathVariable Integer patientId,
            @RequestBody UpdatePatientResource request
    ) {
        return new ResponseEntity<>(mapper.toResource(patientService.update(jwt, patientId,request)), HttpStatus.CREATED);
    }

    @Operation(summary = "Delete a patient", description = "Delete a patient with a provided id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted"),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", description = "Not Found", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = { @Content(schema = @Schema()) })
    })
    @DeleteMapping("{patientId}")
    public ResponseEntity<?> deletePatient(
            @Parameter(hidden = true) @RequestHeader("Authorization") String jwt,
            @Parameter(description = "Patient Id", required = true, examples = @ExampleObject(name = "patientId", value = "1")) @PathVariable Integer patientId) {
        return patientService.delete(jwt, patientId);
    }
}
