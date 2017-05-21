/**
 * 
 */
package com.flax.api.event;

import org.dreambot.api.methods.skills.Skill;

/**
 * @author Ian
 *
 */
public class LevelEvent extends GameEvent {
	private Skill 		event_skill 	= null;
	private int			previous_level 		= 0;
	private int 		level 		= 0;
	
	public LevelEvent(Skill skill, int prev_level, int new_level) {
		super(GameEvent.EVENT_LEVEL_UP);
		
		this.event_skill = skill;
		this.previous_level = prev_level;
		this.level = new_level;
	}
	
	public Skill getSkill() {
		return event_skill;
	}
	
	public int getPreviousLevel() {
		return previous_level;
	}
	
	public int getLevel() {
		return level;
	}
}
