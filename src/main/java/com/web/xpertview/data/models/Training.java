package com.web.xpertview.data.models;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@Document(collection = "Training_customers")
public class Training {
    @Id
    private String id;
    @JsonProperty(value = "fullname")
    private String fullName;
    private String message;
    private String phoneNumber;
    @Setter(AccessLevel.NONE)
    private LocalDateTime timeSaved = now();
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @Setter(AccessLevel.NONE)
    private String trackingNumber = "Tr" + generateTrackingNumber();
}
