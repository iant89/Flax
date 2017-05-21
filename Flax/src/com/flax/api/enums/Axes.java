/**
 * 
 */
package com.flax.api.enums;

import org.dreambot.api.methods.skills.Skill;

import com.flax.api.Flax;

/**
 * @author Ian
 *
 */
public enum Axes {
	BRONZE(		"Bronze", 	1, 		434, 	false),
	IRON(		"Iron", 	1, 		436, 	false),
	STEEL(		"Steel", 	6, 		438, 	false),
	BLACK(		"Black", 	11, 	440, 	false),
	MITHRIL(	"Mithril", 	21, 	444, 	false),
	ADAMANT(	"Adamant", 	31, 	442, 	false),
	RUNE(		"Rune", 	41, 	453, 	false),
	DRAGON(		"Dragon", 	61, 	451, 	true);
	
	private String axe_name;
	private int level_required;
	private int item_id;
	private boolean members;
	
	Axes(String name, int level, int id, boolean members) {
		axe_name = name;
		level_required = level;
		item_id = id;
		this.members = members;
	}
	
	public String getName() {
		return axe_name;
	}
	
	public int getID() {
		return item_id;
	}
	
	public int getLevel() {
		return level_required;
	}
	
	public boolean isMembers() {
		return this.members;
	}
	
	public Axes getBestAxeByLevel() {
		int wc_level = Flax.getContext().getSkills().getRealLevel(Skill.WOODCUTTING);
		
		Axes previous_axe = null;
		for(Axes axe : Axes.values()) {
			if(wc_level < axe.getLevel()) {
				break;
			} else {
				previous_axe = axe;
			}
			
		}
		
		return previous_axe;
	}
	
	public boolean hasAxe() {
		for(Axes axe : Axes.values()) {
			
			// Check inventory for axe
			if(Flax.getContext().getInventory().get(axe.getID()).getAmount() > 0) {
				return true;
			}
			
			// Check Equipment for axe
			if(Flax.getContext().getEquipment().get(axe.getID()).getAmount() > 0) {
				return true;
			}
			
		}
		
		return false;
	}
}
