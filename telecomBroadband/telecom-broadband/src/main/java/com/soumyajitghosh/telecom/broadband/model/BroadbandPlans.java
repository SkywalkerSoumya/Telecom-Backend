package com.soumyajitghosh.telecom.broadband.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "broadbandplans")
public class BroadbandPlans {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bId;
	@Column
	private String broadbandName;
	@Column
	private String broadbandCost;
	@Column
	private String broadbandPlanDetails;
	@Column
	private String broadbandValidity;
	
}