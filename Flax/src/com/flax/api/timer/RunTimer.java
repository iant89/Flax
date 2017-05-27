/**
 * 
 */
package com.flax.api.timer;

/**
 * @author Ian
 *
 */
public class RunTimer {
	private long 	start_time;
	private long	hours;
	private long	minutes;
	private long	seconds;
	
	/**
	 * Formats the Runtime of the Timer in HH:MM:SS
	 * 
	 * @return String		 
	 */
	public String getElapsed() {
		long run_time = System.currentTimeMillis() - start_time;
		
		seconds = (int)(run_time / 1000 % 60);
		minutes = (int)(run_time / 1000 / 60) % 60;
		hours = (int)(run_time / 1000 / 60 / 60) % 60;
		
		StringBuilder time_sb = new StringBuilder();
		
		if(hours < 10) {
			time_sb.append("0");
		}
		time_sb.append(hours);
		time_sb.append(":");
		
		if(minutes < 10) {
			time_sb.append("0");
		}
		time_sb.append(minutes);
		time_sb.append(":");
		
		if(seconds < 10) {
			time_sb.append("0");
		}
		time_sb.append(seconds);
		
		return time_sb.toString();
	}
	
	/**
	 * Gets the Start Time of the timer in milliseconds
	 * @return
	 */
	public long getStartTime() {
		return start_time;
	}
	
	/**
	 * Gets the RunTime of the Timer as milliseconds
	 * 
	 * @return
	 */
	public long getRunTime() {
		return System.currentTimeMillis() - start_time;
	}
	
	public boolean isRunning() {
		return (getRunTime() > 0);
	}
	
	public void start() {
		start_time = System.currentTimeMillis();
	}
	
	public void restart() {
		start();
	}
}
