/**
 * 
 */
package com.flax.api.enums;

import org.dreambot.api.methods.map.Tile;

/**
 * @author Ian
 *
 */
public enum Ores {
	CLAY(			"Clay", 		434, 	1, 		5.0,	false),
	RUNE_ESSENCE(	"Rune essence",	0,		1,		5.0,	false),
	COPPER(			"Copper", 		436, 	1, 		17.5,	false),
	TIN(			"Tin", 			438, 	1, 		17.5,	false),
	LIMESTONE(		"Limestone",	0,		10,		26.5,	true),	
	IRON(			"Iron", 		440, 	15,		35.0,	false),
	GOLD(			"Gold", 		444, 	40,		65.0,	false),
	SILVER(			"Silver", 		442, 	40,		40.0,	false),
	PURE_ESSENCE(	"Pure essence",	0,		30,		5.0,	true),
	MITHRIL(		"Mithril", 		447, 	55,		80.0,	false),
	ADAMANTITE(		"Adamantite", 	449, 	70,		95.0,	false),
	COAL(			"Coal", 		453, 	30,		50.0,	false),
	RUNITE(			"Runite", 		451, 	85,		125.0,	false);
	
	private String ore_name;
	private int ore_id;
	private int level;
	private double experience;
	private boolean members;
	
	Ores(String name, int id, int level, double experience, boolean members) {
		ore_name = name;
		ore_id = id;
		this.level = level;
		this.experience = experience;
		this.members = members;
	}
	
	public String getName() {
		return ore_name;
	}
	
	public int getID() {
		return ore_id;
	}

	public int getLevel() {
		return this.level;
	}
	
	public double getExperience() {
		return this.experience;
	}
	
	public boolean isMembers() {
		return this.isMembers();
	}
}
