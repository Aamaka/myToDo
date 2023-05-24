package com.example.mytodo.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {

    private String name;
    private String userName;
    @Email
    private String email;
    private String password;
    private String confirmPassword;

}
