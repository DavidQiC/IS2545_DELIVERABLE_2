package edu.pitt.utils;

import java.util.Random;

public class RandomGenerator {
	private Random ran;
	private long seed;
	public void setSeed(long seed){
		ran = new Random(seed);
		this.seed = seed;
	}
	/**
	 * get random number ranging from 0 to the max number of visitors
	 * 
	 * @return
	 */
	public int getVistorRandom() {
		return ran.nextInt(Helper.visitorsNum);
	}

	/**
	 * get random number ranging from 0 to the max number of locations
	 * 
	 * @return
	 */
	public int getLocationRandom() {
//		long index = seed * (System.currentTimeMillis() % 100);
		return ran.nextInt(Helper.locationsNum);
	}

	/**
	 * get random number ranging from 0 to 1, deciding whether it's time to quit
	 * 
	 * @return
	 */
	public double getQuitRandom() {
		return Math.random();
	}
}
