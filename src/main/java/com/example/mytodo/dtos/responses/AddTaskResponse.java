package com.example.mytodo.dtos.responses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddToDoResponse {
    private String message ;
    private int taskCounter;
}
