package core;

import items.Inventory;
import character.Race;
import character._Class;

public class Archtype {
	
	String name;
	int cost;
	_Class _class;
	Race origin;
	Inventory stuff;
	int[] attributes = new int[5];
	
	public Archtype () {
		
	}
	
	public int getAttackCost() {
		// TODO Auto-generated method stub
		return 0;
	}		
	
	public Inventory getInventory () {
		return stuff;
	}

	/**
	 * Returns an array containing the amount of each resistance granted by the character attributes. 
	 * @Warning The base physical resistance is 0.
	 */
	public int[] generateBaseResistance() {
		int[] resistance = new int[5];
		for (int i : attributes) {
			resistance[i] = attributes[i]/3; 
		}
		/* Physical resistance does not depend on main attributes*/
		resistance[2] = 0;
		return resistance;
	}
}
