package br.com.careplus.nutrition.domain.repository;

import br.com.careplus.nutrition.domain.entity.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChallengeRepository extends JpaRepository<Challenge, Long> {
}