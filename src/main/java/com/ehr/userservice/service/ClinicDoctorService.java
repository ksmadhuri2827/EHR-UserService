package com.ehr.userservice.service;


import com.ehr.userservice.model.Clinic;
import com.ehr.userservice.model.ClinicDoctor;
import com.ehr.userservice.model.User;
import com.ehr.userservice.repository.ClinicDoctorRepository;
import com.ehr.userservice.repository.ClinicRepository;
import com.ehr.userservice.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClinicDoctorService {

    @Autowired
    private ClinicRepository clinicRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClinicDoctorRepository clinicDoctorRepository;

    public Clinic registerClinic(Clinic clinic) {
        if (clinicRepository.findByEmail(clinic.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Clinic email already exists.");
        }
        return clinicRepository.save(clinic);
    }

    public List<Clinic> listClinics() {
        return clinicRepository.findAll();
    }

    public ClinicDoctor assignDoctorToClinic(String clinicId, String doctorId) {
        Optional<Clinic> clinic = clinicRepository.findById(new ObjectId(clinicId));
        Optional<User> doctor = userRepository.findById(new ObjectId(doctorId));

        if (clinic.isPresent() && doctor.isPresent() && doctor.get().getUserType() == User.UserType.DOCTOR) {
            ClinicDoctor clinicDoctor = new ClinicDoctor();
            clinicDoctor.setClinic(clinic.get());
            clinicDoctor.setDoctor(doctor.get());
            return clinicDoctorRepository.save(clinicDoctor);
        }
        throw new IllegalArgumentException("Invalid Clinic ID or Doctor ID.");
    }

    public List<User> getDoctorsInClinic(String clinicId) {
        List<ClinicDoctor> clinicDoctors = clinicDoctorRepository.findByClinicId(new ObjectId(clinicId));

        return clinicDoctors.stream().map(ClinicDoctor::getDoctor).toList();
    }
}
