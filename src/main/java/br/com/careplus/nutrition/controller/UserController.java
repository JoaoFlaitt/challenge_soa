package br.com.careplus.nutrition.controller;

import br.com.careplus.nutrition.dto.UserDTO;
import br.com.careplus.nutrition.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    public ResponseEntity<UserDTO> getMe(Principal principal) {
        UUID userId = UUID.fromString(principal.getName());
        return ResponseEntity.ok(userService.getProfile(userId));
    }

    @PutMapping("/me")
    public ResponseEntity<UserDTO> updateMe(@RequestBody UserDTO dto, Principal principal) {
        UUID userId = UUID.fromString(principal.getName());
        return ResponseEntity.ok(userService.updateProfile(userId, dto));
    }
}