/**
 * 
 */
package com.flax.api.enums;

/**
 * @author Ian
 *
 */
public enum Trees {
	NORMAL(			"Normal", 		0, 	1, 		25.0, 	false),
	OAK(			"Oak", 			0, 	15, 	37.5, 	false),
	WILLOW(			"Willow", 		0, 	30, 	67.5, 	false),
	TEAK(			"Teak", 		0, 	35, 	85.0, 	true),
	MAPLE(			"Maple", 		0, 	45, 	100.0, 	true),
	MAHOGANY(		"Mahogany", 	0, 	50, 	125.0, 	true),
	ARCTIC_PINE(	"Arctic Pine", 	0, 	54, 	40.0, 	true),
	YEW(			"Yew", 			0, 	60, 	175.0, 	false),
	MAGIC(			"Magic", 		0, 	75, 	250.0, 	true);
	
	private String name;
	private double experience;
	private int log_id;
	private int level;
	private boolean members;
	
	Trees(String name, int id, int level, double experience, boolean members) {
		this.name = name;
		this.log_id = id;
		this.experience = experience;
		this.members = members;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getID() {
		return this.log_id;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public double getExperience() {
		return this.experience;
	}
	
	public boolean isMembers() {
		return this.members;
	}
}
