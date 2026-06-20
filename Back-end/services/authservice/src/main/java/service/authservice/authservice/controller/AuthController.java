package service.authservice.authservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.authservice.authservice.dto.*;
import service.authservice.authservice.service.AuthService;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(@RequestBody SignupRequest request) {
        try {
            AuthResponse response = authService.register(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(AuthResponse.builder().success(false).message(e.getMessage()).build());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        try {
            AuthResponse response = authService.login(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(AuthResponse.builder().success(false).message(e.getMessage()).build());
        }
    }

    @PostMapping("/logout")
public ResponseEntity<AuthResponse> logout(@RequestHeader("Authorization") String tokenHeader) {
    try {
        // Extract the token from the "Bearer <token>" header
        String token = null;
        if (tokenHeader != null && tokenHeader.startsWith("Bearer ")) {
            token = tokenHeader.substring(7);
        }

        if (token == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(AuthResponse.builder().success(false).message("Missing token.").build());
        }

        // Pass it to the service layer
        authService.logout(token);

        return ResponseEntity.ok(
            AuthResponse.builder()
                .success(true)
                .message("Logged out successfully. Token cleared.")
                .build()
        );
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(AuthResponse.builder().success(false).message(e.getMessage()).build());
    }
}
}