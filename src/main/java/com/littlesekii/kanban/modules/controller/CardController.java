package com.littlesekii.kanban.modules.controller;

import com.littlesekii.kanban.modules.model.Card;
import com.littlesekii.kanban.modules.model.dto.CardRequestDTO;
import com.littlesekii.kanban.modules.service.CardService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cards")
public class CardController {

    private final CardService service;

    public CardController(CardService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Card>> getAll() {
        var res = service.getAll();
        return ResponseEntity.ok().body(res);
    }

    @PostMapping
    public ResponseEntity<Card> register(@RequestBody @Validated CardRequestDTO req) {
        var res = service.register(req.toEntity());

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(res.getId()).toUri();

        return ResponseEntity.created(uri).body(res);
    }

    //implement undo later
    @DeleteMapping("/{id}")
    public ResponseEntity<Card> remove(@PathVariable UUID id) {
        service.remove(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Card> update(@PathVariable UUID id, @RequestBody CardRequestDTO req) {
        var res = service.update(id, req.toEntity());
        return ResponseEntity.ok().body(res);
    }
}
