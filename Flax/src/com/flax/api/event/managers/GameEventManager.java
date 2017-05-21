/**
 * 
 */
package com.flax.api.event.managers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.wrappers.widgets.message.Message;

import com.flax.api.Flax;
import com.flax.api.enums.Bars;
import com.flax.api.enums.Ores;
import com.flax.api.event.GameEvent;
import com.flax.api.event.LevelEvent;
import com.flax.api.event.MinedEvent;
import com.flax.api.event.SmeltedEvent;
import com.flax.api.event.listeners.GameEventListener;


/**
 * @author Ian
 *
 */
public class GameEventManager {
	private final List<GameEventListener> listeners;
    private Map<Skill, Integer> cache = null;
    
	public GameEventManager() {
		this.listeners = new ArrayList<GameEventListener>();
		cache = updateCache();
    }
	
	public void addGameEventListener(GameEventListener e) {
        listeners.add(e);
    }

    public void removeGameEventListener(GameEventListener e) {
        listeners.remove(e);
    }

    private void fireGameEvent(GameEvent event) {
        for (GameEventListener listener : listeners)
        {
            final GameEventListener l = (GameEventListener) listener;
            l.onGameEvent(event);
        }
    }
    
    private Map<Skill, Integer> updateCache()
    {
        if(Flax.getContext() == null) {
        	Flax.error("Context is NULL");
        	return null;
        }
        if(Flax.getContext().getSkills() == null) {
        	Flax.error("Context.Skills is NULL");
        	return null;
        }
        
    	final Map<Skill, Integer> cache = new HashMap<>();
        for (Skill skill : Skill.values())
        {
            cache.put(skill, Flax.getContext().getSkills().getRealLevel(skill));
        }
        return cache;
    }
    
    public void onMessage(Message message) {
    	// Level Up
        if(message.getMessage().startsWith("Congratulations, you just advanced")) {
            final Skill skill = Skill.valueOf(message.getMessage().split(" level.")[0].split(" ")[5].toUpperCase());
            
            final int level = Flax.getContext().getSkills().getRealLevel(skill);
            final int cachedLevel = cache.get(skill);
            
            // Check Against the Cache, I know this will return true, but just incase.........
            if(level != cachedLevel) {
                fireGameEvent(new LevelEvent(skill, cachedLevel, level));
                cache = updateCache();
            }
            return;
        }
        
        // Smelted Bar
        if(message.getMessage().startsWith("You retrieve a bar of")) {
        	String smelting_message = message.getMessage();
        	
        	Bars bar = null;
        	if(smelting_message.contains("bronze")) {
        		bar = Bars.BRONZE;
        	} else if(smelting_message.contains("iron")) {
        		bar = Bars.IRON;
        	}
        	

        	fireGameEvent(new SmeltedEvent(bar));
        	
        	return;
        }
        
        // Mined Ore
        if(message.getMessage().startsWith("You manage to mine some ")) {
        	String mining_message = message.getMessage();
        	
        	mining_message = mining_message.substring(mining_message.indexOf("some ")+5);
        	mining_message = mining_message.substring(0, mining_message.length()-1);
        	
        	Ores ore = null;
        	
        	if(mining_message.contains("copper")) {
        		ore = Ores.COPPER;
        	} else if(mining_message.contains("tin")) {
        		ore = Ores.TIN;
        	}
        	
        	fireGameEvent(new MinedEvent(ore));
        	return;
        }
    }
}
