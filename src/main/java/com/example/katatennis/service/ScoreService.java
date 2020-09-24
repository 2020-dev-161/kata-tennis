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
        final Point pointsOne = game.getPlayerOne().getPoint();
        final Point pointsTwo = game.getPlayerTwo().getPoint();
        final boolean equalScore = pointsOne == pointsTwo;
        final boolean fortyPoints = pointsOne == Forty;
        log.debug(" - {} {}", equalScore, fortyPoints);
        return equalScore && fortyPoints;
    }

    private boolean isWonByTwoPoints() {
        log.debug("> isWonByTwoPoints()");
        final Point pointsOne = game.getPlayerOne().getPoint();
        final Point pointsTwo = game.getPlayerTwo().getPoint();
        final boolean oneWins = isWonByTwoPoints(pointsOne, pointsTwo);
        final boolean twoWins = isWonByTwoPoints(pointsTwo, pointsOne);
        log.debug("- {} {}", oneWins, twoWins);
        return oneWins || twoWins;
    }

    private boolean isWonByTwoPoints(final Point pointsOne, final Point pointsTwo) {
        return (pointsOne.ordinal() >= Forty.ordinal())
                && pointsOne.ordinal() - pointsTwo.ordinal() >= 2;
    }

    private void deuceIfBothAdvantage() {
        final Player playerOne = game.getPlayerOne();
        final Player playerTwo = game.getPlayerTwo();
        final Point pointsOne = playerOne.getPoint();
        final Point pointsTwo = playerTwo.getPoint();
        final boolean equalScore = pointsOne == pointsTwo;
        final boolean advantagePoints = pointsOne == Advantage;
        if (equalScore && advantagePoints) {
            playerOne.setPoint(Forty);
            playerTwo.setPoint(Forty);
        }
    }
}
