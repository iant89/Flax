/**
 * 
 */
package com.flax.api.enums;

/**
 * @author Ian
 *
 */
public enum Fish {
				// Name		  RAW_ID,COOKED_ID,FISH_XP,COOK_XP,FISH_LEVEL,COOK_LEVEL,TOOL,MEMBERS 
	SHRIMP(		"Shrimp",		317,	315,	10.0,	30.0,	1,		1,		FishingEquipment.SMALL_FISHING_NET,		false,		"Net"),
	SARDINE(	"Sardine", 		327,	325,	20.0, 	40.0, 	5, 		1,		FishingEquipment.FISHING_ROD, 			false,		"Bait"),
	HERRING(	"Herring", 		345,	347,	30.0, 	50.0, 	10,		5,	 	FishingEquipment.FISHING_ROD, 			false,		"Bait"),
	ANCHOVIES(	"Anchovies", 	321,	319,	40.0, 	30.0, 	15, 	1,		FishingEquipment.SMALL_FISHING_NET, 		false,		"Net"),
	MACKEREL(   "Mackerel",		353,	355,	20.0,	60.0,	16,		10,		FishingEquipment.BIG_FISHING_NET,		true,		"Net"),	
	TROUT(		"Trout", 		335,	333,	50.0, 	70.0, 	20,		15, 	FishingEquipment.FLY_FISHING_ROD, 		false,		"Lure"),
	COD( 		"Cod",			341,	339,	45.0,	75.0,	23,		18,		FishingEquipment.BIG_FISHING_NET,		true,		"Net"),	
	PIKE(		"Pike",	 		349,	351,	60.0, 	80.0, 	25, 	20,		FishingEquipment.FISHING_ROD, 			false,		"Bait"),
	SALMON(		"Salmon", 		331,	329,	70.0, 	90.0, 	30,		25, 	FishingEquipment.FLY_FISHING_ROD, 		false,		"Lure"),
	TUNA(		"Tuna", 		359,	361,	80.0, 	100.0, 	35, 	30,		FishingEquipment.HARPOON, 				false,		"Harpoon"),
	LOBSTER(	"Lobster", 		377,	379,	90.0, 	120.0, 	40,		40,		FishingEquipment.LOBSTER_POT, 			false,		"Cage"),
	BASS(		"Bass",			363,	365,	100.0,	130.0,	46,		43,		FishingEquipment.BIG_FISHING_NET,		true,		"Net"),
	SWORDFISH(	"Swordfish", 	371,	373,	100.0, 	140.0, 	50, 	45,		FishingEquipment.HARPOON, 				false,		"Harpoon"),
	MONKFISH( 	"Monkfish",		7944,	7946,	120.0,	150.0,	62,		62,		FishingEquipment.SMALL_FISHING_NET,		true,		"Net"),
	SHARK(		"Shark",		0,		0,		110.0,	210.0,	76,		80,		FishingEquipment.HARPOON,				true,		"Harpoon");
	
	private String 		fish_name;
	private int			raw_id;
	private int			cooked_id;
	private double		fishing_exp;
	private double		cooking_exp;
	private int			fishing_level;
	private int			cooking_level;
	private FishingEquipment	equipment;
	private boolean		members;
	private String		action_text;
	
	Fish(String name, int raw_id, int cooked_id, double fishing_exp, double cooking_exp, int fishing_level, int cooking_level, FishingEquipment tool, boolean members, String action) {
		this.fish_name = name;
		this.raw_id = raw_id;
		this.cooked_id = cooked_id;
		this.fishing_exp = fishing_exp;
		this.cooking_exp = cooking_exp;
		this.fishing_level = fishing_level;
		this.cooking_level = cooking_level;
		this.equipment = tool;
		this.members = members;
		this.action_text = action;
	}
	
	public String getName() {
		return this.fish_name;
	}
	
	public int getRawID() {
		return this.raw_id;
	}
	
	public int getCookedID() {
		return this.cooked_id;
	}
	
	public int getCookingLevel() {
		return this.cooking_level;
	}
	
	public int getFishingLevel() {
		return this.fishing_level;
	}
	
	public double getCookingExperience() {
		return this.cooking_exp;
	}
	
	public double getFishingExperience() {
		return this.fishing_exp;
	}
	
	public String getRawName() {
		return "Raw " + this.name().toLowerCase();
	}
	
	public FishingEquipment getEquipment() {
		return this.equipment;
	}
	
	public boolean isMembers() {
		return this.members;
	}
	
	public String getActionText() {
		return this.action_text;
	}
}
