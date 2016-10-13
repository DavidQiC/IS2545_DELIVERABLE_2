package edu.pitt.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.pitt.bean.Location;
import edu.pitt.bean.Visitor;
import edu.pitt.utils.TravelService;

public class IsLikeResTest {
	/**
	 * A student, assume he is first visitor, should dislike The Cathedral of Learning 
	 * this unit test should print the message, "Visitor 1 is going to The Cathedral of Learning!"
	 */
	@Test
	public void islikeResTest1(){
		TravelService service = new TravelService();
		Location location = Location.CathedralLearning;
		Visitor visitor = Visitor.Student;
		service.isLikeRes(0, location, visitor);
	}
	
	
	/**
	 * A professor, assume he is second visitor, should like Squirrel Hill
	 * this unit test should print the message, "Visitor 2 is going to Squirrel Hill!" 
	 */
	@Test
	public void islikeResTest2(){
		TravelService service = new TravelService();
		Location location = Location.SquirrelHill;
		Visitor visitor = Visitor.Professor;
		service.isLikeRes(1, location, visitor);
	}
	
	/**
	 * A Business Person, assume he is third visitor, should dislike The Point
	 * this unit test should print the message, "Visitor 3 is going to The Point!" 
	 */
	@Test
	public void islikeResTest3(){
		TravelService service = new TravelService();
		Location location = Location.ThePoint;
		Visitor visitor = Visitor.Business;
		service.isLikeRes(2, location, visitor);
	}
	
	/**
	 * A Blogger, assume he is forth visitor,  should dislike Downtown
	 * this unit test should print the message, "Visitor 4 is going to Downtown!" 
	 */
	@Test
	public void islikeResTest4(){
		TravelService service = new TravelService();
		Location location = Location.Downtown;
		Visitor visitor = Visitor.Blogger;
		service.isLikeRes(3, location, visitor);
	}
}
