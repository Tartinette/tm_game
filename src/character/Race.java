package character;

import core.Skill;
import enums.RaceName;

public class Race {

	RaceName name;
	Skill racialActive;
	Skill racialPassive;
	
	public Race (RaceName n) {
		name = n;
		
		//TODO add skills 
		switch (n) {
		
		default :
			
		}
	}
	
	public RaceName getName() {return name;}
	public Skill getRacialActive() {return racialActive;}
	public Skill getRacialPassive() {return racialPassive;}
	
}
