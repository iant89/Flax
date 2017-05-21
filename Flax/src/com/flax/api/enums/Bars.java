/**
 * 
 */
package com.flax.api.enums;

/**
 * @author Ian
 *
 */
public enum Bars {
	BRONZE(		"Bronze", 		2349,	1,	6.25,	new Ores[]{Ores.TIN, Ores.COPPER}),
	IRON(		"Iron", 		2351,	15,	12.5,	new Ores[]{Ores.IRON}),
	SILVER(		"Silver", 		2355,	20,	13.67,	new Ores[]{Ores.SILVER}),
	STEEL(		"Steel", 		2353,	30,	17.5,	new Ores[]{Ores.IRON, Ores.COAL, Ores.COAL}),
	GOLD(		"Gold", 		2357,	40,	22.5,	new Ores[]{Ores.GOLD}),
	MITHRIL(	"Mithril", 		2359,	50,	30.0,	new Ores[]{Ores.MITHRIL, Ores.COAL, Ores.COAL, Ores.COAL, Ores.COAL}),
	ADAMANTITE(	"Adamantite", 	2361,	70,	37.5,	new Ores[]{Ores.ADAMANTITE, Ores.COAL, Ores.COAL, Ores.COAL, Ores.COAL, Ores.COAL, Ores.COAL}),
	RUNE(		"Rune", 		2363,	85,	50.0, 	new Ores[]{Ores.RUNITE, Ores.COAL, Ores.COAL, Ores.COAL, Ores.COAL, Ores.COAL, Ores.COAL, Ores.COAL, Ores.COAL});
	
	private String bar_name;
	private int bar_id;
	private int level;
	private double experience;
	private Ores[] required_ores;
	
	Bars(String name, int id, int level, double experience, Ores[] required_ores) {
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
	
	public Ores[] getRequiredOres() {
		return this.required_ores;
	}
}
