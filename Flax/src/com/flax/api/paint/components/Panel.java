package com.flax.api.paint.components;

import java.awt.Graphics;
import java.util.ArrayList;

public class Panel extends PaintComponent {

	
	private ArrayList<PaintComponent> components = new ArrayList<PaintComponent>();
	
	public void addComponent(PaintComponent component) {
		components.add(component);
	} 
	
	public void removeAll() {
		components = new ArrayList<PaintComponent>();
	}
	
	@Override
	public void paint(Graphics g1) {
		// Draw Background
		
		
		// Loop through and draw each component
		for(PaintComponent component : components) {
			if(component != null) {
				component.paint(g1);
			}
		}

	}

}
