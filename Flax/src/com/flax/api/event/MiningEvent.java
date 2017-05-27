/**
 * 
 */
package com.flax.api.event;

import com.flax.api.enums.Ores;

/**
 * @author Ian
 *
 */
public class MinedEvent extends GameEvent {

	private Ores ore_mined;
	
	public MinedEvent(Ores ore) {
		super(GameEvent.EVENT_MINED_ORE);
		
		ore_mined = ore;
	}
	
	public Ores getOreType() {
		return ore_mined;
	}

}
