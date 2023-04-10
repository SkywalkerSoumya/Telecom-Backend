package com.soumyajitghosh.telecom.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserModelDTO {

	private long userId;
	private String userName;
	private String userNumber;
	private String userEmail;
	private String userPassword;
	private String userAddress;
}
