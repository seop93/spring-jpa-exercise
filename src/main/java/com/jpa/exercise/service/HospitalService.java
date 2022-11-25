package com.jpa.exercise.service;

import com.jpa.exercise.controller.HospitalRestController;
import com.jpa.exercise.domain.dto.Hospital.HospitalResponse;
import com.jpa.exercise.domain.entity.Hospital;
import com.jpa.exercise.repository.HospitalRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository){
        this.hospitalRepository = hospitalRepository;
    }

//    public List<HospitalResponse> findHospital(Pageable pageable){
//        Page<Hospital> hospitalPage = hospitalRepository.findAll(pageable);
//        List<HospitalResponse> hospitalResponses = hospitalPage.stream()
//                .map(hospital -> HospitalResponse.of(hospital)).collect(Collectors.toList());
//
//        return hospitalResponses;
//
//    }
}
