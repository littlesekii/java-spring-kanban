package com.littlesekii.kanban;

import com.littlesekii.kanban.modules.model.Card;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class KanbanApplicationTests {

    @Test
    void contextLoads() {
        Card nullCard = new Card();
        Card card = new Card(UUID.randomUUID(), "Aprender Java");

        System.out.println(nullCard);
        System.out.println(card);
    }

}
