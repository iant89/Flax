/**
 * 
 */
package com.flax.api.event.listeners;

import java.awt.event.MouseEvent;

import com.flax.api.event.LevelEvent;

/**
 * @author Ian
 *
 */
public interface CanvasMouseListener {
	public abstract void onCanvasMouse(MouseEvent event);
}
