/**
 * 
 */
package com.flax.api.paint.components;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import java.io.IOException;

import javax.imageio.ImageIO;

import com.flax.api.Flax;

/**
 * @author Ian
 *
 */
public class Button extends PaintComponent {

	private boolean		button_selected				= false;
	private String		button_text 				= "";
	
	
	private BufferedImage image_left;
	private BufferedImage image_middle;
	private BufferedImage image_right;
	private BufferedImage image_selected_left;
	private BufferedImage image_selected_middle;
	private BufferedImage image_selected_right;
	
	public Button() {
		loadResources();
	}
	
	public String getText() {
		return button_text;
	}
	
	public void setText(String text) {
		button_text = text;
	}
	
	public boolean isSelected() {
		return button_selected;
	}
	
	public void setSelected(boolean selected) {
		button_selected = selected;
	}
	
	@Override
	public void paint(Graphics g1) {
		Graphics2D g2 = (Graphics2D)g1;
		
		// Draw Left side of button
		if(!isSelected()) {
			g2.drawImage(image_left, getX(), getY(), null);
			scaleImageWidth(g2, image_middle, getX()+image_left.getWidth(), getY(), getWidth());
			g2.drawImage(image_right, (getX() + getWidth()) - image_right.getWidth(), getY(), null);
		} else {
			g2.drawImage(image_selected_left, getX(), getY(), null);
			scaleImageWidth(g2, image_selected_middle, getX()+image_selected_left.getWidth(), getY(), getWidth());
			g2.drawImage(image_selected_right, (getX() + getWidth()) - image_selected_right.getWidth(), getY(), null);
		}
		
		g2.setFont(g2.getFont().deriveFont(g2.getFont().PLAIN));		
		FontMetrics metrics = g2.getFontMetrics(g2.getFont());
		
		int font_width = metrics.stringWidth(getText());
		int font_height = metrics.getHeight();
		
		int font_x = ((getWidth() / 2) - (font_width / 2));
		int font_y = ((getHeight() / 2) - (font_height / 2)) + metrics.getAscent();
		
		
		g2.setColor(Color.BLACK);
		g2.drawString(getText(), getX() + font_x + 1, getY() + font_y + 1);
		g2.setColor(Color.WHITE);
		g2.drawString(getText(), getX() + font_x, getY() + font_y);
	}

	private void loadResources() {
		try {
			image_left 		= ImageIO.read(Flax.class.getClassLoader().getResource("button\\button_left.png"));
			image_middle 	= ImageIO.read(Flax.class.getClassLoader().getResource("button\\button_middle.jpg"));
			image_right 	= ImageIO.read(Flax.class.getClassLoader().getResource("button\\button_right.png"));
			
			image_selected_left 	= ImageIO.read(Flax.class.getClassLoader().getResource("button\\button_selected_left.png"));
			image_selected_middle 	= ImageIO.read(Flax.class.getClassLoader().getResource("button\\button_selected_middle.jpg"));
			image_selected_right 	= ImageIO.read(Flax.class.getClassLoader().getResource("button\\button_selected_right.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, 20);
	}
	
	public void scaleImageWidth(Graphics2D g2, BufferedImage image, int x, int y, int width) {
		
		int image_width = image.getWidth();
		
		while(x <= width) {
			g2.drawImage(image, x, y, null);
			
			x += image_width;
		}
	}
	
	public BufferedImage scaleImage(BufferedImage img, int width, int height, Color background) {
	    int imgWidth = img.getWidth();
	    int imgHeight = img.getHeight();
	    if (imgWidth*height < imgHeight*width) {
	        width = imgWidth*height/imgHeight;
	    } else {
	        height = imgHeight*width/imgWidth;
	    }
	    BufferedImage newImage = new BufferedImage(width, height,
	            BufferedImage.TYPE_INT_RGB);
	    Graphics2D g = newImage.createGraphics();
	    try {
	        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
	                RenderingHints.VALUE_INTERPOLATION_BICUBIC);
	        g.setBackground(background);
	        g.clearRect(0, 0, width, height);
	        g.drawImage(img, 0, 0, width, height, null);
	    } finally {
	        g.dispose();
	    }
	    return newImage;
	}
}
