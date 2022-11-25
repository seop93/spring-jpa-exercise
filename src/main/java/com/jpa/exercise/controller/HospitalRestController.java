package com.jpa.exercise.controller;

import com.jpa.exercise.domain.dto.Hospital.ReviewCreateRequest;
import com.jpa.exercise.domain.dto.Hospital.ReviewCreateResponse;
import com.jpa.exercise.domain.dto.Hospital.ReviewReadResponse;
import com.jpa.exercise.domain.entity.Hospital;
import com.jpa.exercise.service.HospitalService;
import com.jpa.exercise.service.ReviewService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/hospitals")
public class HospitalRestController {

    private final HospitalService hospitalService;
    private final ReviewService reviewService;

    public HospitalRestController(HospitalService hospitalService, ReviewService reviewService){

        this.hospitalService = hospitalService;
        this.reviewService = reviewService;
    }

//    public ResponseEntity<List<Hospital>> list(Pageable pageable){
//        return ResponseEntity.ok().body(hospitalService.findHospital(pageable));
//    }

    @PostMapping("/{id}/reviews")
    public ResponseEntity<ReviewCreateResponse> get(@PathVariable Integer id, @RequestBody ReviewCreateRequest reviewCreateRequest){
        return ResponseEntity.ok().body(reviewService.add(reviewCreateRequest));
    }

    @GetMapping("/{hospitalId}/reviews")
    public ResponseEntity<List<ReviewReadResponse>> reviews(@PathVariable Integer hospitalId) {
        return ResponseEntity.ok().body(reviewService.findAllByHospitalId(hospitalId));
    }




}
