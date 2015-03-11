package Core;

import java.util.ArrayList;

public class Player {
	String name;
	ArrayList<Character> team;
	
	
	//****************************** In game related methods ***********************************
	/***
	 * 
	 * @return is [player] eliminated?
	 */
	public boolean isEliminated() {
		for (Character c : team) {
			if (!c.isDead()) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isFinished() {
		for (Character c : team) {
			if (!c.isReady()) {
				return false;
			}
		}
		return true;
	}
	
	public void readyTeam () {
		for (Character c : team) {
			c.ready();
			c.applyEffect();
		}
	}

	//****************************** Not in game related methods ***********************************
	
	public void addCharacter (String name, Archtype t) {
		team.add(new Character(name, t));
	}
	
	public String getName() {
		return name;
	}
	public void setName(String n) {name = n;}
}
