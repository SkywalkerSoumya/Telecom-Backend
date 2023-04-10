package com.soumyajitghosh.telecom.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PlanDetailsDTO {
	
	private long planId;
	private String planName;
	private String planCost;
	private String planCategory;
	private String planDetails;
	private String planValidity;
}
