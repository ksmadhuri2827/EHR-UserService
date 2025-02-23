package com.ehr.userservice.model;



import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "clinics")
public class Clinic {

    @Id
    private ObjectId id;

    private String name;
    private String address;
    private String phoneNumber;
    private String email;
}

