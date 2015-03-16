package items;

import enums.Carac;
import enums.DamageNature;
import enums.WeaponClass;

public class Weapon extends Item{

	WeaponClass _class;
	Carac mainCarac;
	int attackCost;
	DamageNature nature;
	
	
	public DamageNature getNature () {
		return nature;
	}
	
	public int getAttackCost () {
		return attackCost;
	}
	
	public Carac getMainCarac () {
		return mainCarac;
	}
	
	/**
	 * This one shouldn't be used unless you are creating a very specific weapon.
	 */
	public Weapon (WeaponClass c, int ac, DamageNature n) {
		_class = c;
		switch (_class) {
			case Rifle :
				mainCarac = Carac.Precision;
				break;
				
			case Blade :
				mainCarac = Carac.Power;
				break;
				
			case FlameThrower : 
				mainCarac = Carac.Power;
				break;
				
			case Shotgun : 
				mainCarac = Carac.Precision;
				break;
				
			case Spear : 
				mainCarac = Carac.Power;
				break;
				
			default : 
				mainCarac = Carac.None;
		}
		attackCost = ac;
		nature = n;
	}
	
	/**
	 * Basic constructor for most weapon
	 * Some other might be constructed with some more complex rules and therefore with another method.
	 */
	public Weapon (WeaponClass c) {
		this(c, 4, DamageNature.Physical);
	}
	
	public WeaponClass getWeaponClass () {
		return _class;
	}
	
	@Override
	public ItemType getType() {
		return ItemType.Weapon;
	}
}
