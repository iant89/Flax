package com.flax.api.event;

public class FailedSmeltingEvent extends GameEvent {

	/**
	 * When Smelting Iron Ore, you have a 50% Chance of Failing to Smelt it.
	 * This Event is fired, everytime you fail to smelt it.
	 */
	public FailedSmeltingEvent() {
		super(GameEvent.EVENT_SMITHING_REFINING_FAILED);
	}

}
