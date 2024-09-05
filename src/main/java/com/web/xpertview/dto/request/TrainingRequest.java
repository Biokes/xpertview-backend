package com.web.xpertview.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TrainingRequest {
    @Pattern(regexp = "^(\\+?[0-9]{11,14})|(\\d{11})$", message = "Invalid phone number")
    private String phoneNumber;
    @Pattern(regexp = "[a-zA-Z ]{5,}", message="Name is too short")
    private String fullName;
    @NotBlank(message = "Message cannot be Blank")
    private String message;
}
