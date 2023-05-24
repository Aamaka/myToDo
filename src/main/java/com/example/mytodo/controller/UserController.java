package com.example.mytodo.controller;
import com.example.mytodo.dtos.requests.AddTaskRequest;
import com.example.mytodo.dtos.requests.CreateUserRequest;
import com.example.mytodo.dtos.requests.LoginUserRequest;
import com.example.mytodo.dtos.responses.AddTaskResponse;
import com.example.mytodo.dtos.responses.CreateUserResponse;
import com.example.mytodo.dtos.responses.LoginUserResponse;
import com.example.mytodo.exceptions.UserException;
import com.example.mytodo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RequestMapping("/api/v1/todo")
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public CreateUserResponse createUser(@RequestBody CreateUserRequest request) throws UserException {
        return userService.createAUser(request);
    }

    @GetMapping("/login")
    public LoginUserResponse login (@RequestBody LoginUserRequest request) throws UserException {
        return userService.login(request);
    }

    @PostMapping("/add")
    public AddTaskResponse addTask(@RequestBody AddTaskRequest request) throws UserException {
        return userService.addTask(request);
    }
}
