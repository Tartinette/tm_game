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
	
	public int getAttackCost() {
		// TODO Auto-generated method stub
		return 0;
	}		
	
	public Inventory getInventory () {
		return stuff;
	}
}
