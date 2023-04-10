package com.soumyajitghosh.telecom.user.model;

import java.io.Serializable;

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
@Table(name = "userdetails")
public class UserModel implements Serializable{

	private static final long serialversionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	@Column
	private String userName;
	@Column
	private String userNumber;
	@Column
	private String userEmail;
	@Column
	private String userPassword;
	@Column
	private String userAddress;
	
	/* new add*/
	@Column
	private String rechargePlanId;
	@Column
	private String broadbandPlanId;
	//end
	
}
