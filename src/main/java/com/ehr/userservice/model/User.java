package com.ehr.userservice.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {
    public enum UserType {
        ADMIN,
        CLINIC,
        DOCTOR,
        PATIENT
    }

    @Id
    private ObjectId id;

    private String firstName;
    private String lastName;

    private String email;
    private String password;

    private String phoneNumber;

    private UserType userType;
    private Instant createdAt;
    private Instant updatedAt;
}



