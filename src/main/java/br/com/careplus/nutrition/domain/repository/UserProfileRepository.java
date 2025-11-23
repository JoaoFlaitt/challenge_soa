package br.com.careplus.nutrition.domain.repository;

import br.com.careplus.nutrition.domain.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}