package edu.pitt;

import edu.pitt.bean.Location;
import edu.pitt.bean.Visitor;
import edu.pitt.utils.RandomGenerator;
import edu.pitt.utils.TravelService;

public class CitySim9002 {
	public static void main(String[] args) throws Exception {
		TravelService service = new TravelService();
		if(!service.checkArgs(args)){
			System.exit(1);
		}
		
		int seed = Integer.parseInt(args[0]);
		System.out.println("Welcome to CitySim!  Your seed is " + seed);
		
		
		RandomGenerator generator = new RandomGenerator();
		generator.setSeed(seed);
		
		Visitor visitor = null;
		Location location = null;
		for (int i = 0; i < 5; i++) {
			visitor = service.getVisitor(generator);
			String people = "Visitor " + (i + 1);//the index of visitors starting from 0 to n - 1; 
			System.out.println(people + " is " + visitor.getName() + " .");
			for (int j = 0;; j++) {
				if (j != 0) {
					if (service.quit(generator)) {
						System.out.println(people + " has left the city");
						break;
					}
				}
				location = service.getLocation(generator);
				String result = service.isLikeRes(i, location, visitor);
				System.out.println(result);
			}
			System.out.println("***");
		}

	}
}
