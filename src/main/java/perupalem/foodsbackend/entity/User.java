package perupalem.foodsbackend.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;

    private String full_name;

    private String email;

    private String mobile_number;

    private String password_hash;
    
    private LocalDateTime created_at = LocalDateTime.now();
	
	private LocalDateTime updated_at= LocalDateTime.now();;
}