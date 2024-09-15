package com.example.Forum_V1.service.serviceImpl;


import com.example.Forum_V1.model.Message;
import com.example.Forum_V1.model.Subject;
import com.example.Forum_V1.repository.MessageRepository;
import com.example.Forum_V1.repository.SubjectRepository;
import com.example.Forum_V1.service.MessageService;
import com.example.Forum_V1.service.dto.MessageDTO;
import com.example.Forum_V1.service.mapper.MessageMapper;
import com.example.Forum_V1.utils.SlugifyUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;
    private final SubjectRepository subjectRepository;
    private final MessageMapper messageMapper;

    @Override
    public MessageDTO createMessage(Long subjectId, MessageDTO messageDTO) {
        log.debug("Creating message: {} in subject with id: {}", messageDTO, subjectId);
        Subject subject = subjectRepository.findById(subjectId).orElse(null);
        if (subject == null) {
            throw new IllegalArgumentException("Subject not found");
        }


        Message message = messageMapper.toEntity(messageDTO);
        message.setSubject(subject);
        message.setSlug(SlugifyUtils.generate(message.getContent()));
        message.setCreatedAt(LocalDateTime.now()); // Set the current date and time
        message = messageRepository.save(message);
        return messageMapper.fromEntity(message);
    }

    @Override
    public List<MessageDTO> getAllMessagesBySubjectId(Long subjectId) {
        log.debug("Fetching all messages for subject with id: {}", subjectId);
        return messageRepository.findBySubjectId(subjectId).stream()
                .map(messageMapper::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<MessageDTO> getAllMessages() {
        log.debug("Fetching all messages");
        return messageRepository.findAll().stream()
                .map(messageMapper::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public MessageDTO getMessageById(Long id) {
        log.debug("Fetching message by id: {}", id);
        Message message = messageRepository.findById(id).orElse(null);
        return message != null ? messageMapper.fromEntity(message) : null;
    }

    @Override
    public MessageDTO getMessageBySlug(String slug) {
        log.debug("Fetching message by slug: {}", slug);
        Message message = messageRepository.findBySlug(slug).orElse(null);
        return message != null ? messageMapper.fromEntity(message) : null;
    }

    @Override
    public void deleteMessage(Long id) {
        log.debug("Deleting message by id: {}", id);
        messageRepository.deleteById(id);
    }
}
