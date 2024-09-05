package com.web.xpertview.dto.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Setter
@Getter
@Builder
public class CoachingRequest {
    @Pattern(regexp = "^(\\+?[0-9]{11,14})|(\\d{11})$", message = "Invalid phone number")
    private String phoneNumber;
    @Pattern(regexp = "[a-zA-Z ]{5,}")
    private String fullName;
    @NotBlank(message = "Message cannot be Blank")
    private String message;
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @NotNull(message= "proposed Date is required")
    private LocalDate proposedDate;
}
