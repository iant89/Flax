/**
 * 
 */
package com.flax.api.paint.components;

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
	private String  component_tool_tip = "";
	
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
	
	public void setToolTip(String tool_tip) {
		component_tool_tip = tool_tip;
	}
	
	public String getToolTip() {
		return component_tool_tip;
	}
	
	public void setBounds(int x, int y, int width, int height) {
		component_x = x;
		component_y = y;
		component_width = width;
		component_height = height;
	}
	
	public abstract void paint(Graphics g1);
}
