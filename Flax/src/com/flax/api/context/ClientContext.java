/**
 * 
 */
package com.flax.api.context;

import org.dreambot.api.Client;
import org.dreambot.api.input.Mouse;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.methods.container.impl.equipment.Equipment;
import org.dreambot.api.methods.grandexchange.GrandExchange;
import org.dreambot.api.methods.input.Camera;
import org.dreambot.api.methods.input.Keyboard;
import org.dreambot.api.methods.interactive.GameObjects;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.item.GroundItems;
import org.dreambot.api.methods.skills.Skills;
import org.dreambot.api.methods.tabs.Tabs;
import org.dreambot.api.methods.walking.impl.Walking;
import org.dreambot.api.methods.widget.Widgets;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.wrappers.interactive.Player;
import org.dreambot.api.wrappers.items.GroundItem;

import com.flax.api.tabs.FlaxTabs;


/**
 * @author Ian
 *
 */
public class ClientContext {
	private static ClientContext _instance = null;
	private static AbstractScript script_context = null;
	
	public ClientContext(AbstractScript script) {
		if(_instance != null) {
			return;
		}
		
		_instance = this;
		script_context = script;
	}
	
	public static ClientContext getInstance() {
		return _instance;
	}
 	
	public boolean isCreated() {
		return (script_context != null);
	}
	
	public GroundItems getGroundItems() {
		return script_context.getGroundItems();
	}
	
	public Inventory getInventory() {
		return script_context.getInventory();
	}
	
	public GrandExchange getGrandExchange() {
		return script_context.getGrandExchange();
	}
	
	public Players getPlayers() {
		return script_context.getPlayers();
	}
	
	public Bank getBank() {
		return script_context.getBank();
	}
	
	public Walking getWalking() {
		return script_context.getWalking();
	}
	
	public Camera getCamera() {
		return script_context.getCamera();
	}
	
	public Skills getSkills() {
		return script_context.getSkills();
	}
	
	public Client getClient() {
		return script_context.getClient();
	}
	
	public Mouse getMouse() {
		return script_context.getMouse();
	}
	
	public Equipment getEquipment() {
		return script_context.getEquipment();
	}
	
	public Player getLocalPlayer() {
		return script_context.getLocalPlayer();
	}
	
	public Widgets getWidgets() {
		return script_context.getWidgets();
	}
	
	public GameObjects getGameObjects() {
		return script_context.getGameObjects();
	}
	
	public Keyboard getKeyboard() {
		return script_context.getKeyboard();
	}
	
	/*
	 * OVERRIDDEN CONTEXT METHODS
	 */
	public FlaxTabs getTabs() {
		return FlaxTabs.getInstance();
	}
	
}
