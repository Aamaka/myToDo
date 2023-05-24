package com.example.mytodo.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long taskId;
    private String task;
    private String taskTitle;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime taskDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime dateTaskAdded = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private  User user_id;
}
