/**
 * 
 */
package com.flax.api.enums;

import org.dreambot.api.methods.map.Tile;

/**
 * @author Ian
 *
 */
public enum Ore {
	CLAY(			"Clay", 			434, 	1, 		5.0,	false, 		new int[] { }),
	RUNE_ESSENCE(	"Rune essence",		0,		1,		5.0,	false, 		new int[] { }),
	COPPER(			"Copper ore", 		436, 	1, 		17.5,	false, 		new int[] { }),
	TIN(			"Tin ore", 			438, 	1, 		17.5,	false, 		new int[] { }),
	IRON(			"Iron ore", 		440, 	15,		35.0,	false, 		new int[] { }),
	GOLD(			"Gold ore", 		444, 	40,		65.0,	false, 		new int[] { }),
	SILVER(			"Silver ore", 		442, 	40,		40.0,	false, 		new int[] { }),
	PURE_ESSENCE(	"Pure essence",		0,		30,		5.0,	true, 		new int[] { }),
	MITHRIL(		"Mithril ore", 		447, 	55,		80.0,	false, 		new int[] { }),
	ADAMANTITE(		"Adamantite ore", 	449, 	70,		95.0,	false, 		new int[] { }),
	COAL(			"Coal", 			453, 	30,		50.0,	false, 		new int[] { }),
	RUNITE(			"Runite ore", 		451, 	85,		125.0,	false, 		new int[] { });
	
	private String 	ore_name;
	private int 	ore_id;
	private int 	ore_level;
	private double 	ore_experience;
	private boolean ore_members;
	private int[] 	ore_rock_ids;
	
	Ore(String name, int id, int level, double experience, boolean members, int[] rocks) {
		this.ore_name = name;
		this.ore_id = id;
		this.ore_level = level;
		this.ore_experience = experience;
		this.ore_members = members;
		this.ore_rock_ids = rocks;
	}
	
	public String getName() {
		return this.ore_name;
	}
	
	public int getID() {
		return this.ore_id;
	}

	public int getLevel() {
		return this.ore_level;
	}
	
	public double getExperience() {
		return this.ore_experience;
	}
	
	public boolean isMembers() {
		return this.isMembers();
	}
	
	public int[] getRockIDS() {
		return this.ore_rock_ids;
	}
}
