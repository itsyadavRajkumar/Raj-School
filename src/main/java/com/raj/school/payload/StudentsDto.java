package com.raj.school.payload;

import lombok.*;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

//@Data
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class StudentsDto {
    private Long id;

    @NotEmpty
    @Size(min = 2, message = "Name should be at least 2 char")
    private String name;
    private String fatherName;
    private LocalDateTime DOB;
    private String department;
    private Long mobileNumber;
    private String emailId;
    private Long aadharCardNumber;
    private String address;
}
