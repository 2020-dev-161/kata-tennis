package com.example.katatennis.service;

import com.example.katatennis.domain.Player;

public interface Score {

    void newGame(final Player playerOne, final Player playerTwo);

    void playerOneWinBall();

    void playerTwoWinBall();

    String getScorePlayerOne();

    String getScorePlayerTwo();

    String getTotalScore();

}
