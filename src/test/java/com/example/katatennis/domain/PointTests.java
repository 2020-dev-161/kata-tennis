package com.example.katatennis.domain;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static com.example.katatennis.domain.Point.Game;
import static com.example.katatennis.domain.Point.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class PointTests {

    private Point point;

    @BeforeEach
    void init() {
        point = Love;
        log.info("point is {}", point);
    }

    @Test
    void testIncrementLoveSuccess() {
        final Point expected = Fifteen;
        final Point actual = point.increment();
        assertEquals(expected, actual);
        log.info("success for point increment from {} to {}", Love, actual);
    }

    @Test
    void testIncrementFifteenSuccess() {
        final Point expected = Thirty;
        final Point actual = point.increment().increment();
        assertEquals(expected, actual);
        log.info("success for point increment from {} to {}", Love, actual);
    }

    @Test
    void testIncrementThirtySuccess() {
        final Point expected = Forty;
        final Point actual = point.increment().increment().increment();
        assertEquals(expected, actual);
        log.info("success for point increment from {} to {}", Love, actual);
    }

    @Test
    void testIncrementFortySuccess() {
        final Point expected = Advantage;
        final Point actual = point.increment().increment().increment().increment();
        assertEquals(expected, actual);
        log.info("success for point increment from {} to {}", Love, actual);
    }

    @Test
    void testIncrementAdvantageSuccess() {
        final Point expected = Game;
        final Point actual = point  // Love
                .increment()        // Fifteen
                .increment()        // Thirty
                .increment()        // Forty
                .increment()        // Advantage
                .increment()        // Game
                .increment();       // Game (again)
        assertEquals(expected, actual);
        log.info("success for point increment from {} to {}", expected, actual);
    }
}
