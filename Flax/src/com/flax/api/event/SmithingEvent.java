package com.flax.api.event;

import com.flax.api.enums.Bars;

public class SmithingEvent extends GameEvent {

	private Bars smelted_bar = null;
	
	public SmithingEvent(Bars bar) {
		super(GameEvent.EVENT_SMITHING_SMELT);
		smelted_bar = bar;
	}
	
	public SmithingEvent(boolean failed_bar) {
		super(GameEvent.EVENT_SMITHING_REFINING_FAILED);
	}
	
	public Bars getBarType() {
		return smelted_bar;
	}
}
