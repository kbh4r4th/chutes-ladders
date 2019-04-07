/**
 * 
 */
package com.candidate.chutesladders.manager;

import static com.candidate.chutesladders.constant.ChutesLaddersConstants.MSG_ENTERED;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.candidate.chutesladders.bean.GameBoard;

/**
 * @author Bharath
 *
 */
@Component
public class RulesManagerImpl implements RulesManager {
	private static final Logger LOGGER = LoggerFactory.getLogger(RulesManagerImpl.class);

	@Autowired
	private GameBoard gameBoard;

	@Override
	public boolean isValidMove(int pos) {
		LOGGER.debug(MSG_ENTERED);
		return pos <= gameBoard.getSize();
	}

	@Override
	public int isOnChute(int head) {
		LOGGER.debug(MSG_ENTERED);
		// O(1)
		if (GameBoard.getChuteMap().containsKey(head))
			return GameBoard.getChuteMap().get(head);
		return -1;
	}

	@Override
	public int isOnLadder(int head) {
		LOGGER.debug(MSG_ENTERED);
		// O(1)
		if (GameBoard.getLadderMap().containsKey(head))
			return GameBoard.getLadderMap().get(head);
		return -1;
	}

	@Override
	public boolean isGameEnd(int position) {
		LOGGER.debug(MSG_ENTERED);
		if (position == gameBoard.getSize())
			return true;
		return false;
	}

}