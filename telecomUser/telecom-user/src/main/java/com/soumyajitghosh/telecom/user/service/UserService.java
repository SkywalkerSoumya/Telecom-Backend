package com.soumyajitghosh.telecom.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.soumyajitghosh.telecom.user.dto.BroadbandPlansDTO;
import com.soumyajitghosh.telecom.user.dto.PlanDetailsDTO;
import com.soumyajitghosh.telecom.user.dto.ResponseDTO;
import com.soumyajitghosh.telecom.user.dto.UserModelDTO;
import com.soumyajitghosh.telecom.user.model.UserModel;
import com.soumyajitghosh.telecom.user.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private RestTemplate restTemplate1;
	
	public List<UserModel> getAllUser(){
		return  userRepo.findAll();
	}
	
	public UserModel userdetails(String userNumber) {
		return userRepo.findByUserNumber(userNumber);
	}
	
	//@Transactional
	public UserModel register(UserModel signupUser) {
		return userRepo.save(signupUser);
	}
	
	//new add for recharges plan update
	public UserModel updateUserRechargePlan(UserModel user,String userNumberId) {
		UserModel oldUser = userRepo.findByUserNumber(userNumberId);
		oldUser.setRechargePlanId(user.getRechargePlanId());
		userRepo.save(oldUser);
		return oldUser;
	}
	
	//new add for broadband plan update
	public String updateUserBroadbandPlan(UserModel user,String userNumberId) {
		UserModel oldUser = userRepo.findByUserNumber(userNumberId);
		oldUser.setBroadbandPlanId(user.getBroadbandPlanId());
		userRepo.save(oldUser);
		return "updated successfully!";
	}
	
	//new add ----------
    public ResponseDTO getUser(String userNumber) {

        ResponseDTO responseDto = new ResponseDTO();
        UserModel user = userRepo.findByUserNumber(userNumber);
        UserModelDTO userDto = mapToUser(user);

        ResponseEntity<PlanDetailsDTO> responseEntity = restTemplate
                .getForEntity("http://localhost:9030/api/v1/plans/" + user.getRechargePlanId(),
                PlanDetailsDTO.class);
        
        //new
        ResponseEntity<BroadbandPlansDTO> broadbandresponseEntity = restTemplate1
                .getForEntity("http://localhost:9040/api/v1/bplans/" + user.getBroadbandPlanId(),
                BroadbandPlansDTO.class);
        //end

        PlanDetailsDTO prepaidPlanDto = responseEntity.getBody();
        BroadbandPlansDTO broadbandPlanDto = broadbandresponseEntity.getBody();

        System.out.println(responseEntity.getStatusCode());
        System.out.println(broadbandresponseEntity.getStatusCode());

        responseDto.setUser(userDto);
        responseDto.setPlans(prepaidPlanDto);
        responseDto.setBroadband(broadbandPlanDto);

        return responseDto;
    }

    private UserModelDTO mapToUser(UserModel user){
        UserModelDTO userDto = new UserModelDTO();
        userDto.setUserId(user.getUserId());
        userDto.setUserName(user.getUserName());
        userDto.setUserNumber(user.getUserNumber());
        userDto.setUserEmail(user.getUserEmail());
        userDto.setUserPassword(user.getUserPassword());
        userDto.setUserAddress(user.getUserAddress());
        return userDto;
    }
    
    //end
	
	
	
	
}
