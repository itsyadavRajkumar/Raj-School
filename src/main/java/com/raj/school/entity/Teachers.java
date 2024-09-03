package com.raj.school.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "Teachers")
public class Teachers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String fatherName;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime DOB;

    @NotNull
    @Column(nullable = false)
    private Long mobileNumber;

    @Email
    private String emailId;

    @NotNull
    @Column(nullable = false)
    private String address;

    private Long aadharCardNumber;

    public Teachers() {
        this.emailId = "xyz@gmail.com";
        this.aadharCardNumber = 987612437809L;
    }

}
