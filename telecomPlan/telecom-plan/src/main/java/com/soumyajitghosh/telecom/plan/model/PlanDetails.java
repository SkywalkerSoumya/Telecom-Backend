package com.soumyajitghosh.telecom.plan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



//@NamedQuery(name="PlanDetails.findPhone" ,query="select * from PlanDetails p ")

@Component
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "plandetails")
public class PlanDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long planId;
	@Column
	private String planName;
	@Column
	private String planCost;
	@Column
	private String planDetails;
	@Column
	private String planValidity;
}



