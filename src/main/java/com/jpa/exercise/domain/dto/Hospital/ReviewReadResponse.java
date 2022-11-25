package com.jpa.exercise.domain.dto.Hospital;

import com.jpa.exercise.domain.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class ReviewReadResponse {
    private Long id;
    private String title;
    private String content;
    private String patientName;
    private String hospitalName;

    public static ReviewReadResponse of(Review review){
        return ReviewReadResponse.builder()
                .id(review.getId())
                .patientName(review.getUserName())
                .title(review.getTitle())
                .content(review.getContent())
                .hospitalName(review.getHospital().getHospitalName())
                .build();
    }


}
