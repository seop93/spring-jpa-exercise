package com.jpa.exercise.service;

import com.jpa.exercise.domain.dto.Hospital.ReviewCreateRequest;
import com.jpa.exercise.domain.dto.Hospital.ReviewCreateResponse;
import com.jpa.exercise.domain.dto.Hospital.ReviewReadResponse;
import com.jpa.exercise.domain.entity.Hospital;
import com.jpa.exercise.domain.entity.Review;
import com.jpa.exercise.repository.HospitalRepository;
import com.jpa.exercise.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final HospitalRepository hospitalRepository;

    public ReviewService(ReviewRepository reviewRepository, HospitalRepository hospitalRepository){
        this.reviewRepository = reviewRepository;
        this.hospitalRepository = hospitalRepository;
    }

    public ReviewCreateResponse add(ReviewCreateRequest reviewCreateRequest){
        Optional<Hospital> hospital = hospitalRepository.findById(reviewCreateRequest.getHospitalId());
        Review review = Review.builder()
                .title(reviewCreateRequest.getTitle())
                .content(reviewCreateRequest.getContent())
                .userName(reviewCreateRequest.getUsername())
                .hospital(hospital.get())
                .build();
        Review savedReview = reviewRepository.save(review);
        return new ReviewCreateResponse(savedReview.getId(),
                savedReview.getTitle(), savedReview.getContent(), savedReview.getUserName(), "성공");

    }

    public Review getReview(Long id){
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 id가 없습니다."));
        return review;
    }

    public List<ReviewReadResponse> findAllByHospitalId(Integer hospitalId) {
        Hospital hospital = hospitalRepository.findById(hospitalId)
                .orElseThrow(()-> new IllegalArgumentException("해당 id가 없습니다."));
        List<ReviewReadResponse> reviews = reviewRepository.findByHospital(hospital)
                .stream().map(review -> ReviewReadResponse.builder()
                        .id(review.getId())
                        .title(review.getTitle())
                        .content(review.getContent())
                        .patientName(review.getUserName())
                        .hospitalName(review.getHospital().getHospitalName())
                        .build()
                ).collect(Collectors.toList());
        return reviews;
    }


}
