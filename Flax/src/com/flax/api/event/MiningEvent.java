/**
 * 
 */
package com.flax.api.event;

import com.flax.api.enums.Ores;

/**
 * @author Ian
 *
 */
public class MiningEvent extends GameEvent {

	private Ores ore_mined;
	
	public MiningEvent(Ores ore) {
		super(GameEvent.EVENT_MINING);
		
		ore_mined = ore;
	}
	
	public Ores getOreType() {
		return ore_mined;
	}

}
