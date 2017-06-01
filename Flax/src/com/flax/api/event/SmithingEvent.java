package com.flax.api.event;

import com.flax.api.enums.Bar;
import com.flax.api.enums.SmithingItems;

public class SmithingEvent extends GameEvent {

	private Bar smelted_bar = null;
	private SmithingItems smithed_item = null;
	
	public SmithingEvent(Bar bar) {
		super(GameEvent.EVENT_SMITHING_SMELT);
		smelted_bar = bar;
	}
	
	public SmithingEvent(SmithingItems item) {
		super(GameEvent.EVENT_SMITHING);
		smithed_item = item;
	}
	
	public SmithingEvent(boolean failed_bar) {
		super(GameEvent.EVENT_SMITHING_REFINING_FAILED);
	}
	
	public Bar getBarType() {
		return smelted_bar;
	}
	
	public SmithingItems getItem() {
		return smithed_item;
	}
}
