package core;

import enums.SkillName;

public class Skill {
	
	public SkillName name;
	public String displayName;
	
	public Skill (SkillName name) {
		
	}
	
	
	public void setDisplayName() {
		//TODO see how this works and improve
		displayName = name.toString();
	}
}
