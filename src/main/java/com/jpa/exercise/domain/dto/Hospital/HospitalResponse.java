package com.jpa.exercise.domain.dto.Hospital;

import com.jpa.exercise.domain.entity.Hospital;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HospitalResponse {

    private Integer hospitalId;
    private String hospitalName;
    private String hospitalRoadNameAddress;

    private String review;

//    public static HospitalResponse of(Hospital hospital){
//        return HospitalResponse.builder()
//                .hospitalId(hospital.getId())
//                .hospitalName(hospital.getHospitalName())
//                .hospitalRoadNameAddress(hospital.getRoadNameAddress())
//                .review(hospital.getReviews().get())
//    }
}
