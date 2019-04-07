/**
 * 
 */
package com.candidate.chutesladders.spring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.candidate.chutesladders.bean.Player;

/**
 * @author Bharath
 *
 */
@ConfigurationProperties(prefix = "chutes-ladders")
public class ChutesLaddersProperties {
	private int boardSize;

	private int spinnerSize;

	private Map<Integer, Integer> chutes = new HashMap<>();

	private Map<Integer, Integer> ladders = new HashMap<>();

	private List<Player> players = new ArrayList<>();

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public int getBoardSize() {
		return boardSize;
	}

	public void setBoardSize(int boardSize) {
		this.boardSize = boardSize;
	}

	public int getSpinnerSize() {
		return spinnerSize;
	}

	public void setSpinnerSize(int spinnerSize) {
		this.spinnerSize = spinnerSize;
	}

	public Map<Integer, Integer> getChutes() {
		return chutes;
	}

	public void setChutes(Map<Integer, Integer> chutes) {
		this.chutes = chutes;
	}

	public Map<Integer, Integer> getLadders() {
		return ladders;
	}

	public void setLadders(Map<Integer, Integer> ladders) {
		this.ladders = ladders;
	}

}
