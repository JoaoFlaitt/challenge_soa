package br.com.careplus.nutrition.controller;

import br.com.careplus.nutrition.dto.ChallengeDTO;
import br.com.careplus.nutrition.service.ChallengeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/challenges")
public class ChallengeController {

    private final ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping
    public ResponseEntity<List<ChallengeDTO>> listChallenges() {
        return ResponseEntity.ok(challengeService.listAll());
    }

    @PostMapping("/join")
    public ResponseEntity<Void> joinChallenge(@RequestBody JoinRequest request,
                                              Principal principal) {
        UUID userId = UUID.fromString(principal.getName());
        challengeService.joinChallenge(userId, request.getChallengeId());
        return ResponseEntity.ok().build();
    }

    public static class JoinRequest {
        private Long challengeId;

        public Long getChallengeId() {
            return challengeId;
        }

        public void setChallengeId(Long challengeId) {
            this.challengeId = challengeId;
        }
    }
}