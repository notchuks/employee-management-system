package dev.nnamdi.auth_service.controller;

import dev.nnamdi.auth_service.model.dto.LoginDto;
import dev.nnamdi.auth_service.model.dto.RegisterDto;
import dev.nnamdi.auth_service.model.entity.User;
import dev.nnamdi.auth_service.model.response.LoginResponse;
import dev.nnamdi.auth_service.security.JwtUtil;
import dev.nnamdi.auth_service.service.UserInfoConfigManager;
import dev.nnamdi.auth_service.service.UserService;
import dev.nnamdi.auth_service.utils.ResponseHandler;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserController {
    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private UserInfoConfigManager userInfoConfigManager;

    @GetMapping("/users/{username}")
    public ResponseEntity<RegisterDto> getByUserName(@PathVariable String username) {
        return ResponseEntity.ok(userService.findUserByUsername(username));
    }

    @PostMapping("/register/")
    public ResponseEntity<Object> register(@Valid @RequestBody RegisterDto registerDto) {
        return ResponseHandler.generateResponse("User registered successfully", HttpStatus.OK, userService.register(registerDto));
    }

    @PostMapping("/login/")
    public ResponseEntity<Object> login(@Valid @RequestBody LoginDto loginDto) {
        try {
            Authentication authenticate = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
            UserDetails userDetails = userInfoConfigManager.loadUserByUsername(loginDto.getUsername());
            String jwt = jwtUtil.generateToken(userDetails.getUsername());
            LoginResponse loginResponse = LoginResponse
                    .builder()
                    .accessToken(jwt)
                    .build();
            return ResponseHandler.generateResponse("User logged in successfully", HttpStatus.OK, loginResponse);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>("Incorrect username or password", HttpStatus.BAD_REQUEST);
        }
    }
}