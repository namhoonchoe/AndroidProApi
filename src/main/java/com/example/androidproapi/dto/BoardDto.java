package com.example.androidproapi.dto;
import com.example.androidproapi.constants.Category;
import com.example.androidproapi.dto.TaskDto;

import java.util.List;

public class BoardDto {
    private Long id;
     private String board_name;
     private Category category;
     private String description;
     private String content;

    private List<TaskDto> tasks;

}
