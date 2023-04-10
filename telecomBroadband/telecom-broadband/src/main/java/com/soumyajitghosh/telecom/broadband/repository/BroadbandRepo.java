package com.soumyajitghosh.telecom.broadband.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soumyajitghosh.telecom.broadband.model.BroadbandPlans;

public interface BroadbandRepo extends JpaRepository<BroadbandPlans, Long>{

	BroadbandPlans findById(long bId);
}
