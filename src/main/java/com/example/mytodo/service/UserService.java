package com.example.mytodo.service;
import com.example.mytodo.dtos.requests.AddTaskRequest;
import com.example.mytodo.dtos.requests.CreateUserRequest;
import com.example.mytodo.dtos.requests.LoginUserRequest;
import com.example.mytodo.dtos.responses.AddTaskResponse;
import com.example.mytodo.dtos.responses.CreateUserResponse;
import com.example.mytodo.dtos.responses.LoginUserResponse;
import com.example.mytodo.exceptions.UserException;

public interface UserService {
    CreateUserResponse createAUser(CreateUserRequest request) throws UserException;
    LoginUserResponse login(LoginUserRequest request) throws UserException;

    AddTaskResponse addTask (AddTaskRequest request) throws UserException;
}
