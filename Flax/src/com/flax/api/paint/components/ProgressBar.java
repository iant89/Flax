/**
 * 
 */
package com.flax.api.paint.components;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JProgressBar;

import com.flax.api.utils.MathUtils;

/**
 * @author Ian
 *
 */
public class ProgressBar extends AbstractPaintComponent {

	// Default Colors
	public final Color 		COLOR_GREEN 					= new Color(0, 95, 0);
	public final Color		COLOR_ORANGE					= new Color(216, 128, 0);
	
	// Progress Bar Variables
	private int 			progress_maximum 				= 0;
	private int	 			progress_minimum 				= 0;
	private int 			progress_value 					= 0;
	private boolean 		progress_string_painted 		= false;
	private String			progress_string 				= "";
	private Color			progress_color					= this.COLOR_GREEN;
	private Color			progress_string_color			= new Color(255, 255, 255);
	
	/**
	 * Sets the color of the Progress Bar
	 * @param Color
	 */
	public void setProgressColor(Color color) {
		progress_color = color;
	}
	
	/**
	 * Sets the color of the String if Painted
	 * @param color
	 */
	public void setProgressStringColor(Color color) {
		progress_string_color = color;
	}
	
	/**
	 * Sets custom text to draw on the Progress Bar
	 * @param progress_text
	 */
	public void setProgressString(String progress_text) {
		progress_string = progress_text;
	}
	
	/**
	 * Sets the Maximum Value of the Progress Bar
	 * @param max
	 */
	public void setMaximum(int max) {
		progress_maximum = max;
	}
	
	/**
	 * Sets the Minimum Value of the Progress Bar
	 * @param min
	 */
	public void setMinimum(int min) {
		progress_minimum = min;
	}
	
	/**
	 * Sets the Value of the Progress Bar
	 * @param value
	 */
	public void setValue(int value) {
		if(value > progress_maximum) {
			progress_value = progress_maximum;
		} else if(value < progress_minimum) {
			progress_value = progress_minimum;
		} else {
			progress_value = value;
		}
	}
	
	/**
	 * Sets If the Percent is Painted on the Progress Bar
	 * @param boolean
	 */
	public void setStringPainted(boolean painted) {
		progress_string_painted = painted;
	}
		
	/**
	 * Gets the Current Maximum of the Progress Bar
	 * @return int
	 */
	public int getMaximum() {
		return progress_maximum;
	}
	
	/**
	 * Gets the Current Minumum of the Progress Bar
	 * @return int
	 */
	public int getMinimum() {
		return progress_minimum;
	}
	
	/**
	 * Gets the Current Value of the Progress Bar
	 * @return int
	 */
	public int getValue() {
		return progress_value;
	}
	
	/**
	 * Gets if the Percent is Painted to the progress bar
	 * @return boolean
	 */
	public boolean isStringPainted() {
		return progress_string_painted;
	}
	
	/**
	 * Gets the Color of the Progress Bar
	 * @return Color
	 */
	public Color getProgressColor() {
		return progress_color;
	}
	
	/**
	 * Gets the Color of the String
	 * @return
	 */
	public Color getProgressStringColor() {
		return progress_string_color;
	}
	
	/**
	 * Gets the Custom text
	 * @return String
	 */
	public String getProgressString() {
		return progress_string;
	}
	
	@Override
	public void paint(Graphics g1) {
		
		// Check to see if the Component is Visible
		if(!this.isVisible()) {
			return;
		}
		
		Graphics2D g2 = (Graphics2D)g1;
		
		//g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		/*
		 * Draw the Background
		 */
		g2.setColor(new Color(56, 48, 39));
		g2.fillRect(getX(), getY(), getWidth(), getHeight());
		
		/*
		 * Draw the Progress
		 */
		// Scale the Progress Value to the Width of the Progress bar
		int progress_draw_width = (int) MathUtils.scaleIntToFloat(progress_value, this.getMinimum(), this.getMaximum(), 0, getWidth()+1);//MathUtils.scaleInt(progress_value, progress_minimum, progress_maximum, 0, getWidth());
		
		g2.setColor(getProgressColor());
		g2.fillRect(getX(), getY(), progress_draw_width, getHeight());
		
		/*
		 * Draw the Progress String 
		 */
		if(progress_string_painted) {
			String percent_s = "";
			
			if(progress_string.length() != 0) {
				percent_s = progress_string;
			} else {
				percent_s = "" + ((int)MathUtils.caculatePercent(progress_value, progress_maximum)) + "%";
			}
			
			g2.setFont(g2.getFont().deriveFont(g2.getFont().BOLD));
			
			FontMetrics metrics = g2.getFontMetrics(g2.getFont());
			
			int font_width = metrics.stringWidth(percent_s);
			int font_height = metrics.getHeight();
			
			int font_x = ((getWidth() / 2) - (font_width / 2));
			int font_y = ((getHeight() / 2) - (font_height / 2)) + metrics.getAscent();
			
			g2.setColor(new Color(0, 0, 0, 127));
			g2.drawString(percent_s, (getX() + font_x+2), (getY()+font_y+2));
			
			g2.setColor(getProgressStringColor());
			g2.drawString(percent_s, (getX() + font_x), (getY() + font_y));	
		}
		
		/*
		 * Draw the Shadow
		 */
		// Top Side
		g2.setColor(new Color(0, 0, 0, 127));
		g2.fillRect(getX(), getY(), getWidth(), 4);
		// Left Side
		g2.fillRect(getX(), getY()+4, 4, getHeight()-4);
		
		/*
		 * Draw the Border
		 */
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(1));
		g2.drawRect(getX(), getY(), getWidth(), getHeight());
		
		
	}

	public double getPercent() {
		return MathUtils.caculatePercent(progress_value, progress_maximum);
	}

}
