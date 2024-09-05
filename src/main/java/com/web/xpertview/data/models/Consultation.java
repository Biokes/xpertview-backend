package com.web.xpertview.data.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

import static com.web.xpertview.utils.Utilities.generateTrackingNumber;
import static java.time.LocalDateTime.now;


@Setter
@Getter
@Document(collection = "consultation_customers")
public class Consultation {
    @Id
    private String id;
    private String fullName;
    private String message;
    private String phoneNumber;
    private LocalDateTime proposedDate;
    @Setter(AccessLevel.NONE)
    private LocalDateTime timeSaved = now();
    private String trackingNumber= "COC"+ generateTrackingNumber();
}
