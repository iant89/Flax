/**
 * 
 */
package com.flax.api.paint.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.flax.api.Flax;

/**
 * @author Ian
 *
 */
public class Button extends AbstractPaintComponent {

	private boolean		button_selected				= false;
	private String		button_text 				= "";
	
	
	private Image image_left;
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
		button_selected = false;
	}
	
	@Override
	public void paint(Graphics g1) {
		Graphics2D g2 = (Graphics2D)g1;
		
		// Draw Left side of button
		g2.drawImage(image_left, getX(), getY(), null);
	}

	private void loadResources() {
		try {
			image_left 		= makeColorTransparent(ImageIO.read(Flax.class.getClassLoader().getResource("button\\button_left.jpg")), Color.WHITE);
			image_middle 	= ImageIO.read(Flax.class.getClassLoader().getResource("button\\button_middle.jpg"));
			image_right 	= ImageIO.read(Flax.class.getClassLoader().getResource("button\\button_right.jpg"));
			
			image_selected_left 	= ImageIO.read(Flax.class.getClassLoader().getResource("button\\button_selected_left.jpg"));
			image_selected_middle 	= ImageIO.read(Flax.class.getClassLoader().getResource("button\\button_selected_middle.jpg"));
			image_selected_right 	= ImageIO.read(Flax.class.getClassLoader().getResource("button\\button_selected_right.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, 20);
	}
	
	 public static Image makeColorTransparent(BufferedImage im, final Color color) {
        ImageFilter filter = new RGBImageFilter() {

            // the color we are looking for... Alpha bits are set to opaque
            public int markerRGB = color.getRGB() | 0xFF000000;

            public final int filterRGB(int x, int y, int rgb) {
                if ((rgb | 0xFF000000) == markerRGB) {
                    // Mark the alpha bits as zero - transparent
                    return 0x00FFFFFF & rgb;
                } else {
                    // nothing to do
                    return rgb;
                }
            }
        };

        ImageProducer ip = new FilteredImageSource(im.getSource(), filter);
        return Toolkit.getDefaultToolkit().createImage(ip);
    }
}
