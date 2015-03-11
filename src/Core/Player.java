package Core;

import java.util.ArrayList;

public class Player {
	String name;
	ArrayList<Character> team;
	
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

	public String getName() {
		return name;
	}
	public void setName(String n) {name = n;}
}
