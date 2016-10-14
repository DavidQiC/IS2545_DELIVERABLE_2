package edu.pitt.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import edu.pitt.bean.Location;
import edu.pitt.bean.Visitor;
import edu.pitt.utils.TravelService;

public class LikesTest {
	
	/**
	 * A student should dislike The Cathedral of Learning 
	 * this unit test should return false
	 */
	@Test
	public void likeTest1(){
		TravelService service = new TravelService();
		Location location = Location.CathedralLearning;
		Visitor visitor = Visitor.Student;
		assertFalse(service.isLike(location, visitor));
	}
	
	
	/**
	 * A professor should like Squirrel Hill
	 * this unit test should return true 
	 */
	@Test
	public void likeTest2(){
		TravelService service = new TravelService();
		Location location = Location.SquirrelHill;
		Visitor visitor = Visitor.Professor;
		assertTrue(service.isLike(location, visitor));
	}
	
	/**
	 * A Business Person should dislike The Point
	 * this unit test should return false 
	 */
	@Test
	public void likeTest3(){
		TravelService service = new TravelService();
		Location location = Location.ThePoint;
		Visitor visitor = Visitor.Business;
		assertFalse(service.isLike(location, visitor));
	}
	
	/**
	 * A Blogger should dislike Downtown
	 * this unit test should return false 
	 */
	@Test
	public void likeTest4(){
		TravelService service = new TravelService();
		Location location = Location.Downtown;
		Visitor visitor = Visitor.Blogger;
		assertFalse(service.isLike(location, visitor));
	}
	
	
}
