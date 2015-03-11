package Core;

import java.util.ArrayList;

import Enums.GameMode;

public class Game {
	
	Player currentPlayer;
	int _currentPlayerIndex;
	ArrayList<Player> participants;
	//TODO improve game modes
	GameMode mode;
	boolean _victory;
	
	public Game (ArrayList<Player> p, GameMode m) {
		participants = p;
		currentPlayer = p.get(0);
		_currentPlayerIndex = 0;
		_victory = false;
	}
	
	/***
	 * Handle the preparation phase cf googleDrive
	 * 
	 */
	public void prepPhase () {
		//TODO
	} 
	
	/**
	 * Core function handling the fight
	 */
	public void combatPhase () {
		while (!_victory) {
			nextTurn();
		}
	}
	
	public void nextTurn() {
		
	}
	
	public boolean checkVictory () {
		for (Player p : participants) {
			if (!p.getName().equals(currentPlayer.getName())) {
				if (!p.isEliminated()) {
					return false;
				}
			}
		}
		return true;
	}
}
