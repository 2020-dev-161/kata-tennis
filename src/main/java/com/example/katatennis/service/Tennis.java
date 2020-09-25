package com.example.katatennis.service;

import com.example.katatennis.domain.Player;

public interface Tennis {

    void newGame(final Player playerOne, final Player playerTwo);

    boolean isDecided();

    void playerOneWinBall();

    void playerTwoWinBall();

    String getScorePlayerOne();

    String getScorePlayerTwo();

    String getTotalScore();
}
