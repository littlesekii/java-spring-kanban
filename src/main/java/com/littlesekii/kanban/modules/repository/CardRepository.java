package com.littlesekii.kanban.modules.repository;

import com.littlesekii.kanban.modules.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CardRepository extends JpaRepository<Card, UUID> {
}
