package com.example.Forum_V1.service.serviceImpl;

import com.example.Forum_V1.model.Forum;
import com.example.Forum_V1.repository.ForumRepository;
import com.example.Forum_V1.service.ForumService;
import com.example.Forum_V1.service.dto.ForumDTO;
import com.example.Forum_V1.service.mapper.ForumMapper;
import com.example.Forum_V1.utils.SlugifyUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ForumServiceImpl implements ForumService {
    private final ForumRepository forumRepository;
    private final ForumMapper forumMapper;

    @Override
    public ForumDTO createForum(ForumDTO forumDTO) {
        log.debug("Creating forum: {}", forumDTO);
        Forum forum = forumMapper.toEntity(forumDTO);
        forum.setSlug(SlugifyUtils.generate(forum.getName()));
        forum = forumRepository.save(forum);
        return forumMapper.fromEntity(forum);
    }

    @Override
    public List<ForumDTO> getAllForums() {
        log.debug("Fetching all forums");
        return forumRepository.findAll().stream()
                .map(forumMapper::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ForumDTO getForumById(Long id) {
        log.debug("Fetching forum by id: {}", id);
        Forum forum = forumRepository.findById(id).orElse(null);
        return forum != null ? forumMapper.fromEntity(forum) : null;
    }

    @Override
    public ForumDTO getForumBySlug(String slug) {
        log.debug("Fetching forum by slug: {}", slug);
        Forum forum = forumRepository.findBySlug(slug).orElse(null);
        return forum != null ? forumMapper.fromEntity(forum) : null;
    }

    @Override
    public void deleteForum(Long id) {
        log.debug("Deleting forum by id: {}", id);
        forumRepository.deleteById(id);
    }

}

