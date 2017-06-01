/**
 * 
 */
package com.flax.api.enums;

import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ian
 *
 */
public enum Bar {
	BRONZE(		"Bronze bar",		2349,	1,	6.25),
	IRON(		"Iron bar", 		2351,	15,	12.5),
	SILVER(		"Silver bar",		2355,	20,	13.67),
	STEEL(		"Steel bar",		2353,	30,	17.5),
	GOLD(		"Gold bar",			2357,	40,	22.5),
	MITHRIL(	"Mithril bar", 		2359,	50,	30.0),
	ADAMANTITE(	"Adamantite bar", 	2361,	70,	37.5),
	RUNITE(		"Runite bar", 		2363,	85,	50.0);
	
	private String bar_name;
	private int bar_id;
	private int level;
	private double experience;
	
	private static final Map<Bar, Map<Ore, Integer>> ORE_RECIPES = Collections.unmodifiableMap(initOres());
	
	
	Bar(String name, int id, int level, double experience) {
		bar_name = name;
		bar_id = id;
		this.level = level;
		this.experience = experience;
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
	
	public Map<Ore, Integer> getOres() {
		return ORE_RECIPES.get(this);
	}
	
	private static Map<Bar, Map<Ore, Integer>> initOres() {
		Map<Bar, Map<Ore, Integer>> map = new EnumMap<>(Bar.class);
		for (Bar bar : values()) {
			Map<Ore, Integer> ores = new EnumMap<>(Ore.class);
			switch (bar) {
			case BRONZE:
				ores.put(Ore.COPPER, 1);
				ores.put(Ore.TIN, 1);
				break;
			case IRON:
				ores.put(Ore.IRON, 1);
				break;
			case SILVER:
				ores.put(Ore.SILVER, 1);
				break;
			case STEEL:
				ores.put(Ore.IRON, 1);
				ores.put(Ore.COAL, 2);
				break;
			case GOLD:
				ores.put(Ore.GOLD, 1);
				break;
			case MITHRIL:
				ores.put(Ore.MITHRIL, 1);
				ores.put(Ore.COAL, 4);
				break;
			case ADAMANTITE:
				ores.put(Ore.ADAMANTITE, 1);
				ores.put(Ore.COAL, 6);
				break;
			case RUNITE:
				ores.put(Ore.RUNITE, 1);
				ores.put(Ore.COAL, 8);
				break;
			}
			map.put(bar, ores);
		}
		
		return map;
	}
}
