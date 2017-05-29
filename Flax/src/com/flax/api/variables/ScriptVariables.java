/**
 * 
 */
package com.flax.api.variables;

import java.util.HashMap;

import com.flax.api.Flax;

/**
 * @author Ian
 *
 */
public class ScriptVariables {
	private HashMap<String, Object> variables = null;
	
	public ScriptVariables() {
		variables = new HashMap<String, Object>();
	}
	
	public void putVariable(String key, Object value) {
		
		// Check if Variable Exists
		if(variables.containsKey(key)) {
			return;
		}
		
		variables.put(key, value);
	}
	
	public int getInteger(String key) {
		if(containsVariable(key)) {
			return (int)variables.get(key);
		}
		
		return 0;
	}
	
	public double getDouble(String key) {
		if(containsVariable(key)) {
			return (double)variables.get(key);
		}
		
		return 0.0;
	}
	
	public float getFloat(String key) {
		if(containsVariable(key)) {
			return (float)variables.get(key);
		}
		
		return 0f;
	}
	
	public boolean getBoolean(String key) {
		if(containsVariable(key)) {
			return (boolean)variables.get(key);
		}
		
		return false;
	}
	
	public String getString(String key) {
		if(containsVariable(key)) {
			return (String)variables.get(key);
		}
		
		return null;
	}
	
	
	
	public boolean containsVariable(String key) {
		return variables.containsKey(key);
	}
}
