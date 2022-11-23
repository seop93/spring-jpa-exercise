package com.jpa.exercise.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Book {

    @Id
    private Long id;
    private String name;
    //private Long authorId;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

}
