package com.littlesekii.kanban.modules.service;

import com.littlesekii.kanban.modules.model.Card;
import com.littlesekii.kanban.modules.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CardService {

    private final CardRepository repository;

    public CardService(CardRepository repository) {
        this.repository = repository;
    }

    public List<Card> getAll() {
        return repository.findAll();
    }

    public Card register(Card card) {
        return repository.save(card);
    }

    public void remove(UUID id) {
        repository.deleteById(id);
    }

    public Card update(UUID id, Card card) {
        Card reference = repository.getReferenceById(id);
        updateData(reference, card);
        return repository.save(reference);
    }

    private void updateData(Card ref, Card card) {
        ref.setDescription(card.getDescription());
    }

}
