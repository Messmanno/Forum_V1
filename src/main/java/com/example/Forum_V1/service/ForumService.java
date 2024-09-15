package com.example.Forum_V1.service;

import com.example.Forum_V1.service.dto.ForumDTO;

import java.util.List;


public interface ForumService {

    ForumDTO createForum(ForumDTO forumDTO);
    List<ForumDTO> getAllForums();
    ForumDTO getForumById(Long id);
    ForumDTO getForumBySlug(String slug);
    void deleteForum(Long id);
}
