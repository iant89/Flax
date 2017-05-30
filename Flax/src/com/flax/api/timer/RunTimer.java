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
	private TimeFormat time_format = TimeFormat.TIME_BARE;
	
	public static enum TimeFormat {
		TIME_FORMAL, TIME_SHORT, TIME_ABBREV, TIME_BARE
	}
	
	public void setFormat(TimeFormat format) {
		time_format = format;
	}
	
	public TimeFormat getFormat() {
		return time_format;
	}
	
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
		
		return formatTime((int)hours, (int)minutes, (int)seconds);
	}
	
	private String formatTime(int hrs, int mins, int secs) {
		switch(time_format) {
			case TIME_FORMAL:
				return "" + hrs + " Hours, " + mins + " Minutes, " + secs + " Seconds";
			case TIME_SHORT:
				return "" + hrs + "h, " + mins + "m, " + secs + "s";
			case TIME_ABBREV:
				return "" + hrs + " hr, " + mins + " min, " + secs + " sec";
			case TIME_BARE:
				return (hrs < 10 ? "0" : "") + hrs + ":" + (mins < 10 ? "0" : "") + mins + ":" + (secs < 10 ? "0" : "") + secs;
		}
		
		return "";
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
