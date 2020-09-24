package com.example.katatennis.domain;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static com.example.katatennis.domain.Point.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PlayerTests {

    private Player playerOne;
    private Player playerTwo;

    @BeforeAll
    void init() {
        playerOne = new Player("Tom");
        playerTwo = new Player("Joe");
        log.info("playerOne is {}", playerOne);
        log.info("playerTwo is {}", playerTwo);
    }

    @Test
    void testNewPlayerHasZeroPointsSuccess() {
        final Point expected = Love;
        final Point actual = playerOne.getPoint();
        assertEquals(expected, actual);
        log.info("player starts with {} point(s)", actual);
    }

    @Test
    void testIncrementLoveSuccess() {
        playerOne.setPoint(Love);
        final Point previous = playerOne.getPoint();
        playerOne.incrementPoint();
        final Point expected = Fifteen;
        final Point actual = playerOne.getPoint();
        assertEquals(expected, actual);
        log.info("increment point from {} to {}", previous, actual);
    }

}
