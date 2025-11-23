package br.com.careplus.nutrition.service;

import br.com.careplus.nutrition.dto.ChallengeDTO;

import java.util.List;
import java.util.UUID;

public interface ChallengeService {

    List<ChallengeDTO> listAll();

    void joinChallenge(UUID userId, Long challengeId);
}