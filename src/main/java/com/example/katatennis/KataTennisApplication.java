package com.example.katatennis;

import com.example.katatennis.domain.Player;
import com.example.katatennis.service.TennisService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.System.out;

@SpringBootApplication
public class KataTennisApplication implements CommandLineRunner {

	@Autowired
	private TennisService tennisService;

	public static void main(final String[] args) {
		SpringApplication.run(KataTennisApplication.class, args);
	}

	@Override
	public void run(final String... args) throws Exception {
		demonstrateTennisApplication();
	}

	private void demonstrateTennisApplication() {
		final Player playerOne = new Player("Tom");
		final Player playerTwo = new Player("Joe");
		tennisService.newGame(playerOne, playerTwo);
		printHeader(playerOne.getName(), playerTwo.getName());
		printScore();
		while (!tennisService.isDecided()) {
			if (playUntilScored()) {
				tennisService.playerOneWinBall();
			} else {
				tennisService.playerTwoWinBall();
			}
			printScore();
		}
	}

	@SneakyThrows
	private boolean playUntilScored() {
		Thread.sleep(1000L + (long) (1000*Math.random()));
		return Math.random() > 0.5;
	}

	private void printHeader(final String playerOne, final String playerTwo) {
		out.printf("New game: %20s %20s %n", playerOne, playerTwo);
	}

	private void printScore() {
		final String scoreOne = tennisService.getScorePlayerOne();
		final String scoreTwo = tennisService.getScorePlayerTwo();
		final String decided = tennisService.getTotalScore();
		out.printf("          %20s %20s %20s %n", scoreOne, scoreTwo, decided);
	}
}
