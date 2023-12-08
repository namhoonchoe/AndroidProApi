package com.example.androidproapi.dto;

import com.example.androidproapi.constants.Progress;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    private Long id;
     private String task_title;
     private String task_description;
     private Date start_date;
     private Date due_date;
     private Progress Progress;
}
