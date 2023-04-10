package com.soumyajitghosh.telecom.broadband.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soumyajitghosh.telecom.broadband.model.BroadbandPlans;
import com.soumyajitghosh.telecom.broadband.repository.BroadbandRepo;

@Service
public class BroadbandService {

	@Autowired
	BroadbandRepo bRepo;
	
	public BroadbandPlans addNewPlan(BroadbandPlans plans) {
		return bRepo.save(plans);
	}

	public String updatePlan(BroadbandPlans bPlanDetails, long id) {
		BroadbandPlans oldPlan = bRepo.findById(id);
		oldPlan.setBroadbandPlanDetails(bPlanDetails.getBroadbandPlanDetails());
		bRepo.save(oldPlan);
		return "Plan Details updated successfully!";
		
	}

	public List<BroadbandPlans> allPlans() {
		return bRepo.findAll();
	}

	public BroadbandPlans getPlanById(long id) {
		return bRepo.findById(id);
	}

}
