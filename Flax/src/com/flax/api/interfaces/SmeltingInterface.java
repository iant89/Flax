/**
 * 
 */
package com.flax.api.interfaces;

import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.widget.Widget;
import org.dreambot.api.wrappers.widgets.WidgetChild;

import com.flax.api.Flax;
import com.flax.api.enums.Bars;
import com.flax.api.enums.SmithingItems;
import com.flax.api.methods.FlaxInventory;

/**
 * @author Ian
 *
 */
public class SmeltingInterface {
	/**
	 * Determines if the Smelting Widget is open
	 * @return boolean
	 */
	public static boolean isVisible() {
		Widget smelting_widget = getWidget(311);
		
		if(smelting_widget == null) {
			return false;
		}
		
		return smelting_widget.isVisible();
	}
	
	/**
	 * Finds the Item on the Smelting Widget, and automatically selects the correct amount.
	 * 
	 * @param item		The Selected Item to Smith
	 * @param amount	The Amount to make
	 */
	public static void smeltBar(Bars bar, int amount) {
		Widget smelt_interface = getWidget(311);
		
		if(bar == null) {
			return;
		}
		
		WidgetChild bar_widget = null;
		switch(bar) {
			case BRONZE:
				bar_widget = smelt_interface.getChild(4);
				break;
				
			case IRON:
				bar_widget = smelt_interface.getChild(6);
				break;
				
			case SILVER:
				bar_widget = smelt_interface.getChild(7);
				break;
				
			case STEEL:
				bar_widget = smelt_interface.getChild(8);
				break;
				
			case GOLD:
				bar_widget = smelt_interface.getChild(9);
				break;
				
			case MITHRIL:
				bar_widget = smelt_interface.getChild(10);
				break;
				
			case ADAMANTITE:
				bar_widget = smelt_interface.getChild(11);
				break;
				
			case RUNE:
				bar_widget = smelt_interface.getChild(12);
				break;
		}
		
		if(bar_widget == null || !bar_widget.isVisible()) {
			Flax.error("[SmeltingInterface] bar_interface is not visible!");
			return;
		}
		
		Flax.getContext().getMouse().move(bar_widget.getRectangle());
		MethodProvider.sleep(Calculations.random(100, 300));
        Flax.getContext().getMouse().click(true);
        MethodProvider.sleep(Calculations.random(500, 1000));

        // Interact with widget
 		if(amount == 1) {
 			// Smith 1
 			Flax.debug("[SmeltingInterface] Interacting -> 'Smelt 1'");
 			Flax.getContext().getClient().getMenu().clickIndex(0);
 		} else if(amount <= 5) {
 			// Smith 5
 			Flax.debug("[SmeltingInterface] Interacting -> 'Smelt 5'");
 			Flax.getContext().getClient().getMenu().clickIndex(1);
 		} else if(amount <= 10) {
 			// Smith 10
 			Flax.debug("[SmeltingInterface] Interacting -> 'Smelt 10'");
 			Flax.getContext().getClient().getMenu().clickIndex(2);
 		} else {
 			// Smith X
 			Flax.debug("[SmeltingInterface] Interacting -> 'Smelt X'");
 			Flax.getContext().getClient().getMenu().clickIndex(3);
 			
 			MethodProvider.sleep(Calculations.random(1000, 2000));
 			Flax.debug("[SmeltingInterface] Typing Amount -> '" + amount + "'");
 			Flax.getContext().getKeyboard().type(amount);
         	MethodProvider.sleep(Calculations.random(1000, 2400));
 			return;
 		}

 		MethodProvider.sleep(Calculations.random(1000, 2400));
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
