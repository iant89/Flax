/**
 * 
 */
package com.flax.api.utils;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.wrappers.interactive.GameObject;
import org.dreambot.api.wrappers.interactive.model.EntityModel;

/**
 * @author Ian
 *
 */
public class PaintUtils {
	public static void paintObject(GameObject object, Graphics g, Color color) {
		if (object != null) {
			paintTile(object.getTile(), g, color);
			
			/*
			object.getModel()
			EntityModel model = object.getModel();
			if (model != null) {
				g.setColor(color);
				for (Polygon p : model.getTriangles()) {
					g.fillPolygon(p);
				}
			}
			*/
		}
	}
	
	public static void paintTile(Tile tile, Graphics g, Color color) {
		if(tile != null) {
			g.setColor(color);
			g.drawPolygon(tile.getPolygon());
		}
	}
	
	public static void paintArea(Area area, Graphics g, Color color) {
		if(area != null) {
			g.setColor(color);
			g.drawPolygon(area.getPolygonArea());
		}
	}
	
	public static void drawTextOnObject(GameObject object, String text, Graphics g1, Color color, boolean box) {
		Graphics2D g = (Graphics2D)g1;
		
		if(object != null) {
			Point center_point = object.getCenterPoint();
			
			
			if(box) {
				// We are drawing a Box
				int font_width = g.getFontMetrics(g.getFont()).stringWidth(text);
				int font_height = g.getFontMetrics(g.getFont()).getHeight();
				
				Dimension size = new Dimension(font_width+2, font_height+2);
				int x = (int) (center_point.x - (size.getWidth() / 2));
				int y = (int) (center_point.y - (size.getHeight() / 2))+g.getFontMetrics(g.getFont()).getAscent();
			
				// Draw Box
		        g.setColor(new Color(40, 43, 47));
		        g.fillRect(x, y, (int)size.getWidth(), (int)size.getHeight());
		        
		        // Draw Border
		        g.setColor(new Color(153, 153, 153));
		        g.setStroke(new BasicStroke(1));
		        g.drawRect(x, y, (int)size.getWidth(), (int)size.getHeight());
				
		        // Draw Text
				g.setColor(color);
				g.drawString(text, center_point.x - (font_width / 2), center_point.y);
			}
		}
	}
	
	public static void drawTextOnObject(GameObject object, String text, Graphics g, Color color) {
		drawTextOnObject(object, text, g, color, false);
	}
}
