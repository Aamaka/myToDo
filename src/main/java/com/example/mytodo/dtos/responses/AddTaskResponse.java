package com.example.mytodo.dtos.responses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddTaskResponse {
    private String message ;
    private long taskCounter;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime timeTaskAdded = LocalDateTime.now();
}
