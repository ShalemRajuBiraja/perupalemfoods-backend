package perupalem.foodsbackend.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.constraints.Email;
import perupalem.foodsbackend.entity.UserEntity;
import perupalem.foodsbackend.pojo.LoginApiData;
import perupalem.foodsbackend.pojo.ResetPasswordSendOtp;
import perupalem.foodsbackend.pojo.SignupApiData;
import perupalem.foodsbackend.repository.AuthRepository;
import perupalem.foodsbackend.utils.AuthUtility;

@Service
public class AuthService {
	
	@Autowired
	AuthRepository authRepository;
	@Autowired
	JwtService jwtService;
	@Autowired
	EmailService emailService;
	
	public Map<String,Object> Signup(SignupApiData signupApiData) throws Exception {
		
	Optional<UserEntity> optionalData = 	authRepository.findByEmail(signupApiData.getEmail());	
		
		if(optionalData.isPresent()) {
			throw new Exception("User Already Existe with thie email");
		}
		
		UserEntity user = new UserEntity();
		user.setFull_name(signupApiData.getName());
		user.setEmail(signupApiData.getEmail());
		user.setMobile_number(signupApiData.getMobile());
		user.setPassword_hash(signupApiData.getPassword());
		
		authRepository.save(user);
		
		Map<String,Object> signupResponseData = new HashMap<>();
		signupResponseData.put("username", signupApiData.getName());
		signupResponseData.put("email", signupApiData.getEmail());
		
	
		return signupResponseData;
	}
	
	public Map<String, Object> Login(LoginApiData loginApiData) throws Exception {
		
		Optional<UserEntity> optionalData = authRepository.findByEmail(loginApiData.getEmail());	
		
			if(optionalData.isEmpty()) {
				throw new Exception("User not found with given email");
			}
			
		UserEntity userData = optionalData.get();
		if(!userData.getPassword_hash().equals(loginApiData.getPassword())) {
			throw new Exception("Password is invalid");
		}
		
		
		String jwtTokenString = jwtService.generateJwtToken(userData);
		Map<String, Object> loginResponseMap = new HashMap<>();
		loginResponseMap.put("userId", userData.getUser_id());
		loginResponseMap.put("email", userData.getEmail());
		loginResponseMap.put("time", userData.getCreated_at());
		loginResponseMap.put("token", jwtTokenString);
		
			
			return loginResponseMap;
		}
	/*
	 * firsth check email is there in DB or not IF NOT THORW EXCEPTION
	 * 
	 * 
	 */
	
	public Object resetPassword( ResetPasswordSendOtp resetPasswordSendOtp) throws Exception {
		
		Optional<UserEntity> dbOptionalData =		authRepository.findByEmail(resetPasswordSendOtp.getEmail());
		if(dbOptionalData.isEmpty()) {
			throw new Exception("Email is not registred with us ");
		}
		
		UserEntity user = dbOptionalData.get();
		
		int otp = AuthUtility.generateOtp();
		
		String emailbodyString = "hi, This is your reset password.Don't share anyone" + otp;
		
		emailService.sendPlainMail();
		
		return null;
		
	}


}
