package perupalem.foodsbackend.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import perupalem.foodsbackend.entity.User;
import perupalem.foodsbackend.payload.ApiResponse;
import perupalem.foodsbackend.pojo.LoginApiData;
import perupalem.foodsbackend.pojo.ResetPasswordSendOtp;
import perupalem.foodsbackend.pojo.SignupApiData;
import perupalem.foodsbackend.service.AuthService;


@CrossOrigin(origins = "http://localhost:5173")
@SuppressWarnings("unused")
@RestController
public class AuthController {
	
	@Autowired
	AuthService authService;
	
	@PostMapping("auth/signup")
	public ResponseEntity<ApiResponse<Object>> signup(@Valid @RequestBody SignupApiData signupApiData ) throws Exception {
		
   Map<String, Object> data =   authService.Signup(signupApiData);
   
   	ApiResponse<Object> datApiResponse = new ApiResponse<>(true,"acccount created",data);
   	
   	
		
		return ResponseEntity.status(HttpStatus.OK).body(datApiResponse);
	}

	
	@PostMapping("auth/login")
	public ResponseEntity<ApiResponse<Map<String, Object>>> Login( @Valid @RequestBody LoginApiData loginApiData) throws Exception {
		
	Map<String, Object> loginResponseData = authService.Login(loginApiData);
	
	ApiResponse<Map<String, Object>> datApiResponse = new ApiResponse<>(true, "Login Success", loginResponseData);
	
		return ResponseEntity.status(HttpStatus.OK).body(datApiResponse);
	}
	/*1. receive data
	 * 2. 
	 * 
	 * 
	 * 
	 */
	
	@PostMapping("auth/reset-password")
	public Object resetPassword(@Valid @RequestBody ResetPasswordSendOtp resetPasswordSendOtp) {
		
		
		return null;
	}
	
	//final bracket
}
