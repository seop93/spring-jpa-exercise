package com.jpa.exercise.domain.dto.Hospital;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewCreateResponse {

    private Long id;
    private String title;
    private String content;
    private String userName;
    private String message;
}
