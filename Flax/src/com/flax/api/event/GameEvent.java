/**
 * 
 */
package com.flax.api.event;

/**
 * @author Ian
 *
 */
public class GameEvent {
	public static final int EVENT_NULL = 0;
	public static final int EVENT_LEVEL_UP = 1;
	public static final int EVENT_SMELTED_BAR = 2;
	public static final int EVENT_MINED_ORE = 3;
	public static final int EVENT_DEATH = 4;
	public static final int EVENT_FAILED_REFINING = 5;
	public static final int EVENT_FISH_CAUGHT = 6;
		
	private int event_type = EVENT_NULL;
	
	public GameEvent(int type) {
		event_type = type;
	}
	
	public int getEventType() {
		return this.event_type;
	}
	
}
