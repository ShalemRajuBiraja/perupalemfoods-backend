package perupalem.foodsbackend.pojo;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ResetPasswordSendOtp {

	@NotBlank(message =  "Email should not be blank")
	private String email;
}

