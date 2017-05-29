/**
 * 
 */
package com.flax.api.statistics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.flax.api.Flax;

/**
 * @author Ian
 *
 */
public class Statistics {
	public static Statistics _instance = null;
	private ArrayList<StatisticsEntry> statistics = new ArrayList<StatisticsEntry>();
	
	public static enum StatisticType {
		MINED("Mined"),
		SMELTED("Smelted"),
		SMITHED("Smithed");
		
		String name;
		
		StatisticType(String name) {
			this.name = name;
		}
		
		public String getName() {
			return this.name();
		}
	}
	
	public Statistics() {
		if(_instance != null) {
			return;	
		}
		
		_instance = this;
		
		// Open Statistics File
		openStatisticsFile();
	}
	
	public static Statistics getInstance() {
		if(_instance == null) {
			_instance = new Statistics();
		}
		
		return _instance;
	}
	
	public void addStatistic(StatisticType type, String name, int amount) {
		
	}
	
	public void save() {
		if(!Flax.STATISTICS_ENABLED) {
			Flax.log("Statistics are not enabled, so not saving data :(");
			return;
		}
		
		
	}
	
	private void openStatisticsFile() {
		try (BufferedReader br = new BufferedReader(new FileReader(new File("")))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       // process the line.
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
