package br.com.careplus.nutrition.domain.repository;

import br.com.careplus.nutrition.domain.entity.Meal;
import br.com.careplus.nutrition.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MealRepository extends JpaRepository<Meal, UUID> {

    List<Meal> findByUser(User user);
}