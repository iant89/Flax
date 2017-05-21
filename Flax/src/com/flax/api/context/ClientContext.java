/**
 * 
 */
package com.flax.api.context;

import org.dreambot.api.Client;
import org.dreambot.api.input.Mouse;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.methods.container.impl.equipment.Equipment;
import org.dreambot.api.methods.input.Camera;
import org.dreambot.api.methods.input.Keyboard;
import org.dreambot.api.methods.interactive.GameObjects;
import org.dreambot.api.methods.skills.Skills;
import org.dreambot.api.methods.tabs.Tabs;
import org.dreambot.api.methods.walking.impl.Walking;
import org.dreambot.api.methods.widget.Widgets;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.wrappers.interactive.Player;


/**
 * @author Ian
 *
 */
public class ClientContext {

	private static AbstractScript script_context = null;
	
	public static ClientContext createContext(AbstractScript script) {
		return new ClientContext(script);
	}
	
	public ClientContext(AbstractScript script) {
		script_context = script;
	}
	
	public boolean isCreated() {
		return (script_context != null);
	}
	
	public Inventory getInventory() {
		return script_context.getInventory();
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
	
	public Tabs getTabs() {
		return script_context.getTabs();
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
}
