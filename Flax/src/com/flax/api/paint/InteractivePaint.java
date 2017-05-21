/**
 * 
 */
package com.flax.api.paint;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import com.flax.api.Flax;
import com.flax.api.event.listeners.CanvasMouseListener;
import com.flax.api.mouse.FlaxMouse;

/**
 * @author Ian
 *
 */
public class InteractivePaint implements CanvasMouseListener {
	
	private Point mouse;
	
	private final Color color1 = new Color(76, 88, 68, 187);
    private final Color color2 = new Color(255, 255, 255, 187);

    private final Font font1 = new Font("Segoe UI", 1, 12);

    private final Image img1 = getImage("http://i.imgur.com/CZrRask.gif");
    private boolean bar_hidden = false;
    private int		bar_x = 4;
	public InteractivePaint() {
		
		// Add the Mouse Listener
		Flax.getCanvasMouseManager().addCanvasMouseListener(this);
		
		mouse = new Point(10, 50);
	}
	
	public void paint(Graphics g1) {
		Graphics2D g = (Graphics2D)g1;
        g.setColor(color1);
        //g.fillRect(bar_x, 4, 514, 65);
        g.fillRect(bar_x, 4 , 514 - bar_x, 65);
        g.drawImage(img1, 431, -13, null);
        if(!bar_hidden && bar_x == 4) {
        	g.setFont(font1);
        	g.setColor(color2);
        	g.drawString("Flax-API v" + Flax.FLAX_VERSION, 6, 21);
        	g.drawString("Status: Not logged In", 7, 60);
        }
        
        if(bar_hidden) {
        	if(bar_x < 440) {
        		bar_x += 20;
        	} else if(bar_x > 440) {
        		bar_x = 440;
        	}
        } else {
        	if(bar_x > 4) {
        		bar_x -= 20;
        	} else if(bar_x < 4) {
        		bar_x = 4;
        	}
        }
	}

	@Override
	public void onMouse(MouseEvent event) {
		mouse = event.getPoint();
		
		switch(event.getButton()) {
			case 1:
				if(Flax.getContext().getMouse().getY() >=400) {
					FlaxMouse.windMouse(10, 10);
				} else {
					FlaxMouse.windMouse(630, 450);
				}
				break;
			case 2:
				if(Flax.getContext().getMouse().getY() >=400) {
					Flax.getContext().getMouse().move(new Point(10, 10));
				} else {
					Flax.getContext().getMouse().move(new Point(630, 450));
				}
				break;
			case 3:
		}
		
		
		if(mouse.getX() > 431 && mouse.getX() < 431+img1.getWidth(null)) {
			if(mouse.getY() > 0 && mouse.getY() < img1.getHeight(null)) {
				bar_hidden = !bar_hidden;
				
			}
		}
		
		event.consume();
	}
	
	private Image getImage(String url) {
        try {
            return ImageIO.read(new URL(url));
        } catch(IOException e) {
            return null;
        }
    }

}
