package core;

import java.util.ArrayList;

import enums.GameMode;

public class Game {
	
	Player currentPlayer;
	int turnNumber;
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
	
	public void startGame() {
		_prepPhase();
		combatPhase();
	}
	
	/***
	 * Handle the preparation phase cf googleDrive
	 * 
	 */
	public void _prepPhase () {
		switch (mode) {
			case _DRAFT_FFA : 
				prepareDraft();
		
			default : 
				prepareBlind();
		}
	} 
	
	//TODO
	public void prepareBlind() {}
	public void prepareDraft() {}
	
	/**
	 * Core function handling the fight
	 */
	public void combatPhase () {
		if (!_victory) {
			turnNumber ++;
			_nextTurn();
			beginTurn();
		} else {
			//TODO end the game
		}
	}
	
	/***
	 * Handle the beginning of a new turn
	 */
	public void _nextTurn() {
		_currentPlayerIndex ++;
		if (_currentPlayerIndex==participants.size()) {
			_currentPlayerIndex = 0;
		}
		currentPlayer = participants.get(_currentPlayerIndex);
		if (currentPlayer.isEliminated()) {
			_nextTurn();
		} else {
			String message = currentPlayer.getName() + "'s turn to play.";
			//TODO implements console view
			System.out.println(message);
		}
	}
	
	/**
	 * Get every available character in the players team ready
	 */
	public void beginTurn() {
		//Apply debuff/buffs on team members
		currentPlayer.readyTeam();
		//TODO Highlight ready characters
	}
	
	
	public void charFinishedPlaying () {
		if (currentPlayer.isFinished()) {
			combatPhase();
		}
	}
	
	public boolean checkVictory () {
		for (Player p : participants) {
			if (!p.getName().equals(currentPlayer.getName())) {
				if (!p.isEliminated()) {
					_victory = false;
					return false;
				}
			}
		}
		_victory = true;
		return true;
	}
}
