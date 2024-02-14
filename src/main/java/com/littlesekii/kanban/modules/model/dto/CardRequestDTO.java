package com.littlesekii.kanban.modules.model.dto;

import com.littlesekii.kanban.modules.model.Card;

public record CardRequestDTO(String description) {

    public Card toEntity() {
        return new Card(null, description);
    }
}
