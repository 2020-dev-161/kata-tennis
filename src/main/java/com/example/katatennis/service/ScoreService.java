package com.example.katatennis.service;

import com.example.katatennis.domain.Game;
import com.example.katatennis.domain.Player;
import com.example.katatennis.domain.Point;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.example.katatennis.domain.Point.*;

@Service
@Slf4j
public class ScoreService implements Score {

    private Game game;

    public void newGame(final Player playerOne, final Player playerTwo) {
        log.info("> newGame(), arguments: {}, {}", playerOne, playerTwo);
        game = new Game(playerOne, playerTwo);
    }

    public void playerOneWinBall() {
        log.info("> playerOneWinBall()");
        playerWinBall(game.getPlayerOne());
        deuceIfBothAdvantage();
    }

    public void playerTwoWinBall() {
        log.info("> playerTwoWinBall()");
        playerWinBall(game.getPlayerTwo());
        deuceIfBothAdvantage();
    }

    public String getScorePlayerOne() {
        log.info("> getScorePlayerOne()");
        return getScorePlayer(game.getPlayerOne());
    }

    public String getScorePlayerTwo() {
        log.info("> getScorePlayerTwo()");
        return getScorePlayer(game.getPlayerTwo());
    }

    public String getTotalScore() {
        if (isDeuce()) {
            return "Deuce";
        }
        if (isWonByTwoPoints()) {
            return "Winner";
        }
        return "";  // just keep playing
    }

    private void playerWinBall(final Player player) {
        log.debug("> playerWinBall(), argument: {}", player);
        log.debug("- current point: {}", player.getPoint());
        player.incrementPoint();
        log.debug("- new point: {}", player.getPoint());
    }

    private String getScorePlayer(final Player player) {
        log.debug("> getScorePlayer(), argument: {}", player);
        log.debug("- point(s): {}", player.getPoint());
        return player.getPoint().toString();
    }

    private boolean isDeuce() {
        log.debug("> isDeuce()");
        final Player playerOne = game.getPlayerOne();
        final Player playerTwo = game.getPlayerTwo();
        final boolean equalScore = equalScore(playerOne, playerTwo);
        final boolean fortyPoints = playerOne.getPoint() == Forty;
        log.debug(" - conditions: {} {}", equalScore, fortyPoints);
        return equalScore && fortyPoints;
    }

    private boolean isWonByTwoPoints() {
        log.debug("> isWonByTwoPoints()");
        final Player playerOne = game.getPlayerOne();
        final Player playerTwo = game.getPlayerTwo();
        final boolean oneWins = isWonByTwoPoints(playerOne.getPoint(), playerTwo.getPoint());
        final boolean twoWins = isWonByTwoPoints(playerTwo.getPoint(), playerOne.getPoint());
        log.debug("- conditions: {} {}", oneWins, twoWins);
        return oneWins || twoWins;
    }

    private boolean isWonByTwoPoints(final Point pointsOne, final Point pointsTwo) {
        return (pointsOne.ordinal() >= Forty.ordinal())
                && pointsOne.ordinal() - pointsTwo.ordinal() >= 2;
    }

    private void deuceIfBothAdvantage() {
        final Player playerOne = game.getPlayerOne();
        final Player playerTwo = game.getPlayerTwo();
        final boolean equalScore = equalScore(playerOne, playerTwo);
        final boolean advantagePoints = playerOne.getPoint() == Advantage;
        if (equalScore && advantagePoints) {
            playerOne.setPoint(Forty);
            playerTwo.setPoint(Forty);
        }
    }

    private boolean equalScore(final Player playerOne, final Player playerTwo) {
        final Point pointsOne = playerOne.getPoint();
        final Point pointsTwo = playerTwo.getPoint();
        final boolean equalScore = pointsOne == pointsTwo;
        return equalScore;
    }
}
