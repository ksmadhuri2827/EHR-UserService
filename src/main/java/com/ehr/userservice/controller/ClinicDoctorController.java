package com.ehr.userservice.controller;


import com.ehr.userservice.model.Clinic;
import com.ehr.userservice.model.ClinicDoctor;
import com.ehr.userservice.model.User;
import com.ehr.userservice.service.ClinicDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clinics")
public class ClinicDoctorController {

    @Autowired
    private ClinicDoctorService clinicDoctorService;

    @PostMapping
    public ResponseEntity<?> registerClinic(@RequestBody Clinic clinic) {
        try {
            return ResponseEntity.ok(clinicDoctorService.registerClinic(clinic));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Clinic>> listClinics() {
        return ResponseEntity.ok(clinicDoctorService.listClinics());
    }

    @PostMapping("/{clinicId}/doctors")
    public ResponseEntity<?> assignDoctorToClinic(@PathVariable String clinicId, @RequestParam String doctorId) {
        try {
            return ResponseEntity.ok(clinicDoctorService.assignDoctorToClinic(clinicId, doctorId));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{clinicId}/doctors")
    public ResponseEntity<?> getDoctorsInClinic(@PathVariable String clinicId) {
        List<User> doctors = clinicDoctorService.getDoctorsInClinic(clinicId);
        if (doctors.isEmpty()) {
            return ResponseEntity.ok("No doctors assigned to this clinic.");
        }
        return ResponseEntity.ok(doctors);
    }
}
