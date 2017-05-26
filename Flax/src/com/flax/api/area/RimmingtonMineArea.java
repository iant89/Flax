/**
 * 
 */
package com.flax.api.area;

import java.awt.Graphics;
import java.util.ArrayList;

import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.wrappers.interactive.GameObject;

import com.flax.api.enums.Ores;

/**
 * @author Ian
 *
 */
public class RimmingtonMineArea extends AbstractMiningArea {

	private ArrayList<MiningRock> rocks = new ArrayList<MiningRock>();
	
	private int[] copper_rocks = new int[] { };
	
	public RimmingtonMineArea() {
		// Copper Rocks
		rocks.add(new MiningRock(0, 7484, new Tile(2979, 3248, 0), Ores.COPPER));
		rocks.add(new MiningRock(1, 7453, new Tile(2978, 3248, 0), Ores.COPPER));
		rocks.add(new MiningRock(2, 7483, new Tile(2977, 3247, 0), Ores.COPPER));
		rocks.add(new MiningRock(3, 7484, new Tile(2976, 3247, 0), Ores.COPPER));
		rocks.add(new MiningRock(4, 7484, new Tile(2977, 3245, 0), Ores.COPPER));
		
	}
	
	@Override
	public String getName() {
		return "Rimmington";
	}

	@Override
	public Ores[] getOreTypes() {
		return new Ores[] { Ores.COPPER, Ores.TIN, Ores.CLAY, Ores.IRON, Ores.GOLD };
	}

	@Override
	public GameObject[] getGameObjects() {
		return null;
	}

	/**
	 * Find a Rock based on ore type, will pick a random one from all thats available
	 */
	@Override
	public GameObject findRock(Ores ore) {

		return null;
	}

	/**
	 * Finds a Rock based on how many people are mining from it, if all are being mined, will pick a random one
	 */
	@Override
	public GameObject findRockByAvailability(Ores ore) {
		return null;
	}

	/**
	 * Returns the Mine Tile, used to walk to the mine
	 */
	@Override
	public Tile getMineTile() {
		return null;
	}

	public void paint(Graphics g1) {
		
	}
	
	public class MiningRock {
		private int id;
		private Tile location;
		private Ores type;
		private int number;
		
		public MiningRock(int number, int id, Tile tile, Ores ore_type) {
			this.id = id;
			this.number = number;
			this.location = tile;
			this.type = ore_type;
		}
	}
}
