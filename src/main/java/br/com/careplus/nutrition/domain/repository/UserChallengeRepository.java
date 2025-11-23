package br.com.careplus.nutrition.domain.repository;

import br.com.careplus.nutrition.domain.entity.UserChallenge;
import br.com.careplus.nutrition.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserChallengeRepository extends JpaRepository<UserChallenge, UUID> {

    List<UserChallenge> findByUser(User user);

}