package com.user.config.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users") // This matches the API Gateway route
@CrossOrigin(origins = "*") 
public class UserController {
	@GetMapping("/test")
	public ResponseEntity<String> testEndpoint() {
		// Your logic here
		return ResponseEntity.ok("API is working fine!");
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
