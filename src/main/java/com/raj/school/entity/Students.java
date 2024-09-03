package com.raj.school.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "Students")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String fatherName;

    @Column(nullable = false)
    private LocalDateTime DOB;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private Long mobileNumber;

    @Email
    private String emailId;

    @Column(nullable = false, unique = true)
    private Long aadharCardNumber;

    @Column(nullable = false)
    private String address;

    public Students() {
        this.emailId = "xyz@gmail.com";
        this.aadharCardNumber = 987612437809L;
    }

}