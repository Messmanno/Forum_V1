package com.example.Forum_V1.service.dto;

import lombok.Data;

import java.util.List;


@Data
public class SubjectDTO {

    private Long id;
    private String title;
    private String slug;
    private List<MessageDTO> messages;
}
