package perupalem.foodsbackend.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

//✅ Add these imports
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import perupalem.foodsbackend.entity.UserEntity;


@Service
public class JwtService {
	
	@Value("${jwt.secret_key}")
	private String jwtsecretKey;
	
	

	private int JWT_TOKEN_VALIDITY = 24 * 60 * 60 * 1000;
	
	
	//It created the encrypted by using secret key and return
	//It created the encrypted by u
	public  Key generateSecurityKey() {
		
		return Keys.hmacShaKeyFor(jwtsecretKey.getBytes());
		
	}
	
	//generating jwt token by using user details and secret key;
	public String generateJwtToken(UserEntity userData) {
		
		Date tokenGeneratedTime = new Date();
		
		Date expiryDate = new Date(tokenGeneratedTime.getTime() + JWT_TOKEN_VALIDITY );
		
		
		Map<String, Object> tokenData = new HashMap<String,Object>();
		tokenData.put("userId" , userData.getUser_id());
		tokenData.put("firstName" , userData.getFull_name());
		tokenData.put("email" , userData.getEmail());
		tokenData.put("role", "AlwayaAdmin");
		
		
		
		String jwtToken = Jwts.builder()
		.claims().add(tokenData).and()
		.subject(userData.getEmail())
		.issuedAt(tokenGeneratedTime)
		.expiration(expiryDate)
		.signWith(generateSecurityKey()).compact();
		
		
		return jwtToken;
		
	}

}
