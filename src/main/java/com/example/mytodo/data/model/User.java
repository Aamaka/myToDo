package com.example.mytodo.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;

import javax.validation.constraints.Email;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String userName;

    @Email
    @Column(unique = true)
    private String email;
    private String password;
    private String confirmPassword;



    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime localDateTime = LocalDateTime.now();


}
