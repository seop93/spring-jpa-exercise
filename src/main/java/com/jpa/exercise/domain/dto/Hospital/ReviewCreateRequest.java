package com.jpa.exercise.domain.dto.Hospital;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewCreateRequest {
    private Integer hospitalId;
    private String title;
    private String content;
    private String username;
}
