package perupalem.foodsbackend.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import perupalem.foodsbackend.payload.ApiResponse;

@RestControllerAdvice
public class GlobalException {

	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse<String>> handleGlobalExceptions(Exception ex) {
		
		ApiResponse<String> response = new ApiResponse<>(false, "Unable to process request", ex.getMessage());
		
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	// Handles @Valid validation errors — returns clean field-wise messages
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidationErrors(
	        MethodArgumentNotValidException ex) {

	    Map<String, String> fieldErrors = new HashMap<>();

	    ex.getBindingResult().getFieldErrors().forEach(error ->
	        fieldErrors.put(error.getField(), error.getDefaultMessage())
	    );

	    Map<String, Object> response = new HashMap<>();
	    response.put("success", false);
	    response.put("message", "Validation failed");
	    response.put("data", fieldErrors);

	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	
	
	
}
