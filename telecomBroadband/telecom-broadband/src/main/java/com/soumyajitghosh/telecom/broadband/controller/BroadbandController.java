package com.soumyajitghosh.telecom.broadband.controller;

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

import com.soumyajitghosh.telecom.broadband.model.BroadbandPlans;
import com.soumyajitghosh.telecom.broadband.service.BroadbandService;

@RestController
@RequestMapping("/api/v1/bplans")
@CrossOrigin(origins = "https://localhost:4200")
public class BroadbandController {

	@Autowired
	BroadbandService bService;
	
	@PostMapping("/add")
	public BroadbandPlans addPlan(@RequestBody BroadbandPlans plans) {
		return bService.addNewPlan(plans);
		
	}
	
	@PutMapping("/update/{id}")
	public String updateNewPlan(@RequestBody BroadbandPlans bPlanDetails,@PathVariable long id){
		bService.updatePlan(bPlanDetails,id);
		return "Profile Updated Successfully!!!";
	}
	
	@GetMapping("/all")
	public List<BroadbandPlans> getAllPlans() {
		return bService.allPlans();
	}
	
	@GetMapping("/{id}")
	public BroadbandPlans getPlan(@PathVariable long id) {
		return bService.getPlanById(id);
	}
}
