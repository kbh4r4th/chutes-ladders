/**
 * 
 */
package com.candidate.chutesladders.manager;

/**
 * @author Bharath
 *
 */
public interface RulesManager {
	public abstract boolean isValidMove(int pos);

	public abstract int isOnChute(int head);

	public abstract int isOnLadder(int head);

	public abstract boolean isGameEnd(int position);
}