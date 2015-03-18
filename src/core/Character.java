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
	
	String name; /** Character name*/
	boolean ready;
	Archtype type;
	ArrayList<Status> status;
	CalculationTable table = new CalculationTable();
	
	//******** Fighting stats ******
	int actionPoints = 0;
	int maxActionPoints = 10;
	int movementPoints = 6; 
	int currentHealth = -1; 
	int maxHealth = 1;
	int resource = 0; /** current amount of resource available to the character*/
	int maxResource = 0;
	Direction direction;
	int armor; /* should be equivalent to physical resistance (ie resistance[2])*/
	int[] resistance = new int[5]; /** This array contains the value of the different resistance : {Bacteriological, Chemical, Physical, Psi, Psychological} */
	
	
	public Character (String n, Archtype t) {
		name = n;
		ready = false;
		type = t;
		resistance = t.generateBaseResistance();
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
	 * This method always uses the first weapon found with getWeapons. This method decrease the character action point with the hit cost and uses the
	 * getReduction method from core.CalculationTable to apply armor and resistance. Reduce directly the health of the target.
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
	 * This method should not be called, see attack instead. This method uses the getReduction(int) method from core.CalculationTable
	 * @param damage is the amount of damage inflicted to this character.
	 * @param nature is the nature of the damage inflicted
	 */
	public void _hit (int damage, DamageNature nature) {
		int actualDamage = 0;
		switch (nature) {
			case Bacteriological :
				actualDamage = damage*table.getReduction(this.resistance[0]);
				break;
				
			case Chemical :
				actualDamage = damage*table.getReduction(this.resistance[1]);
				break;
				
			case Physical : 
				actualDamage = damage*table.getReduction(this.resistance[2]);
				break;
				
			case Psi :
				actualDamage = damage*table.getReduction(this.resistance[3]);
				break;
				
			case Psychological : 
				actualDamage = damage*table.getReduction(this.resistance[4]);
				break;
				
			case Chaos :
				/* This damage are not reductible with any resistance but still can be prevented by other effects like temporary health*/
				actualDamage = damage;
				break;
				
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
