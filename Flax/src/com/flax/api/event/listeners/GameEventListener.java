/**
 * 
 */
package com.flax.api.event.listeners;

import com.flax.api.event.GameEvent;
import com.flax.api.event.LevelEvent;

/**
 * @author Ian
 *
 */
public interface GameEventListener {
	
	public abstract void onGameEvent(GameEvent event);
}
