package edu.pitt.utils;

import java.util.List;

import edu.pitt.bean.Location;
import edu.pitt.bean.Visitor;

public class TravelService {
	/**
	 * To determine this location is liked by this visitor or not.
	 * @param location
	 * @param visitor
	 * @return like => true; otherwise false;
	 */
	public boolean isLike(Location location, Visitor visitor){
		List<Integer> list = Helper.LocationlikeMap.get(location.getIndex());
		for(Integer index: list){
			if(index == visitor.getIndex()){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * To decide whether it is time to quit
	 * @return
	 */
	public boolean quit(RandomGenerator generator){
		double seed = generator.getQuitRandom();
		if(seed < Helper.quitSeed){
			return true;
		}
		return false;
	}
	
	/**
	 * check the parameters is right or not
	 * @param args
	 * @return
	 */
	public boolean checkArgs(String[] args){
		if(args.length != 1){
			System.out.println("The program shall accept one and only one argument");
			return false;
		}
		try{
			Integer.parseInt(args[0]);
		}catch(Exception e){
			System.out.println("The input must be a Integer");
			return false;
		}
		return true;
	}
	
	public Visitor getVisitor(RandomGenerator generator) throws Exception{
		Visitor visitior = null;
		int num = generator.getVistorRandom();
		if(num >= Helper.visitorsNum){
			throw new Exception(" the index of number is out out bound, it must be between 0 and "+Helper.visitorsNum);
		}
		visitior = Helper.vistors[num];
		return visitior;
	}
	
	public Location getLocation(RandomGenerator generator) throws Exception{
		Location location = null;
		int num = generator.getLocationRandom();
		if(num >= Helper.visitorsNum){
			throw new Exception(" the index of number is out out bound, it must be between 0 and "+Helper.locationsNum);
		}
		location = Helper.locations[num];
		return location;
	}
	
	
}
