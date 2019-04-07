/**
 * 
 */
package com.candidate.chutesladders.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.candidate.chutesladders.bean.GameBoard;
import com.candidate.chutesladders.bean.Player;
import static com.candidate.chutesladders.constant.ChutesLaddersConstants.*;
import com.candidate.chutesladders.manager.GameManager;
import com.candidate.chutesladders.manager.RulesManager;
import com.candidate.chutesladders.spring.ChutesLaddersProperties;
import com.candidate.chutesladders.util.Printer;
import com.candidate.chutesladders.util.Spinner;

/**
 * @author Bharath
 *
 */
@Component
public class GameRunner {
	private static final Logger LOGGER = LoggerFactory.getLogger(GameRunner.class);

	@Autowired
	private ChutesLaddersProperties properties;

	@Autowired
	private GameManager gameManager;

	@Autowired
	private RulesManager rulesManager;

	@Autowired
	private GameBoard gameBoard;

	@Autowired
	private Spinner spinner;

	@Autowired
	private Printer printer;

	public void play() {
		LOGGER.info(MSG_ENTERED);
		boolean gameEnded = false;
		Player winner = null;
		int gameMoveId = 0;
		// init game
		gameManager.initGame(properties.getPlayers());
		// Repeat until game ends
		while (!gameEnded) {
			// Iterate players to simulating play
			for (Player player : gameBoard.getPlayers()) {
				gameMoveId++;
				// reset local fields
				int oldPos = 0, newPos = 0, tempPos = 0, modifiedPos = 0, cause = 0;
				// print non-first run
				if (gameMoveId > gameBoard.getPlayers().size()) {
					oldPos = player.getPosition();
					newPos = oldPos + spinner.spin();
				} else {
					// print conditionally for the first-run
					oldPos = 0;
					newPos = player.getPosition();
				}
				// validate the new position
				if (rulesManager.isValidMove(newPos)) {
					player.setPosition(newPos);
					// check if its on ladder
					tempPos = rulesManager.isOnLadder(newPos);
					if (tempPos > 0) {
						modifiedPos = tempPos;
						// moving up
						gameManager.moveUpByLadder(player, modifiedPos);
						cause = 1;
					} else {
						// check if its on chute
						tempPos = rulesManager.isOnChute(newPos);
						if (tempPos > 1) {
							modifiedPos = tempPos;
							// moving down
							gameManager.moveDownByChute(player, modifiedPos);
							cause = 2;
						}
					}
				} else {
					// don't move if its not a valid move
					newPos = oldPos;
				}
				// print stat
				printer.stat(gameMoveId, player.getName(), oldPos, newPos, modifiedPos, cause);
				// check if the player has won
				if (rulesManager.isGameEnd(player.getPosition())) {
					gameEnded = true;
					winner = player;
					break;
				}
			}
		}
		// end game
		gameManager.endGame(winner);
		LOGGER.info(MSG_EXITED);
	}

}
