package com.example.mytodo.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddToDORequest {
    private String task;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime timeTaskAdded = LocalDateTime.now();

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime setTaskDate;

}
