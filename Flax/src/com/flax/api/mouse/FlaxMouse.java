/**
 * 
 */
package com.flax.api.mouse;

import java.awt.Point;

import org.dreambot.api.methods.MethodProvider;

import com.flax.api.Flax;

/**
 * @author Ian
 *
 */
public class FlaxMouse {
	private static int cx, cy;
	
	private static void updateMousePosition() {
		cx = Flax.getContext().getMouse().getX();
		cy = Flax.getContext().getMouse().getY();
	}
		
	/**
     * Internal mouse movement algorithm. Do not use this without credit to either
     * Benjamin J. Land or BenLand100. This is synchronized to prevent multiple
     * motions and bannage.
     * @param xs The x start
     * @param ys The y start
     * @param xe The x destination
     * @param ye The y destination
     * @param gravity Strength pulling the position towards the destination
     * @param wind Strength pulling the position in random directions
     * @param minWait Minimum relative time per step
     * @param maxWait Maximum relative time per step
     * @param maxStep Maximum size of a step, prevents out of control motion
     * @param targetArea Radius of area around the destination that should
     *                   trigger slowing, prevents spiraling
     * @result The actual end point
     */
	private static synchronized Point windMouseImpl(double xs, double ys, double xe, double ye, double gravity, double wind, double minWait, double maxWait, double maxStep, double targetArea) {
        //System.out.println(targetArea);
        final double sqrt3 = Math.sqrt(3);
        final double sqrt5 = Math.sqrt(5);

        updateMousePosition();
        
        
        double dist, veloX = 0, veloY = 0, windX = 0, windY = 0;
        while ((dist = Math.hypot(xs - xe,ys - ye)) >= 1) {
            wind = Math.min(wind, dist);
            if (dist >= targetArea) {
                windX = windX / sqrt3 + (Math.random() * (wind * 2D + 1D) - wind) / sqrt5;
                windY = windY / sqrt3 + (Math.random() * (wind * 2D + 1D) - wind) / sqrt5;
            } else {
                windX /= sqrt3;
                windY /= sqrt3;
                if (maxStep < 3) {
                    maxStep = Math.random() * 3 + 3D;
                } else {
                    maxStep /= sqrt5;
                }
                //System.out.println(maxStep + ":" + windX + ";" + windY);
            }
            veloX += windX + gravity * (xe - xs) / dist;
            veloY += windY + gravity * (ye - ys) / dist;
            double veloMag = Math.hypot(veloX, veloY);
            if (veloMag > maxStep) {
                double randomDist = maxStep / 2D + Math.random() * maxStep / 2D;
                veloX = (veloX / veloMag) * randomDist;
                veloY = (veloY / veloMag) * randomDist;
            }
            xs += veloX;
            ys += veloY;
            int mx = (int) Math.round(xs);
            int my = (int) Math.round(ys);
            if (cx != mx || cy != my) {
                //Scratch
                /*g.drawLine(cx,cy,mx,my);
                frame.repaint();*/
                //MouseJacking
                /*try {
                    Robot r = new Robot();
                    r.mouseMove(mx,my);
                } catch (Exception e) { } */
                moveMouseImpl(mx, my);
            }
            double step = Math.hypot(xs - cx, ys - cy);
            try {
                Thread.sleep(Math.round((maxWait - minWait) * (step / maxStep) + minWait));
            } catch (InterruptedException ex) {  }
        }
        //System.out.println(Math.abs(xe - cx) + ", " + Math.abs(ye - cy));
        return new Point(cx, cy);
    }
	
	/**
     * Moves the mouse from the current position to the specified position.
     * Approximates human movement in a way where smoothness and accuracy are
     * relative to speed, as it should be.
     * @param x The x destination
     * @param y The y destination
     * @result The actual end point
     */
    public static synchronized Point windMouse(int x, int y) {
        //double speed = (Math.random() * 15D + 15D) / 10D;
    	updateMousePosition();
        double speed = (Math.random() * 15D + 5D) / 10D;
        //return windMouseImpl(cx,cy,x,y,9D,3D,5D/speed,10D/speed,10D*speed,8D*speed);
        return windMouseImpl(cx,cy,x,y,9D,3D,4D/speed,9D/speed,10D*speed,8D*speed);
    }
    
    public static synchronized Point moveMouse(int x, int y) {
    	updateMousePosition();
        return moveMouseImpl(x,y);
    }
    
    private static Point moveMouseImpl(int x, int y) {
        Flax.getContext().getMouse().move(new Point(cx, cy));
        cx = x;
        cy = y;
        return new Point(cx, cy);
    }
    
    public static void clickMouse() {
    	Flax.getContext().getMouse().click(false);
    }
}
