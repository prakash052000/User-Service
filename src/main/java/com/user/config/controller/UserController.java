package com.user.config.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/users") // This matches the API Gateway route
@CrossOrigin(origins = "*") 
@Tag(name = "User Service API", description = "Operations related to users")

public class UserController {
	@GetMapping("/test")
	public ResponseEntity<String> testEndpoint() {
		// Your logic here
		return ResponseEntity.ok("API is working fine!");
	}
	
	@PostMapping("/stringApi")
	public ResponseEntity<String> testEndpoint(@RequestBody String api) {
		// Your logic here
		return ResponseEntity.ok("API is working fine!"+api);
	}
	
	@PostMapping("/demo")
	public ResponseEntity<String> testEndpoint(@RequestHeader(value = "Authorization", required = false) String authHeader,  @RequestBody(required = false) Map<String, Object> body) {
	    if (authHeader == null) {
	    	System.out.println("No Authorization header received!");
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Missing Authorization header");
	    }
	    System.out.println("Received Token: " + authHeader);
	    return ResponseEntity.ok("Success");
	}


	public ResponseEntity<String> test(@RequestHeader(value = "Authorization", required = false) String token) {
		// Check if Authorization header is present and starts with "Bearer "
		if (token == null || !token.startsWith("Bearer ")) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Missing or invalid Authorization header");
		}

		// Extract the JWT token (remove "Bearer " part)
		String jwtToken = token.substring(7); // Remove "Bearer " from the token

		// Simulating token validation (replace with actual token validation logic)
		boolean isTokenValid = validateToken(jwtToken);

		if (!isTokenValid) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid token");
		}

		// If token is valid, return success message
		return ResponseEntity.ok("User Service is working!");
	}

	// Simulate token validation (this should be replaced with real JWT token
	// validation logic)
	private boolean validateToken(String token) {
		// Example validation logic: replace with your actual JWT validation
		return "my-secure-token".equals(token); // Replace with your token validation logic
	}
}
