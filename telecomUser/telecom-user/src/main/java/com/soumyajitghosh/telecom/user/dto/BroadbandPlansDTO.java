package com.soumyajitghosh.telecom.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BroadbandPlansDTO {
	
	private long bId;
	private String broadbandName;
	private String broadbandCost;
	private String broadbandPlanDetails;
	private String broadbandValidity;
	
}

