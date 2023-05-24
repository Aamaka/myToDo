package com.example.mytodo.service;
import com.example.mytodo.dtos.requests.AddTaskRequest;
import com.example.mytodo.dtos.requests.CreateUserRequest;
import com.example.mytodo.dtos.requests.LoginUserRequest;
import com.example.mytodo.dtos.responses.AddTaskResponse;
import com.example.mytodo.dtos.responses.CreateUserResponse;
import com.example.mytodo.dtos.responses.LoginUserResponse;
import com.example.mytodo.exceptions.UserException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    @DisplayName("create a user")
    public void createAUserTest() throws UserException {
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setName("Sam");
        createUserRequest.setUserName("son");
        createUserRequest.setEmail("sam@gmail.com");
        createUserRequest.setPassword("3888");
        createUserRequest.setConfirmPassword("3888");
        CreateUserResponse response = userService.createAUser(createUserRequest);
        assertNotNull(response);
        assertEquals("Sam, your registration was successful", response.getMessage());
    }

    @Test
    @DisplayName("login user")
    public void loginUser() throws UserException {
        LoginUserRequest request = new LoginUserRequest();
        request.setEmail("amaka@gmail.com");
        request.setPassword("3456");
        LoginUserResponse response = userService.login(request);
        assertEquals("Welcome back Ademola", response.getMessage());
    }

    @Test
    @DisplayName("Add a task")
    public void testThatAUserCanAddATask() throws UserException {
        AddTaskRequest addTaskRequest = new AddTaskRequest();
        addTaskRequest.setEmail("sam@gmail.com");
        addTaskRequest.setTask("Slap jump");
        addTaskRequest.setTaskTitle("Violence");
        addTaskRequest.setTaskDate("2023-09-01 16:25");
        AddTaskResponse response = userService.addTask(addTaskRequest);

        assertEquals("Successfully added Violence to your task board",response.getMessage());
        assertEquals(5,response.getTaskCounter());

    }

}