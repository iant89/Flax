package com.flax.api.enums;

import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.map.Tile;

public enum Furnaces {
	AL_KHARID(			"Al-Kharid",		new Tile(3263, 3195), new Tile(3286, 3155), 	24009),
	EAST_ARDOUGNE(		"East Ardougne",	new Tile(0, 0), 	  new Tile(0, 0),			0),		
    EDGEVILLE(			"Edgeville",		new Tile(3076, 3506), new Tile(3113, 3468), 	0),
    VARROCK_WEST_BANK(	"Varrock West",		new Tile(3202, 3419), new Tile(3174, 3451), 	0),
    FALADOR(			"Falador",			new Tile(2937, 3391), new Tile(2997, 3358), 	24009),
    PORT_PHATASMATYS(	"Port Phatasmatys", new Tile(3681, 3482), new Tile(3699, 3461), 	0);

	private String location;
	private Tile north_east;
	private Tile south_west;

	private int object_id;
	
	Furnaces(String location, Tile north_east, Tile south_west, int object_id) {
		this.location = location;
		this.north_east = north_east;
		this.south_west = south_west;
		this.object_id = object_id;
	}
	
	public String getLocationName() {
		return this.location;
	}
	
	public int getFurnaceID() {
		return this.object_id;
	}
	
	public Area contruct() {
		return new Area(north_east,south_west);
	}
}
