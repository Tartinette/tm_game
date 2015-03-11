package Core;

public class Character {
	
	boolean ready;
	
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
