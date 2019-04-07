/**
 * 
 */
package com.candidate.chutesladders.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * @author Bharath
 *
 */
@Component
public class GameBoard {
	private int size;

	private List<Player> players = new ArrayList<>();

	private static Map<Integer, Integer> chuteMap = new HashMap<>();

	private static Map<Integer, Integer> ladderMap = new HashMap<>();

	public void setSize(int size) {
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public static Map<Integer, Integer> getChuteMap() {
		return chuteMap;
	}

	public static void setChuteMap(Map<Integer, Integer> chuteMap) {
		GameBoard.chuteMap = chuteMap;
	}

	public static Map<Integer, Integer> getLadderMap() {
		return ladderMap;
	}

	public static void setLadderMap(Map<Integer, Integer> ladderMap) {
		GameBoard.ladderMap = ladderMap;
	}

}
