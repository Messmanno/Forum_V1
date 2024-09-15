package com.example.Forum_V1.service;


import com.example.Forum_V1.service.dto.MessageDTO;

import java.util.List;

public interface MessageService {

     MessageDTO createMessage(Long subjectId, MessageDTO messageDTO);
     List<MessageDTO> getAllMessagesBySubjectId(Long subjectId);
     List<MessageDTO> getAllMessages();
     MessageDTO getMessageById(Long id);
     MessageDTO getMessageBySlug(String slug);
     void deleteMessage(Long id);


}
