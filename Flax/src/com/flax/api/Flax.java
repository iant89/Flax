/**
 * 
 */
package com.flax.api;

import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.script.AbstractScript;

import com.flax.api.context.ClientContext;
import com.flax.api.event.managers.CanvasMouseManager;
import com.flax.api.event.managers.GameEventManager;


/**
 * @author Ian
 *
 */
public class Flax {
	public static final boolean 			FLAX_DEBUG 				= true;
	public static final double				FLAX_VERSION			= 0.2;
	public static final boolean				STATISTICS_ENABLED		= true;
	
	private static GameEventManager			game_event_manager 		= null;
	private static CanvasMouseManager		canvas_mouse_manager	= null;
	
	public static ClientContext getContext() {
		return ClientContext.getInstance();
	}
	
	public static GameEventManager getGameEventManager() {
		if(game_event_manager == null) {
			game_event_manager = new GameEventManager();
		}
		return game_event_manager;
	}
	
	public static CanvasMouseManager getCanvasMouseManager() {
		if(canvas_mouse_manager == null) {
			canvas_mouse_manager = new CanvasMouseManager();
		}
		
		return canvas_mouse_manager;
	}
	
	public static void log(String message) {
		if(message.length() > 0) {
			if(!message.substring(0, 1).equals("[")) {
				message = " " + message;
			}
		}
		
		MethodProvider.log("[FLAX]" + message);
	}
	
	public static void debug(String message) {
		if(!FLAX_DEBUG) {
			return;
		}
		
		log("[DEBUG] " + message);
	}


	public static void error(String message) {
		if(message.length() > 0) {
			if(!message.substring(0, 1).equals("[")) {
				message = " " + message;
			}
		}
		
		MethodProvider.log("[ERROR]" + message);
	}
}
