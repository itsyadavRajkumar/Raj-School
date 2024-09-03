package com.raj.school.payload;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeachersDto {
    private Long id;
    private String name;
    private String fatherName;
    private LocalDateTime DOB;
    private Long mobileNumber;
    private String emailId;
    private String address;
    private Long aadharCardNumber;
}
