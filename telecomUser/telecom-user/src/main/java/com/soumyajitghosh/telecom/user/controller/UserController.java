package com.soumyajitghosh.telecom.user.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soumyajitghosh.telecom.user.dto.ResponseDTO;
import com.soumyajitghosh.telecom.user.jwt.SecurityJwt;
import com.soumyajitghosh.telecom.user.model.UserModel;
import com.soumyajitghosh.telecom.user.repository.UserRepo;
import com.soumyajitghosh.telecom.user.service.UserLoginService;
import com.soumyajitghosh.telecom.user.service.UserService;


@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserLoginService userLoginService;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private SecurityJwt jwtUtil;
	
	
	@PostMapping("/signup")
	public String addUser(@RequestBody UserModel signupUser) {
		if(userLoginService.register(signupUser) == "new user added")
			return "User Registered Successfully!!!";
		return "User already exist!!!";
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody UserModel loginUser) throws Exception{
		//String userAdd = userLoginService.login(loginUser)
		return ResponseEntity.ok(userLoginService.login(loginUser));
	}
	
	@GetMapping("/showall")
	public List<UserModel> showAll(){
		//return userRepo.findAll();
		return  userService.getAllUser();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserModel> getUserById(@PathVariable("id") String id){
		UserModel userModel = userRepo.findByUserNumber(jwtUtil.getUsername(id));
		return ResponseEntity.ok().body(userModel);
	}
	
	//update recharge and broadband with jwt authentication
	@PutMapping("/update-rechargeplan/{id}")
	public ResponseEntity<UserModel> updateUserRechargePlan(@RequestBody UserModel rechargeUser,@PathVariable("id") String numberId){
		//UserModel userModel = userRepo.findByUserNumber(jwtUtil.getUsername(id));
//	public String updateUserRechargePlan(@RequestBody UserModel signupUser,@PathVariable("id") String numberId){
		UserModel rechargePlanUpdatedUser = userService.updateUserRechargePlan(rechargeUser,jwtUtil.getUsername(numberId));
		return ResponseEntity.ok().body(rechargePlanUpdatedUser);
	}
	
//	@PutMapping("/update-broadbandplan/{id}")
//	public ResponseEntity<UserModel> updateUserBroadbandPlan(@RequestBody UserModel broadbandUser,@PathVariable("id") String numberId){
//		UserModel broadbandPlanUpdatedUser = userService.updateUserBroadbandPlan(broadbandUser,jwtUtil.getUsername(numberId));
//		return ResponseEntity.ok().body(broadbandPlanUpdatedUser);
//	}
	//new add ----
	@PutMapping("/update-broadbandplan/{id}")
	public String updateUserBroadbandPlan(@RequestBody UserModel signupUser,@PathVariable("id") String numberId){
		userService.updateUserBroadbandPlan(signupUser,numberId);
		return "Recharge plan Updated Successfully!!!";
	}
//	@PutMapping("/update-broadbandplan/{id}")
//	public ResponseEntity<UserModel> updateUserBroadbandPlan(@RequestBody UserModel rechargeUser,@PathVariable("id") String numberId){
//		UserModel broadbandPlanUpdatedUser = userService.updateUserBroadbandPlan(rechargeUser,jwtUtil.getUsername(numberId));
//		return ResponseEntity.ok().body(broadbandPlanUpdatedUser);
//	}
	
	
	@PutMapping("/updateprofile/{id}")
	public String updateUser(@RequestBody UserModel signupUser,@PathVariable("id") String id){
		userLoginService.updateProfile(signupUser,id);
		return "Profile Updated Successfully!!!";
	}
	
	@GetMapping("/get-user-all-details/{id}")
    public ResponseEntity<ResponseDTO> getUser(@PathVariable("id") String id){
        ResponseDTO responseDto = userService.getUser(id);
        return ResponseEntity.ok(responseDto);
    }
	
	//end
	
	
	
	
	
	/******************************************************************/
//	@GetMapping("/profile/{id}")
//	public UserModel userdetails(@PathVariable String userNumber) {
//		return userService.userdetails(userNumber);
////		return userRepo.findByUserNumber(userNumber);
//	}
//	
	
//	@PostMapping("/signup")
//	public UserModel addUser(@RequestBody UserModel signupUser) {		//@Validated can be used
//		return userService.register(signupUser);
//	}
	

}
