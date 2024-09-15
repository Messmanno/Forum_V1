package com.example.Forum_V1.repository;

import com.example.Forum_V1.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    List<Subject> findByForumId(Long forumId);
    Optional<Subject> findBySlug(String slug);
}
