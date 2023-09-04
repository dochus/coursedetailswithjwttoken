package com.course.courseDemo.dto;

import com.course.courseDemo.validator.StringNotBlank;
import com.course.courseDemo.validator.ValidEmail;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class StudentDetailsDto {
    @StringNotBlank(message = "Full Name should not be empty or null.")
    @Pattern(regexp = "[a-zA-Z& ]+", message = "Invalid First Name.")
    @Size(min = 1, max = 255, message = "Full Name length must be between 1 to 255 characters.")
    private String fullName;
    @StringNotBlank(message = "Email Address should not be empty or null.")
    @ValidEmail(message = "Invalid email address value")
    private String emailAddress;
    private String telephone;
    @StringNotBlank(message = "Address should not be empty or null.")
    private String address;

    private UUID courseId;
    private UUID id;

}
