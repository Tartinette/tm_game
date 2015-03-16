package items;

import core.Targetable;


public abstract class Item {
	int cost;
	
	public void applyContinuousEffect(Character c) {}
	public void applyInstantEffect(Targetable target) {}
	public ItemType getType() {
		return ItemType.ERROR;
	}
}
