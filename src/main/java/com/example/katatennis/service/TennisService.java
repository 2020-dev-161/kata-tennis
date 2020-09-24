package com.example.katatennis.service;

import com.example.katatennis.domain.Player;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class TennisService implements Tennis {

    private final ScoreService scoreService;

    public void newGame(final Player playerOne, final Player playerTwo) {
        scoreService.newGame(playerOne, playerTwo);
    }

    public boolean isDecided() {
        return scoreService.getTotalScore().equals("Winner");
    }

    public void playerOneWinBall() {
        scoreService.playerOneWinBall();
    }

    public void playerTwoWinBall() {
        scoreService.playerTwoWinBall();
    }

    public String getScorePlayerOne() {
        return scoreService.getScorePlayerOne();
    }

    public String getScorePlayerTwo() {
        return scoreService.getScorePlayerTwo();
    }

    public String getTotalScore() {
        return scoreService.getTotalScore();
    }
}
