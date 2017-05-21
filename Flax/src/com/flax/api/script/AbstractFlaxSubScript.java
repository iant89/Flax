/**
 * 
 */
package com.flax.api.script;

import java.awt.Graphics;

import org.dreambot.api.wrappers.widgets.message.Message;

import com.flax.api.Flax;
import com.flax.api.context.ClientContext;

/**
 * @author Ian
 *
 */
public abstract class AbstractFlaxSubScript {
			
	public ClientContext getContext() {
		return Flax.getContext();
	}
	
	public abstract void start();
	public abstract void exit();
	public abstract int loop();
	public abstract void paint(Graphics g);
	public abstract void message(Message message);
}
