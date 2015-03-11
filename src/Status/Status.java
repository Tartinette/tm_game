package Status;

import Core.Character;

public abstract class Status {
	
	int duration;// -1 means a permanent effect
	boolean buff;
	
	public Status (int d, boolean b) {
		duration = d;
		buff = b;
	}
	
	public Status () {
		duration = -1;
		buff = false;
	}
	
	public Status (int d) {
		duration = d;
		buff = true;
	}
	
	public boolean isBuff () {return buff;}
	public int getDuration () {return duration;}
	
	/**
	 * 
	 * @return true is the status is no longer effective
	 */
	public boolean applyEffect (Character c) {
		duration --;
		return duration==0;
	}
	
	//TODO verify if this works
	@Override
	public boolean equals (Object o) {
		return this.getClass().equals(o.getClass());
	}
}
