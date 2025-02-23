package com.ehr.userservice.repository;

import com.ehr.userservice.model.Clinic;
import com.ehr.userservice.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClinicRepository extends MongoRepository<Clinic, ObjectId> {


    Optional<Clinic> findByEmail(String email);
}
