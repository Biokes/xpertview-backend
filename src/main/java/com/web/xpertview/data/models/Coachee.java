package com.web.xpertview.data.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.web.xpertview.utils.Utilities.generateTrackingNumber;
import static java.time.LocalDateTime.now;

@Setter
@Getter
@ToString
@Document(collection="coaching_customers")
public class Coachee {
    @Id
    private String id;
    private String fullName;
    private String phoneNumber;
    private LocalDate proposedDate;
    private String message;
    @Setter(AccessLevel.NONE)
    private LocalDateTime timeBooked=now();
    @Setter(AccessLevel.NONE)
    private String trackingNumber = "CCO"+generateTrackingNumber();
}
