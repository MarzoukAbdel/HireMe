package com.example.hireme.controller.auth;

import com.example.hireme.dto.User;
import com.example.hireme.repository.auth.UserRepository;
import com.example.hireme.service.auth.AuthenticationService;
import com.example.hireme.utils.AuthenticationRequest;
import com.example.hireme.utils.AuthenticationResponse;
import com.example.hireme.utils.RegisterRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin("http://localhost:3000/")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    private final UserRepository userRepository;
    private final AuthenticationService authenticationService;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
    return ResponseEntity.ok(authenticationService.register(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
    @PostMapping("/refresh-token")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        authenticationService.refreshToken(request,response);
    }
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
