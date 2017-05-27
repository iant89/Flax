package com.flax.api.event;

import org.dreambot.api.methods.map.Tile;

public class DeathEvent extends GameEvent {

	private Tile death_tile = null;
	
	public DeathEvent(Tile player_position) {
		super(GameEvent.EVENT_DEATH);
		
		death_tile = player_position;
	}
	
	public Tile getDeathTile() {
		return death_tile;
	}

}
