package com.ehr.userservice.repository;

import com.ehr.userservice.model.Clinic;
import com.ehr.userservice.model.ClinicDoctor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClinicDoctorRepository extends MongoRepository<ClinicDoctor, ObjectId> {


    List<ClinicDoctor> findByClinicId(ObjectId objectId);
}
