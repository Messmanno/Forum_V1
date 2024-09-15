package com.example.Forum_V1.service.mapper;

public interface EntityMapper<D, E> {
    D fromEntity(E entity);
    E toEntity(D dto);
}