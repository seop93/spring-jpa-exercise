package com.jpa.exercise.repository;

import com.jpa.exercise.domain.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
}
