package Core;

public class Character {
	
	String name;
	boolean ready;
	Archtype type;
	
	public Character (String n, Archtype t) {
		name = n;
		ready = false;
		type = t;
	}
	
	public Character (Archtype t) {
		name = "Jean Michel";
		type = t;
	}
	
	//TODO
	public boolean isDead() {
		return true;
	}
	
	public boolean isReady() {
		return ready;
	}
	
	//TODO
	public void applyEffect(){
		
	}
	
	public void ready() {
		if (!isDead()) {
		//set currentAP to max
		//set mode to max
		ready = true;
		}
	}
}
