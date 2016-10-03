package edu.pitt.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import edu.pitt.bean.Location;
import edu.pitt.bean.Visitor;

public class Helper {
	public static final Visitor[] vistors = { Visitor.Student, Visitor.Professor, Visitor.Business, Visitor.Blogger };
	public static final int visitorsNum = vistors.length;
	public static final Location[] locations = { Location.CathedralLearning, Location.SquirrelHill, Location.ThePoint,
			Location.Downtown };
	public static final int locationsNum = locations.length;

	//quisSeed is a threshold, if random number is less than this threshold, the visitor will quit
	public static final double quitSeed = 0.2;
	//{Location : {visitor1,visitor2,... }}, meaning which placed is liked by whom
	public static HashMap<Integer, List<Integer>> LocationlikeMap = new HashMap<>();
	//{Location : {visitor1,visitor2,... }}, meaning which placed is disliked by whom
	public static HashMap<Integer, List<Integer>> LocationDisLikeMap = new HashMap<>();

	static {
		// This is used to create LocationlikeMap and LocationDisLikeMap
		HashMap<Integer, List<Integer>> likeMap = new HashMap<>();
		HashMap<Integer, List<Integer>> disLikeMap = new HashMap<>();
		// student 1
		List<Integer> like = new LinkedList<>();
		List<Integer> disLike = new LinkedList<>();
		like.add(Location.SquirrelHill.getIndex());
		like.add(Location.Downtown.getIndex());
		like.add(Location.ThePoint.getIndex());
		disLike.add(Location.CathedralLearning.getIndex());
		likeMap.put(Visitor.Student.getIndex(), new ArrayList<Integer>(like));
		disLikeMap.put(Visitor.Student.getIndex(), new ArrayList<Integer>(disLike));
		like.clear();
		disLike.clear();
		// professor 2
		like.add(Location.SquirrelHill.getIndex());
		like.add(Location.Downtown.getIndex());
		like.add(Location.CathedralLearning.getIndex());
		like.add(Location.ThePoint.getIndex());
		likeMap.put(Visitor.Professor.getIndex(), new ArrayList<Integer>(like));
		like.clear();
		// Business 3
		like.add(Location.SquirrelHill.getIndex());
		like.add(Location.Downtown.getIndex());
		disLike.add(Location.ThePoint.getIndex());
		disLike.add(Location.CathedralLearning.getIndex());
		disLikeMap.put(Visitor.Business.getIndex(), new ArrayList<Integer>(disLike));
		likeMap.put(Visitor.Business.getIndex(), new ArrayList<Integer>(like));
		like.clear();
		disLike.clear();
		// Blogger 4
		disLike.add(Location.CathedralLearning.getIndex());
		disLike.add(Location.SquirrelHill.getIndex());
		disLike.add(Location.ThePoint.getIndex());
		disLike.add(Location.Downtown.getIndex());
		disLikeMap.put(Visitor.Blogger.getIndex(), new ArrayList<Integer>(disLike));
		like = null;
		disLike = null;

		// reverse
		like = new LinkedList<>();
		disLike = new LinkedList<>();
		for (Entry<Integer, List<Integer>> entry : likeMap.entrySet()) {
			int vistor = entry.getKey();
			for (Integer location : entry.getValue()) {
				if (LocationlikeMap.containsKey(location)) {
					LocationlikeMap.get(location).add(vistor);
				} else {
					List<Integer> list = new LinkedList<>();
					list.add(vistor);
					LocationlikeMap.put(location, list);
				}
			}
		}

		for (Entry<Integer, List<Integer>> entry : disLikeMap.entrySet()) {
			int vistor = entry.getKey();
			for (Integer location : entry.getValue()) {
				if (LocationDisLikeMap.containsKey(location)) {
					LocationDisLikeMap.get(location).add(vistor);
				} else {
					List<Integer> list = new LinkedList<>();
					list.add(vistor);
					LocationDisLikeMap.put(location, list);
				}
			}
		}

	}
}
