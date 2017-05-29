/**
 * 
 */
package com.flax.api.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ian
 *
 */
public enum Bars {
	BRONZE(		"Bronze", 		2349,	1,	6.25,	new Ore[]{Ore.TIN, Ore.COPPER}),
	IRON(		"Iron", 		2351,	15,	12.5,	new Ore[]{Ore.IRON}),
	SILVER(		"Silver", 		2355,	20,	13.67,	new Ore[]{Ore.SILVER}),
	STEEL(		"Steel", 		2353,	30,	17.5,	new Ore[]{Ore.IRON, Ore.COAL, Ore.COAL}),
	GOLD(		"Gold", 		2357,	40,	22.5,	new Ore[]{Ore.GOLD}),
	MITHRIL(	"Mithril", 		2359,	50,	30.0,	new Ore[]{Ore.MITHRIL, Ore.COAL, Ore.COAL, Ore.COAL, Ore.COAL}),
	ADAMANTITE(	"Adamantite", 	2361,	70,	37.5,	new Ore[]{Ore.ADAMANTITE, Ore.COAL, Ore.COAL, Ore.COAL, Ore.COAL, Ore.COAL, Ore.COAL}),
	RUNE(		"Rune", 		2363,	85,	50.0, 	null);
	
	private String bar_name;
	private int bar_id;
	private int level;
	private double experience;
	private Ore[] required_ores;
	
	<MapEntry> Bars(String name, int id, int level, double experience, Ore[] required_ores) {
		bar_name = name;
		bar_id = id;
		this.level = level;
		this.experience = experience;
		this.required_ores = required_ores;
	}
	
	public String getName() {
		return bar_name;
	}
	
	public int getID() {
		return bar_id;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public double getExperience() {
		return this.experience;
	}
	
	public Ore[] getRequiredOres() {
		return this.required_ores;
	}
}
