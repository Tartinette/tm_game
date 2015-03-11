package Core;

import java.util.ArrayList;

import Enums.Direction;
import Status.Death;
import Status.Status;

public class Character {
	
	String name;
	boolean ready;
	Archtype type;
	ArrayList<Status> status;
	
	//******** Fighting stats ******
	int actionPoints = 0;
	int maxActionPoints = 10;
	int movementPoints = 6;
	int currentHealth = 1;
	int maxHealth = 1;
	int resource = 0;
	int maxResource = 0;
	Direction direction;
	int armor;
	int[] resistance = new int[5];// resistances
	
	
	public Character (String n, Archtype t) {
		name = n;
		ready = false;
		type = t;
	}
	
	public Character (Archtype t) {
		name = "Jean Michel";
		type = t;
	}
	
	/**
	 *  Check if the status list contains death
	 * @return true if death is one of the status affecting this character
	 */
	public boolean isDead() {
		if (!status.isEmpty()) {
			return status.contains(new Death());
		} else {return false;}
	}
	
	public boolean isReady() {
		return ready;
	}
	
	/**
	 * Apply all the buffs's effects on the character
	 */
	public void applyEffect(){
		if (!status.isEmpty())
			for (Status s : status) {
				s.applyEffect(this);
			}
	}
	
	public void ready() {
		if (!isDead()) {
		//set currentAP to max
		//set mode to max
		ready = true;
		}
	}
}
