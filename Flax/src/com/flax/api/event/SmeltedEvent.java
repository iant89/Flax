/**
 * 
 */
package com.flax.api.event;

import com.flax.api.enums.Bars;

/**
 * @author Ian
 *
 */
public class SmeltedEvent extends GameEvent {

	private Bars event_bar;
	
	/**
	 * @param bar
	 */
	public SmeltedEvent(Bars bar) {
		super(GameEvent.EVENT_SMELTED_BAR);
		
		event_bar = bar;
	}

	public Bars getBarType() {
		return event_bar;
	}
}
