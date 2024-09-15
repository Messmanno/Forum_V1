package com.example.Forum_V1.service.dto;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageDTO {

    private Long id;
    private String content;
    private String slug;
    private LocalDateTime createdAt;
    private Long subjectId;
}
