package com.flax.api.event;

import com.flax.api.enums.Bar;

public class SmithingEvent extends GameEvent {

	private Bar smelted_bar = null;
	
	public SmithingEvent(Bar bar) {
		super(GameEvent.EVENT_SMITHING_SMELT);
		smelted_bar = bar;
	}
	
	public SmithingEvent(boolean failed_bar) {
		super(GameEvent.EVENT_SMITHING_REFINING_FAILED);
	}
	
	public Bar getBarType() {
		return smelted_bar;
	}
}
