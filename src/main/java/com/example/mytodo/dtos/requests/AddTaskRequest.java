package com.example.mytodo.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddTaskRequest {

    private String email;
    private String task;
    private String taskTitle;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private String taskDate;

}
