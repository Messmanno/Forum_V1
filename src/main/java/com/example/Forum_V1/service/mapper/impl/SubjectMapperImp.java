package com.example.Forum_V1.service.mapper.impl;


import com.example.Forum_V1.model.Subject;
import com.example.Forum_V1.service.dto.SubjectDTO;
import com.example.Forum_V1.service.mapper.SubjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;



@Component
@RequiredArgsConstructor
@Slf4j
public class SubjectMapperImp implements SubjectMapper {

    private final ModelMapper modelMapper;

    @Override
    public SubjectDTO fromEntity(Subject entity) {
        log.debug("Mapping Subject to SubjectDTO");
        return modelMapper.map(entity, SubjectDTO.class);
    }

    @Override
    public Subject toEntity(SubjectDTO dto) {
        log.debug("Mapping SubjectDTO to Subject");
        return modelMapper.map(dto, Subject.class);
    }
}
