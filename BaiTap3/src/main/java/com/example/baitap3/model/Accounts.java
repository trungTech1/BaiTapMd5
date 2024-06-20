package com.example.baitap3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@NoArgsConstructor      // contructor không tham số
@AllArgsConstructor     // constructor tất cả tham số
@Getter                 // getter
@Setter            // setter
@Builder           // builder dùng để tạo đối tượng dựa trên field
public class Accounts {
    @Id            // đánh dấu nó là primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // id tự động tăng
    private Integer id;
    private String fullName;
    private String address;
    private String phone;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
}