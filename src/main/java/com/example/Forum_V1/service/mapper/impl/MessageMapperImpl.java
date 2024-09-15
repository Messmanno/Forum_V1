package com.example.Forum_V1.service.mapper.impl;


import com.example.Forum_V1.model.Message;
import com.example.Forum_V1.service.dto.MessageDTO;
import com.example.Forum_V1.service.mapper.MessageMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
public class MessageMapperImpl implements MessageMapper {

    private final ModelMapper modelMapper;


    @Override
    public MessageDTO fromEntity(Message entity) {
        log.debug("Mapping Message to MessageDTO");
        return modelMapper.map(entity, MessageDTO.class);
    }
    @Override
    public Message toEntity(MessageDTO dto) {
        log.debug("Mapping MessageDTO to Message");
        return modelMapper.map(dto, Message.class);
    }
}
