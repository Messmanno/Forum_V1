package com.example.Forum_V1.service.serviceImpl;

import com.example.Forum_V1.model.Forum;
import com.example.Forum_V1.model.Subject;
import com.example.Forum_V1.repository.ForumRepository;
import com.example.Forum_V1.repository.SubjectRepository;
import com.example.Forum_V1.service.SubjectService;
import com.example.Forum_V1.service.dto.SubjectDTO;
import com.example.Forum_V1.service.mapper.SubjectMapper;
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
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;
    private final ForumRepository forumRepository;
    private final SubjectMapper subjectMapper;

    @Override
    public SubjectDTO createSubject(Long forumId, SubjectDTO subjectDTO) {
        log.debug("Creating subject: {} in forum with id: {}", subjectDTO, forumId);
        Forum forum = forumRepository.findById(forumId).orElse(null);
        if (forum == null) {
            throw new IllegalArgumentException("Forum not found");
        }
        Subject subject = subjectMapper.toEntity(subjectDTO);
        subject.setForum(forum);

        subject.setSlug(SlugifyUtils.generate(subject.getTitle()));
        subject = subjectRepository.save(subject);
        return subjectMapper.fromEntity(subject);
    }

    @Override
    public List<SubjectDTO> getAllSubjectsByForumId(Long forumId) {
        log.debug("Fetching all subjects for forum with id: {}", forumId);
        return subjectRepository.findByForumId(forumId).stream()
                .map(subjectMapper::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<SubjectDTO> getAllSubjects() {
        log.debug("Fetching all subjects");
        return subjectRepository.findAll().stream()
                .map(subjectMapper::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public SubjectDTO getSubjectById(Long id) {
        log.debug("Fetching subject by id: {}", id);
        com.example.Forum_V1.model.Subject subject = subjectRepository.findById(id).orElse(null);
        return subject != null ? subjectMapper.fromEntity(subject) : null;
    }

    @Override
    public SubjectDTO getSubjectBySlug(String slug) {
        log.debug("Fetching subject by slug: {}", slug);
        Subject subject = subjectRepository.findBySlug(slug).orElse(null);
        return subject != null ? subjectMapper.fromEntity(subject) : null;
    }

    @Override
    public void deleteSubject(Long id) {
        log.debug("Deleting subject by id: {}", id);
        subjectRepository.deleteById(id);
    }
}
