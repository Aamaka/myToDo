package com.example.mytodo.data.repository;

import com.example.mytodo.data.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
