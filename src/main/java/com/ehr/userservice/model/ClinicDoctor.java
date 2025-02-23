package com.ehr.userservice.model;


import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "clinic_doctors")
public class ClinicDoctor {

    @Id
    private ObjectId id;

    @DBRef
    private Clinic clinic;

    @DBRef
    private User doctor;
}
