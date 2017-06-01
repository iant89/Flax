/**
 * 
 */
package com.flax.api.enums;

/**
 * @author Ian
 *
 */
public enum Pickaxes {
	BRONZE(		"Bronze pickaxe", 	1, 		434, 	false),
	IRON(		"Iron pickaxe",		1, 		436, 	false),
	STEEL(		"Steel pickaxe", 	6, 		438, 	false),
	BLACK(		"Black pickaxe", 	11, 	440, 	false),
	MITHRIL(	"Mithril pickaxe",	21, 	444, 	false),
	ADAMANT(	"Adamant pickaxe",	31, 	442, 	false),
	RUNE(		"Rune pickaxe",	 	41, 	453, 	false),
	DRAGON(		"Dragon pickaxe", 	61, 	451, 	true);
	
	private String pick_name;
	private int level_required;
	private int item_id;
	private boolean members;
	
	Pickaxes(String name, int level, int id, boolean members) {
		pick_name = name;
		level_required = level;
		item_id = id;
		this.members = members;
	}
	
	public String getName() {
		return pick_name;
	}
	
	public int getID() {
		return item_id;
	}
	
	public int getLevelRequired() {
		return level_required;
	}
	
	public boolean isMembers() {
		return this.members;
	}
}
