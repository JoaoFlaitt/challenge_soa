package br.com.careplus.nutrition.domain.repository;

import br.com.careplus.nutrition.domain.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long> {
}