package com.example.Forum_V1.repository;

import com.example.Forum_V1.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findBySubjectId(Long subjectId);
    Optional<Message> findBySlug(String slug);
}
