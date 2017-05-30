/**
 * 
 */
package com.flax.api.event.managers;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import com.flax.api.event.listeners.CanvasMouseListener;

/**
 * @author Ian
 *
 */
public class CanvasMouseManager {
	private final List<CanvasMouseListener> listeners;
    
	public CanvasMouseManager() {
		this.listeners = new ArrayList<CanvasMouseListener>();
    }
	
	public void addCanvasMouseListener(CanvasMouseListener e) {
        listeners.add(e);
    }

    public void removeCanvasMouseListener(CanvasMouseListener e) {
        listeners.remove(e);
    }

    private void fireChangeEvent(MouseEvent event) {
        for (CanvasMouseListener listener : listeners) {
            final CanvasMouseListener l = (CanvasMouseListener) listener;
            l.onCanvasMouse(event);
        }
    }
    
    public void onMouse(MouseEvent event) {
    	fireChangeEvent(event);
    }
}
