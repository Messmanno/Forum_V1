package com.example.Forum_V1.service.mapper.impl;


import com.example.Forum_V1.model.Forum;
import com.example.Forum_V1.service.dto.ForumDTO;
import com.example.Forum_V1.service.mapper.ForumMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ForumMapperImpl implements ForumMapper {

    private final ModelMapper modelMapper;

    @Override
    public ForumDTO fromEntity(Forum entity) {
        log.debug("Mapping Forum to ForumDTO");
        return modelMapper.map(entity, ForumDTO.class);
    }

    @Override
    public Forum toEntity(ForumDTO dto) {
        log.debug("Mapping ForumDTO to Forum");
        return modelMapper.map(dto, Forum.class);
    }
}
