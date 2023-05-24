package com.example.mytodo.service;
import com.example.mytodo.data.model.Task;
import com.example.mytodo.data.model.User;
import com.example.mytodo.data.repository.TaskRepository;
import com.example.mytodo.data.repository.UserRepository;
import com.example.mytodo.dtos.requests.AddTaskRequest;
import com.example.mytodo.dtos.requests.CreateUserRequest;
import com.example.mytodo.dtos.requests.LoginUserRequest;
import com.example.mytodo.dtos.responses.AddTaskResponse;
import com.example.mytodo.dtos.responses.CreateUserResponse;
import com.example.mytodo.dtos.responses.LoginUserResponse;
import com.example.mytodo.exceptions.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private  TaskRepository taskRepository;


    @Override
    public CreateUserResponse createAUser(CreateUserRequest request) throws UserException {
        if(userRepository.existsByEmail(request.getEmail())) throw  new UserException("User already exist", HttpStatus.NO_CONTENT);
        User user = User.builder()
                .name(request.getName())
                .userName(request.getUserName())
                .email(request.getEmail())
                .password(request.getPassword())
                .confirmPassword(request.getConfirmPassword())
                .build();

        if(request.getPassword().equals(request.getConfirmPassword())){
            User saved = userRepository.save(user);
            CreateUserResponse response = new CreateUserResponse();
            response.setMessage(saved.getName() + ", your registration was successful");
            return response;
        }
        throw new UserException("Password does not match", HttpStatus.NOT_ACCEPTABLE);

    }

    @Override
    public LoginUserResponse login(LoginUserRequest request) throws UserException {
            Optional<User> user = userRepository.findUserByEmail(request.getEmail());
            if (user.isPresent()) {
                if (user.get().getPassword().equals(request.getPassword())) {
                    LoginUserResponse loginUserResponse = new LoginUserResponse();
                    loginUserResponse.setMessage("Welcome back " + user.get().getUserName());
                    return loginUserResponse;
                } else {
                    throw new UserException("Invalid details", HttpStatus.NOT_ACCEPTABLE);
                }

            } else {
                throw new UserException("User does not exist", HttpStatus.NOT_FOUND);
            }

    }


    @Override
    public AddTaskResponse addTask(AddTaskRequest request) throws UserException {

        Optional<User> user = userRepository.findUserByEmail(request.getEmail());
        if(user.isPresent()){
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            Task task = Task.builder()
                    .taskDate(LocalDateTime.parse(request.getTaskDate(), dateTimeFormatter))
                    .task(request.getTask())
                    .taskTitle(request.getTaskTitle())
                    .user_id(user.get())
                    .build();
            Task saved = taskRepository.save(task);
            AddTaskResponse response = new AddTaskResponse();
            response.setMessage("Successfully added "+ saved.getTaskTitle() + " to your task board");
            response.setTaskCounter(taskRepository.count());
            return response;
        }
      throw new UserException("user does not exist", HttpStatus.NOT_FOUND);
    }
}
