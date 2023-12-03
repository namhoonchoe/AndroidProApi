package com.example.androidproapi.dto;

import com.example.androidproapi.constants.Progress;


import java.util.Date;

public class TaskDto {
    private Long id;
     private String task_title;
     private String task_description;
     private Date start_date;
     private Date due_date;
     private Progress Progress;
}
