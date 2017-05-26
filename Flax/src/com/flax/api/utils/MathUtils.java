/**
 * 
 */
package com.flax.api.utils;

/**
 * @author Ian
 *
 */
public class MathUtils {
	public static float scaleIntToFloat(final int in_value, final int in_min, final int in_max, final float out_min, final float out_max) {
        return (float) (((out_max - out_min) * (in_value - in_min) / (in_max - in_min)) + out_min);
    }
	
	public static int scaleInt(final int in_value, final int in_min, final int in_max, final int out_min, final int out_max) {
		return (((out_max - out_min) * (in_value - in_min) / (in_max - in_min)) + out_max);
	}
	
	public static double caculatePercent(int value, int max) {
		return (double) (value * 100.0f) / max;
	}
}
