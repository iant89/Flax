/**
 * 
 */
package com.flax.api.paint;

import java.awt.Graphics;

/**
 * @author Ian
 *
 */
public abstract class AbstractPaintComponent {
	private int 	component_x = 0;
	private int 	component_y = 0;
	private int 	component_width = 0;
	private int 	component_height = 0;
	private boolean component_visible = false;
	
	public int getX() {
		return component_x;
	}
	
	public int getY() {
		return component_y;
	}
	
	public int getWidth() {
		return component_width;
	}
	
	public int getHeight() {
		return component_height;
	}
	
	public boolean isVisible() {
		return component_visible;
	}
	
	public void setVisible(boolean visible) {
		component_visible = visible;
	}
	
	public void setBounds(int x, int y, int width, int height) {
		component_x = x;
		component_y = y;
		component_width = width;
		component_height = height;
	}
	
	public abstract void paint(Graphics g1);
}
