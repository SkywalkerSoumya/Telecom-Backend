package com.soumyajitghosh.telecom.user.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.soumyajitghosh.telecom.user.model.UserModel;

public interface UserRepo extends JpaRepository<UserModel, Long> {
	
	UserModel findByUserNumber(String userNumber);
	UserModel findByUserId(Long userId);
}
