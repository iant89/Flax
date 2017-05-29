/**
 * 
 */
package com.flax.api.interfaces;

import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.widget.Widget;
import org.dreambot.api.wrappers.widgets.WidgetChild;

import com.flax.api.Flax;
import com.flax.api.enums.SmithingItems;

/**
 * @author Ian
 *
 */
public class SmithingInterface {
	
	/**
	 * Determines if the Smithing Widget is open
	 * @return boolean
	 */
	public static boolean isVisible() {
		Widget smithing_widget = getWidget(312);
		
		if(smithing_widget == null) {
			return false;
		}
		
		return smithing_widget.isVisible();
	}
	
	
	/**
	 * Finds the Item on the Smithing Widget, and automatically selects the correct amount.
	 * 
	 * @param item		The Selected Item to Smith
	 * @param amount	The Amount to make
	 */
	public static void smithItem(SmithingItems item, int amount) {
		if(!isVisible()) {
			return;
		}
		
		WidgetChild item_widget = findWidget(item.getName());
		
		if(item_widget == null) {
			Flax.error("[SmithingInterface] Failed to find interface for '" + item.getName() + "'");
			return;
		}
		
		// Interact with widget
		if(amount == 1) {
			// Smith 1
			Flax.debug("[SmithingInterface] Interacting -> 'Smith 1'");
			item_widget.interact("Smith 1");
		} else if(amount <= 5) {
			// Smith 5
			Flax.debug("[SmithingInterface] Interacting -> 'Smith 5'");
			item_widget.interact("Smith 5");	
		} else if(amount <= 10) {
			// Smith 10
			Flax.debug("[SmithingInterface] Interacting -> 'Smith 10'");
			item_widget.interact("Smith 10");
		} else {
			// Smith X
			Flax.debug("[SmithingInterface] Interacting -> 'Smith X'");
			item_widget.interact("Smith X");
			
			MethodProvider.sleep(Calculations.random(1000, 2400));
        	Flax.debug("[SmithingInterface] Typing Amount -> '" + amount + "'");
			Flax.getContext().getKeyboard().type(amount);
        	MethodProvider.sleep(Calculations.random(3000, 4000));
			return;
		}
		
		MethodProvider.sleep(Calculations.random(1000, 2400));
	}
	
	public static boolean interfaceHasItem(SmithingItems item) {
		return (findWidget(item.getName()) != null);
	}
	
	/**
	 * Finds the Child Widget
	 * @param name
	 * @return
	 */
	private static WidgetChild findWidget(String name) {
		for(int index = 2; index <= 27; index++) {
			if(getWidgetItemText(index).equals(name)) {
				return getWidget(312).getChild(index);
			}
		}
		
		return null;
	}
	
	/**
	 * Gets the Text of the Child Widget
	 * @param child
	 * @return
	 */
	private static String getWidgetItemText(int child) {
		return getWidget(312).getChild(child).getChild(0).getText();
		
	}
	
	/**
	 * Gets the Widget
	 * @param id
	 * @return
	 */
	private static Widget getWidget(int id) {
		return Flax.getContext().getWidgets().getWidget(id);
	}	
}
