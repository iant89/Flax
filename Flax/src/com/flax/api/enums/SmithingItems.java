/**
 * 
 */
package com.flax.api.enums;

/**
 * @author Ian
 *
 */
public enum SmithingItems {
	
	DAGGER("Dagger", 1),
	SWORD("Sword", 1),
	SCIMITAR("Scimitar", 2),
	LONG_SWORD("Long sword", 2),
	TWO_HAND_SWORD("2-hand sword", 3),
	
	AXE("Axe", 1),
	MACE("Mace", 1),
	WARHAMMER("Warhammer", 3),
	BATTLE_AXE("Battle axe", 3),
	
	CHAIN_BODY("Chain body", 3),
	PLATE_LEGS("Plate legs", 3),
	PLATE_SKIRT("Plate skirt", 3),
	PLATE_BODY("Plate body", 3),
	NAILS("Nails", 1),
	
	MEDIUM_HELM("Medium helm", 1),
	FULL_HELM("Full helm", 2),
	SQUARE_SHIELD("Square shield", 2),
	KITE_SHIELD("Kite sheild", 3),
	
	DART_TIPS("Dart tips", 1),
	ARROWTIPS("Arrowtips", 1),
	KNIVES("Knives", 1),
	STUDS("Studs", 1),
	BULLSEYE_LANTERN("Bullseye lantern", 1);
	
	private String item_name = "";
	private int bars_required = 0;
	
	SmithingItems(String item_name, int bars_required) {
		this.item_name = item_name;
		this.bars_required = bars_required;
	}
	
	/**
	 * Gets the Name of the Selected Item
	 * @return string
	 */
	public String getName() {
		return this.item_name;
	}
	
	/**
	 * Gets the Amount of Required Bars to smith the selected Item 
	 * @return int
	 */
	public int getBarsRequired() {
		return this.bars_required;
	}
}
