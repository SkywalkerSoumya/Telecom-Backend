package com.soumyajitghosh.telecom.plan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soumyajitghosh.telecom.plan.model.PlanDetails;

public interface PlanRepo extends JpaRepository<PlanDetails, Long> {

	//PlanDetails findphone(int i);
	PlanDetails findById(long planId);
}
