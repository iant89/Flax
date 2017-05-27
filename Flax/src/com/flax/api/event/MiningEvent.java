/**
 * 
 */
package com.flax.api.event;

import com.flax.api.enums.Ore;

/**
 * @author Ian
 *
 */
public class MiningEvent extends GameEvent {

	private Ore ore_mined;
	
	public MiningEvent(Ore ore) {
		super(GameEvent.EVENT_MINING);
		
		ore_mined = ore;
	}
	
	public Ore getOreType() {
		return ore_mined;
	}

}
