/**
 * 
 */
package com.flax.api.tracker;

import java.util.HashMap;
import java.util.Map;

import org.dreambot.api.methods.skills.Skill;

import com.flax.api.Flax;

/**
 * @author Ian
 *
 */
public class ExperienceTracker {
	private Map<Skill, Integer> cache_experience = null;
	private Map<Skill, Integer> cache_level = null;
	
	public ExperienceTracker() {	
		cache_level = new HashMap<Skill, Integer>();
		cache_experience = new HashMap<Skill, Integer>();
		
		// Update Tables
		updateTables();
	}
	
	/**
	 * Resets Any Earned Experience/Levels
	 */
	public void resetTracker() {
		Flax.log("[ExperienceTracker] Resetting Tables.");
		cache_level.clear();
		cache_experience.clear();
		
		updateTables();
	}
	
	/**
	 * Gets the Gained Levels for a given skill
	 * @param skill
	 * @return The Levels you have gained
	 */
	public int getGainedLevels(Skill skill) {
		int current_level = Flax.getContext().getSkills().getRealLevel(skill);
		int starting_level = cache_level.get(skill);
		
		return current_level - starting_level;
	}
	
	/**
	 * Gets the Gained Experience for a given skill
	 * @param skill
	 * @return Amount of Experience Gained
	 */
	public int getGainedExperience(Skill skill) {
		int current_experience = Flax.getContext().getSkills().getExperience(skill);
		int starting_experience = cache_experience.get(skill);
		
		return current_experience - starting_experience;
	}
	
	/**
	 * Gets the Starting Experience for a given Skill
	 * @param skill
	 * @return Starting Experience
	 */
	public int getStartingExperience(Skill skill) {
		return cache_experience.get(skill);
	}
	
	/**
	 * Gets the Starting Level for a given skill
	 * @param skill
	 * @return Starting Level
	 */
	public int getStartingLevel(Skill skill) {
		return cache_level.get(skill);
	}
	
	/**
	 * Fetchs the Starting Experience/Levels for all Skills. 
	 */
	private void updateTables() {
		Flax.log("[ExperienceTracker] Fetching Experience/Levels.");
		for(Skill skill : Skill.values()) {
			cache_experience.put(skill, Flax.getContext().getSkills().getExperience(skill));
			cache_level.put(skill, Flax.getContext().getSkills().getRealLevel(skill));
		}
		
		Flax.log("[ExperienceTracker] Fetch Completed!");
	}
	
	
}
