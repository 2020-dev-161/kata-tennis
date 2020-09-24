package com.example.katatennis.service;

import com.example.katatennis.domain.Player;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.example.katatennis.domain.Point.Fifteen;
import static com.example.katatennis.domain.Point.Thirty;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TennisServiceTests {

    @InjectMocks
    private TennisService tennisService;

    @Mock
    private ScoreService scoreService;

    @BeforeAll
    void init() {
        Mockito.when(tennisService.getTotalScore()).thenReturn("Winner");
        Mockito.when(tennisService.getScorePlayerOne()).thenReturn("Fifteen");
        Mockito.when(tennisService.getScorePlayerTwo()).thenReturn("Thirty");
    }

    @Test
    public void testNewGameSuccess() {
        tennisService.newGame(new Player("Tom"), new Player("Joe"));
    }

    @Test
    public void testIsDecidedSuccess() {
        assertEquals("Winner", tennisService.getTotalScore());
    }

    @Test
    public void testPlayerOneWinBallSuccess() {
        tennisService.playerOneWinBall();
        assertEquals(Fifteen.toString(), tennisService.getScorePlayerOne());
    }

    @Test
    public void playerTwoWinBall() {
        tennisService.playerTwoWinBall();
        assertEquals(Thirty.toString(), tennisService.getScorePlayerTwo());
    }

    @Test
    public void testGetScorePlayerOne() {
        assertEquals(Fifteen.toString(), tennisService.getScorePlayerOne());
    }

    @Test
    public void getScorePlayerTwo() {
        assertEquals(Thirty.toString(), tennisService.getScorePlayerTwo());
    }

    @Test
    public void getTotalScore() {
        assertEquals("Winner", tennisService.getTotalScore());
    }
}
