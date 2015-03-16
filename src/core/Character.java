package core;

import items.Item;
import items.ItemType;
import items.Weapon;

import java.util.ArrayList;

import status.Death;
import status.Status;
import enums.DamageNature;
import enums.Direction;

public class Character {
	
	String name;
	boolean ready;
	Archtype type;
	ArrayList<Status> status;
	
	//******** Fighting stats ******
	int actionPoints = 0;
	int maxActionPoints = 10;
	int movementPoints = 6;
	int currentHealth = -1;
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
	
	/**
	 * This method should always and at least contains one weapon (the default one).
	 * @Returns Returns an arraylist containing every weapon in the character inventory.
	 * 
	 */
	public ArrayList<Weapon> getWeapons() {
		ArrayList<Weapon> weapons = new ArrayList<Weapon>();
		for (Item i : type.getInventory()) {
			if (i.getType().equals(ItemType.Weapon)) {
				weapons.add((Weapon)i);
			}
		}
		return weapons;
	}
	
	/**
	 * This method always uses the first weapon found with getWeapons
	 * @param target is the character targeted with the attack.
	 * 
	 */
	public void attack(Character target) {
		int attackCost = type.getAttackCost();
		if (actionPoints<attackCost) {
			//TODO print can't attack target : not enough action points
			return ;
		}
		actionPoints -= attackCost;
		/*  The actual hit */
		
	}

	
	/**
	 * This method should not be called, see attack instead.
	 * @param damage is the amount of damage inflicted to this character.
	 * @param nature is the nature of the damage inflicted
	 */
	public void _hit (int damage, DamageNature nature) {
		int actualDamage = 0;
		switch (nature) {
			case Bacteriological :
				//TODO reduction table 
				break;
			case Chaos :
				actualDamage = damage;
			
			default :
				actualDamage = damage;
		}
		
		currentHealth -= actualDamage;
		checkDeath();
	}

	/**
	 * Add the status Death to the status list if the current health is below 0
	 */
	public void checkDeath() {
		if (currentHealth<=0) {
			status.add(new Death());
		}
	}
}
