package com.example.Forum_V1.service.dto;

import lombok.Data;

import java.util.Set;

@Data
public class ForumDTO {




    private Long id;
    private String slug;
    private String name;
    private String description;



    private Set<SubjectDTO> subject;
}
