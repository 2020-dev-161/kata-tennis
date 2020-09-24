package com.example.katatennis.domain;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.katatennis.domain.Point.Love;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GameTests {

    private Game game;

    @BeforeAll
    void init() {
        final Player playerOne = new Player("Tom");
        final Player playerTwo = new Player("Joe");
        game = new Game(playerOne, playerTwo);
        log.info("a new Game with two Players is successfully created");
        log.info("the game is {}", game);
    }

    @Test
    void testNewGameStartsWithLoveSuccess() {
        final Point expected = Love;
        final Point actualOne = game.getPlayerOne().getPoint();
        assertEquals(expected, actualOne);
        final Point actualTwo = game.getPlayerTwo().getPoint();
        assertEquals(expected, actualTwo);
        log.info("a new Game starts with {} point(s)", expected);
    }
}
