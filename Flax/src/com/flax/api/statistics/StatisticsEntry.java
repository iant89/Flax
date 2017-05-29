/**
 * 
 */
package com.flax.api.statistics;

import com.flax.api.statistics.Statistics.StatisticType;

/**
 * @author Ian
 *
 */
public class StatisticsEntry {
	
	private StatisticType   statistics_type;
	private String			statistics_name;
	private int				statistics_amount;
	
	public StatisticsEntry(StatisticType type, String name, int amount) {
		this.statistics_type = type;
		this.statistics_name = name;
		this.statistics_amount = amount;
	}
	
	public StatisticType getType() {
		return this.statistics_type;
	}
	
	public int getAmount() {
		return this.statistics_amount;
	}
	
	public String getName() {
		return this.statistics_name;
	}
	
	public void addAmount(int amount) {
		this.statistics_amount += amount;
	}
}
