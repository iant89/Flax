/**
 * 
 */
package com.flax.api.event;

import com.flax.api.enums.Fish;

/**
 * @author Ian
 *
 */
public class FishCaughtEvent extends GameEvent {

	private Fish fish_caught = null;
	
	
	/**
	 * @param type
	 */
	public FishCaughtEvent(Fish fish_type) {
		super(GameEvent.EVENT_FISH_CAUGHT);
		
		fish_caught = fish_type;
	}

	public Fish getCaughtFish() {
		return fish_caught;
	}
}
