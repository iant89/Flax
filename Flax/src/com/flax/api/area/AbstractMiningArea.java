/**
 * 
 */
package com.flax.api.area;

import org.dreambot.api.methods.interactive.GameObjects;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.wrappers.interactive.GameObject;

import com.flax.api.enums.Ores;

/**
 * @author Ian
 *
 */
public abstract class AbstractMiningArea {
	public abstract String getName();
	public abstract Ores[] getOreTypes();
	public abstract GameObject[] getGameObjects();
	public abstract Tile getMineTile();
	
	public abstract GameObject findRock(Ores ore);
	public abstract GameObject findRockByAvailability(Ores ore);
	
}
