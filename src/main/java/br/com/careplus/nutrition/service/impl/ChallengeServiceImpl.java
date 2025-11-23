package br.com.careplus.nutrition.service.impl;

import br.com.careplus.nutrition.domain.entity.Challenge;
import br.com.careplus.nutrition.domain.entity.User;
import br.com.careplus.nutrition.domain.entity.UserChallenge;
import br.com.careplus.nutrition.domain.repository.ChallengeRepository;
import br.com.careplus.nutrition.domain.repository.UserChallengeRepository;
import br.com.careplus.nutrition.domain.repository.UserRepository;
import br.com.careplus.nutrition.dto.ChallengeDTO;
import br.com.careplus.nutrition.exception.BusinessException;
import br.com.careplus.nutrition.service.ChallengeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChallengeServiceImpl implements ChallengeService {

    private final ChallengeRepository challengeRepository;
    private final UserRepository userRepository;
    private final UserChallengeRepository userChallengeRepository;

    @Override
    public List<ChallengeDTO> listAll() {
        return challengeRepository.findAll().stream()
                .map(ChallengeDTO::new)
                .toList();
    }

    @Override
    @Transactional
    public void joinChallenge(UUID userId, Long challengeId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException("Usuário não encontrado"));

        Challenge challenge = challengeRepository.findById(challengeId)
                .orElseThrow(() -> new BusinessException("Desafio não encontrado"));

        UserChallenge uc = new UserChallenge();
        uc.setUser(user);
        uc.setChallenge(challenge);
        uc.setStartDate(LocalDate.now());
        uc.setCompleted(false);

        userChallengeRepository.save(uc);
    }
}