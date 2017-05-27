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
import com.flax.api.enums.Fish;
import com.flax.api.enums.Ores;
import com.flax.api.event.FiremakingEvent;
import com.flax.api.event.FailedSmeltingEvent;
import com.flax.api.event.FishingEvent;
import com.flax.api.event.GameEvent;
import com.flax.api.event.LevelEvent;
import com.flax.api.event.MiningEvent;
import com.flax.api.event.SmeltingEvent;
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
        	
        	for(Bars bar : Bars.values()) {
        		if(message.getMessage().contains(bar.getName().toLowerCase())) {
                	fireGameEvent(new SmeltingEvent(bar));
                	return;
        		}
        	}
        	
        	return;
        }

        // When Smelting Iron, you have 50% Chance of it being to impure...
        if(message.getMessage().contains("too impure and you fail to refine it.")) {
        	fireGameEvent(new FailedSmeltingEvent());
        }
        
        // Mined Ore
        if(message.getMessage().contains("You manage to mine some ")) {
       	     	
        	for(Ores ore : Ores.values()) {
        		if(message.getMessage().contains(ore.getName().toLowerCase())) {
        			fireGameEvent(new MiningEvent(ore));
                	return;		
        		}
        	}
        	
        	return;
        }
        
        // Fish Catch Event
        if(message.getMessage().contains("You catch a ")) {
   
        	for(Fish fish : Fish.values()) {
        		if(message.getMessage().contains(fish.getName().toLowerCase())) {
        			fireGameEvent(new FishingEvent(fish));
        			return;
        		}
        	}
        	
        	return;
        }
        
        // Cook Food Event
        if(message.getMessage().contains("You successfully cook a ")) {
        	
        	return;
        }
        
        // Burn Food Event
        if(message.getMessage().contains("You accidentally burn the ")) {
        	
        	return;
        }
        
        // Get Log Event
        // "You get some logs."
        if(message.getMessage().contains("You get some ")) {
        	
        	return;
        }
        
        // Start Fire Event
        // "The fire catches and the logs begin to burn
        if(message.getMessage().contains("The fire catches and the ")) {
        	fireGameEvent(new FiremakingEvent());
        	return;
        }
        
    }
}
