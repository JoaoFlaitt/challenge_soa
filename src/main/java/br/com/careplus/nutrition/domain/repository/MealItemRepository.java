package br.com.careplus.nutrition.domain.repository;

import br.com.careplus.nutrition.domain.entity.MealItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealItemRepository extends JpaRepository<MealItem, Long> {
}