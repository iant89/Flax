/**
 * 
 */
package com.flax.api.event;

import com.flax.api.enums.Bars;

/**
 * @author Ian
 *
 */
public class SmeltingEvent extends GameEvent {

	private Bars event_bar;
	
	/**
	 * @param bar
	 */
	public SmeltingEvent(Bars bar) {
		super(GameEvent.EVENT_SMITHING_SMELT);
		
		event_bar = bar;
	}

	public Bars getBarType() {
		return event_bar;
	}
}
