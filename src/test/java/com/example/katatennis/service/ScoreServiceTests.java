package com.example.katatennis.service;

import com.example.katatennis.domain.Game;
import com.example.katatennis.domain.Player;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.example.katatennis.domain.Point.Fifteen;
import static com.example.katatennis.domain.Point.Love;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ScoreServiceTests {

    @InjectMocks
    private ScoreService scoreService;

    @Mock
    private Game game;

    @BeforeAll
    void init() {
        //Mockito.when(game.getPlayerOne().getPoint()).thenReturn(Fifteen);
        //Mockito.when(scoreService.getTotalScore()).thenReturn("Deuce");
        //Mockito.when(scoreService.getScorePlayerOne()).thenReturn("Fifteen");
        //Mockito.when(scoreService.getScorePlayerTwo()).thenReturn("Thirty");
        scoreService.newGame(new Player("Sue"), new Player("Sara"));
   }

    @Test
    public void testNewGameSuccess() {
        scoreService.newGame(new Player("Tom"), new Player("Joe"));
    }

    @Test
    public void testPlayerOneWinBallSuccess() {
        scoreService.playerOneWinBall();
        assertEquals(Fifteen.toString(), scoreService.getScorePlayerOne());
    }

    @Test
    public void testPlayerTwoWinBallSuccess() {
        scoreService.playerTwoWinBall();
        assertEquals(Fifteen.toString(), scoreService.getScorePlayerTwo());
    }

    @Test
    public void testGetScorePlayerOne() {
        assertEquals(Fifteen.toString(), scoreService.getScorePlayerOne());
    }

    @Test
    public void testGetScorePlayerTwo() {
        assertEquals(Fifteen.toString(), scoreService.getScorePlayerTwo());
    }

    @Test
    public void testGetTotalScore() {
        assertEquals("", scoreService.getTotalScore());
    }
}