/**
 * 
 */
package com.flax.api.script;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.wrappers.widgets.message.Message;

import com.flax.api.Flax;
import com.flax.api.context.ClientContext;


/**
 * @author Ian
 */
public abstract class AbstractFlaxScript extends AbstractScript {

	public abstract void start();
	public abstract void exit();
	public abstract int loop();
	public abstract void paint(Graphics g);
	public abstract void message(Message message);
	
	public AbstractFlaxScript() {
		Flax.setContext(ClientContext.createContext(this));
	}
	
	public AbstractFlaxScript(AbstractScript script) {
		Flax.setContext(ClientContext.createContext(script));
	}
	
	public void setScript(AbstractScript script) {
		Flax.setContext(ClientContext.createContext(script));
	}
	
	@Override
	public void onStart() {
		start();
	}
	
	@Override
	public void onExit() {
		exit();
	}
	
	@Override
	public void onPaint(Graphics g) {
		paint(g);
	}
	
	@Override
	public int onLoop() {
		
		// Automatically Close Level-Up Messages
		if (getDialogues().canContinue()) { 
			Flax.debug("Closing Level Up widget!");
            if(getDialogues().continueDialogue()) {
                sleepUntil(() -> !getDialogues().canContinue(), 3000);
            }
        }
		
		
		return loop();
	}

	@Override
	public void onMessage(Message message) {
		Flax.getGameEventManager().onMessage(message);
		
		message(message);
	}
	
	@Override
	public void onMouse(MouseEvent event) {
        Flax.getCanvasMouseManager().onMouse(event);
    }
}
