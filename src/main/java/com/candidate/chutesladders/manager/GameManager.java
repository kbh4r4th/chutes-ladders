/**
 * 
 */
package com.candidate.chutesladders.manager;

import java.util.List;

import com.candidate.chutesladders.bean.Player;

/**
 * @author Bharath
 *
 */
public interface GameManager {
	public abstract void initGame(List<Player> playerList);

	public abstract void moveDownByChute(Player player, int newPos);

	public abstract void moveUpByLadder(Player player, int newPos);

	public abstract void endGame(Player player);

}
