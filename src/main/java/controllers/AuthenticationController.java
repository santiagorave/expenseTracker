package controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.ExpenseTracker.AuthenticationService;
import dev.ExpenseTracker.JWTService;
import dev.ExpenseTracker.User;
import dev.ExpenseTracker.loginResponse;
import dtos.LoginUserDto;
import dtos.RegisterUserDto;

@RestController
public class AuthenticationController {
	  private final JWTService jwtService;
	    
	    private final AuthenticationService authenticationService;

	    public AuthenticationController(JWTService jwtService, AuthenticationService authenticationService) {
	        this.jwtService = jwtService;
	        this.authenticationService = authenticationService;
	    }

	    @PostMapping("/signup")
	    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
	        User registeredUser = authenticationService.signup(registerUserDto);

	        return ResponseEntity.ok(registeredUser);
	    }

	    @PostMapping("/login")
	    public ResponseEntity<loginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
	        User authenticatedUser = authenticationService.authenticate(loginUserDto);

	        String jwtToken = jwtService.generateToken(authenticatedUser);

	        loginResponse loginResponse = new loginResponse();
	        loginResponse.setToken(jwtToken);
	        loginResponse.setExpiresIn(jwtService.getExpirationTime());

	        return ResponseEntity.ok(loginResponse);
	    }
}
