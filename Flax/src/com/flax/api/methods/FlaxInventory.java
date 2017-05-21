/**
 * 
 */
package com.flax.api.methods;

import org.dreambot.api.wrappers.items.Item;

import com.flax.api.Flax;

/**
 * @author Ian
 *
 */
public class FlaxInventory {
	
	public static int getAmount(int item_id) {
		Item item = Flax.getContext().getInventory().get(item_id);
		if(item == null) {
			return 0;
		} else {
			return Flax.getContext().getInventory().count(item_id);
		}
	}
	
	public static boolean isSlotEmpty(int slot) {
		return Flax.getContext().getInventory().isSlotEmpty(slot);
	}
	
	public static Item getItemInSlot(int slot) {
		return Flax.getContext().getInventory().getItemInSlot(slot);
	}
}
