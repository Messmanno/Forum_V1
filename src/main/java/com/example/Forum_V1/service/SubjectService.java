package com.example.Forum_V1.service;


import com.example.Forum_V1.service.dto.SubjectDTO;

import java.util.List;

public interface SubjectService {

     SubjectDTO createSubject(Long forumId, SubjectDTO subjectDTO);
     List<SubjectDTO> getAllSubjectsByForumId(Long forumId);
     List<SubjectDTO> getAllSubjects();
     SubjectDTO getSubjectById(Long id);
     SubjectDTO getSubjectBySlug(String slug);
     void deleteSubject(Long id);
}
