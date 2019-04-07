/**
 * 
 */
package com.candidate.chutesladders.manager;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.candidate.chutesladders.bean.GameBoard;
import com.candidate.chutesladders.bean.Player;
import com.candidate.chutesladders.constant.ChutesLaddersConstants;
import com.candidate.chutesladders.spring.ChutesLaddersProperties;
import com.candidate.chutesladders.util.Spinner;

/**
 * @author Bharath
 *
 */
@Component
public class GameManagerImpl implements GameManager, ChutesLaddersConstants {
	private static final Logger LOGGER = LoggerFactory.getLogger(GameManagerImpl.class);

	@Autowired
	private ChutesLaddersProperties properties;

	@Autowired
	private Spinner spinner;

	@Autowired
	private GameBoard gameBoard;

	@Override
	public void initGame(List<Player> playerList) {
		LOGGER.debug(MSG_ENTERED);
		// set board size
		gameBoard.setSize(properties.getBoardSize());
		// first-spin to determine the play order
		playerList.forEach(player -> {
			player.setPosition(spinner.spin());
		});
		// sort descending based on position
		Collections.sort(playerList, new Comparator<Player>() {
			public int compare(Player o1, Player o2) {
				return -(o1.getPosition().compareTo(o2.getPosition()));
			};
		});
		// set sorted (descending)
		gameBoard.setPlayers(playerList);
		// set chuteMap
		GameBoard.setChuteMap(properties.getChutes());
		// set ladderMap
		GameBoard.setLadderMap(properties.getLadders());
		LOGGER.debug(MSG_EXITED);
	}

	@Override
	public void moveDownByChute(Player player, int newPos) {
		LOGGER.debug(MSG_ENTERED);
		player.setPosition(newPos);
		LOGGER.debug(MSG_EXITED);
	}

	@Override
	public void moveUpByLadder(Player player, int newPos) {
		LOGGER.debug(MSG_ENTERED);
		player.setPosition(newPos);
		LOGGER.debug(MSG_EXITED);

	}

	@Override
	public void endGame(Player player) {
		LOGGER.debug(MSG_ENTERED);
		LOGGER.info(MSG_WINNER, player.getName());
		LOGGER.debug(MSG_EXITED);
	}

}
