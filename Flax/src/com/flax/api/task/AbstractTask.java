/**
 * 
 */
package com.flax.api.task;

import com.flax.api.Flax;
import com.flax.api.context.ClientContext;

/**
 * @author Ian
 *
 */
public abstract class AbstractTask {
		
	public abstract boolean activate();
	public abstract void execute();
	
	private ClientContext getContext() {
		return Flax.getContext();
	}
}
