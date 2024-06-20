package com.example.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder


public class Personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fullName;
    private String email;
    private String address;
    private String departmentName;
    private LocalDate dateOfBirth;
    private Boolean status = true;


}
