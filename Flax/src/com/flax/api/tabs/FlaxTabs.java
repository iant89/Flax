package com.flax.api.tabs;

import java.awt.Point;
import java.awt.Rectangle;

import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.tabs.Tab;

import com.flax.api.Flax;
import com.flax.api.mouse.FlaxMouse;

public class FlaxTabs {
	
	public static boolean isDisabled(Tab tab) {
		return Flax.getContext().getTabs().isDisabled(tab);
	}
	
	public static boolean isOpen(Tab tab) {
		return Flax.getContext().getTabs().isOpen(tab);
	}
	
	public static Tab getOpen() {
		return Flax.getContext().getTabs().getOpen();
	}
	
	public static void openTab(Tab tab) {
		if(isOpen(tab)) {
			return;
		}

		Rectangle interface_rect = null;
		
		switch(tab) {
			case CLAN:
				interface_rect = new Rectangle(0, 0, 0, 0);
				break;
				
			case COMBAT:
				interface_rect = new Rectangle(0, 0, 0, 0);
				break;
				
			case EMOTES:
				interface_rect = new Rectangle(0, 0, 0, 0);
				break;
				
			case EQUIPMENT:
				interface_rect = new Rectangle(0, 0, 0, 0);
				break;
				
			case FRIENDS:
				interface_rect = new Rectangle(0, 0, 0, 0);
				break;
				
			case IGNORE:
				interface_rect = new Rectangle(0, 0, 0, 0);
				break;
				
			case INVENTORY:
				interface_rect = new Rectangle(0, 0, 0, 0);
				break;
				
			case LOGOUT:
				interface_rect = new Rectangle(0, 0, 0, 0);
				break;
				
			case MAGIC:
				interface_rect = new Rectangle(0, 0, 0, 0);
				break;
				
			case MUSIC:
				interface_rect = new Rectangle(0, 0, 0, 0);
				break;
				
			case OPTIONS:
				interface_rect = new Rectangle(0, 0, 0, 0);
				break;
				
			case PRAYER:
				interface_rect = new Rectangle(0, 0, 0, 0);
				break;
				
			case QUEST:
				interface_rect = new Rectangle(0, 0, 0, 0);
				break;
				
			case STATS:
				interface_rect = new Rectangle(0, 0, 0, 0);
				break;
		}
		
		if(interface_rect == null) {
			Flax.error("[FlaxTabs] Tab = " + tab.toString() + ", Could not get Interface Rectangle!");
			return;
		}
		
		Point mouse_point = new Point((int)Calculations.random(interface_rect.getX(), interface_rect.getX() + interface_rect.getWidth()), (int)Calculations.random(interface_rect.getY(), interface_rect.getY() + interface_rect.getHeight()));
		
		FlaxMouse.windMouse(mouse_point.x, mouse_point.y);
		MethodProvider.sleep(10, 50);
		FlaxMouse.clickMouse();
	}
}
