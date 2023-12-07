package com.example.androidproapi.dto;
import com.example.androidproapi.constants.Category;
import com.example.androidproapi.dto.TaskDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {
     private Long id;
     private String board_name;
     private Category category;
     private String description;
     private String content;

    private List<TaskDto> tasks;

}
