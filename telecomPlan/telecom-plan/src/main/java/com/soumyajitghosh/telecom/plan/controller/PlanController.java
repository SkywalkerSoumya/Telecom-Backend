package com.soumyajitghosh.telecom.plan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soumyajitghosh.telecom.plan.model.PlanDetails;
import com.soumyajitghosh.telecom.plan.service.PlanService;

@RestController
@RequestMapping("/api/v1/plans")
@CrossOrigin(origins = "http://localhost:4200")
public class PlanController {
	
	@Autowired
	PlanService planService;
	
	@PostMapping("/add")
	public PlanDetails addPlan(@RequestBody PlanDetails planDetails) {
		return planService.addNewPlan(planDetails);
		
	}
	
	@PutMapping("/update/{id}")
	public String updateNewPlan(@RequestBody PlanDetails plan,@PathVariable long id){
		planService.updatePlan(plan,id);
		return "Profile Updated Successfully!!!";
	}
	
	@GetMapping("/all")
	public List<PlanDetails> getAllPlans() {
		return planService.allPlans();
	}
	
	@GetMapping("/{id}")
	public PlanDetails getPlan(@PathVariable long id) {
		return planService.getPlanById(id);
	}

}
