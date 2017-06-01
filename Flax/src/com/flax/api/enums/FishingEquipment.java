/**
 * 
 */
package com.flax.api.enums;

/**
 * @author Ian
 *
 */
public enum FishingEquipment {
	FISHING_ROD(		"Fishing rod", 			1, 		0, 		-1, 	false),
	SMALL_FISHING_NET(	"Small fishing net", 	1, 		0, 		-1, 	false),
	BIG_FISHING_NET(	"Big fishing net", 		6, 		0, 		-1, 	true),
	FLY_FISHING_ROD(	"Fly fishing rod", 		11, 	0, 		-1,		false),
	HARPOON(			"Harpoon", 				21, 	0, 		-1, 	false),
	LOBSTER_POT(		"Lobster pot", 			31, 	0, 		-1, 	false);

	
	private String tool_name;
	private int level_required;
	private int item_id;
	private int animation;
	private boolean members;
	
	FishingEquipment(String name, int level, int id, int animation_id, boolean members) {
		tool_name = name;
		level_required = level;
		item_id = id;
		this.animation = animation_id;
		this.members = members;
	}
	
	public String getName() {
		return tool_name;
	}
	
	public int getID() {
		return item_id;
	}
	
	public int getLevelRequired() {
		return level_required;
	}
	
	public int getAnimation() {
		return this.animation;
	}
	
	public boolean isMembers() {
		return this.members;
	}
}
