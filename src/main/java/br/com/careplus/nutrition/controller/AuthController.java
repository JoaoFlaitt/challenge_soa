package br.com.careplus.nutrition.controller;

import br.com.careplus.nutrition.dto.AuthRequestDTO;
import br.com.careplus.nutrition.dto.AuthResponseDTO;
import br.com.careplus.nutrition.dto.UserDTO;
import br.com.careplus.nutrition.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> register(@RequestBody UserDTO dto) {
        return ResponseEntity.ok(authService.register(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthRequestDTO request) {
        return ResponseEntity.ok(authService.login(request));
    }
}