package core;

import items.Inventory;
import character.Race;
import character._Class;
import enums.Carac;

public class Archtype {
	
	String name;
	int cost;
	_Class _class;
	Race origin;
	Inventory stuff;
	int[] attributes = new int[5];
	int totalFreeAttributePoint;
	int level;
	
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
	
	//TODO prevent user from reducing stat below the base or above the max allowed by free points
	public void increase(Carac c) {
		switch (c) {
			case Logic : 
				attributes[0]++;
				break;
				
			case Power : 
				attributes[1]++;
				break;
				
			case Precision : 
				attributes[2]++;
				break;
				
			case Resilience :
				attributes[3]++;
				break;
				
			case Vigor :
				attributes[4]++;
				break;
				
				default : 
					totalFreeAttributePoint ++;
		}
		totalFreeAttributePoint --;
	}
	
	public void decrease(Carac c) {
		switch (c) {
		case Logic : 
			attributes[0]--;
			break;
			
		case Power : 
			attributes[1]--;
			break;
			
		case Precision : 
			attributes[2]--;
			break;
			
		case Resilience :
			attributes[3]--;
			break;
			
		case Vigor :
			attributes[4]--;
			break;
			
			default : 
				totalFreeAttributePoint --;
	}
	totalFreeAttributePoint ++;
	}
}
