package com.example.Forum_V1.model;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "forums")
@Data
public class Forum implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String slug;

    @OneToMany(mappedBy = "forum", cascade = CascadeType.ALL)
    private List<Subject> sujets;
}
