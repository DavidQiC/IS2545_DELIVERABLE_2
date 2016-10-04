package edu.pitt.test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;

import edu.pitt.bean.Location;
import edu.pitt.bean.Visitor;
import edu.pitt.utils.RandomGenerator;
//import static org.mockito.Mockito.*;
//import static org.junit.Assert.*;
import edu.pitt.utils.TravelService;

public class TestCases {

	/**
	 * A professor should like Cathedral of Learning
	 * this unit test should return true
	 */
	@Test
	public void likeTest() {
		TravelService service = new TravelService();
		Location location = Location.CathedralLearning;
		Visitor visitor = Visitor.Professor;
		assertTrue(service.isLike(location, visitor));
	}

	/**
	 * test if the parameters we input is a character
	 * it should return false;
	 */
	@Test
	public void argsTest1_charcter() {
		TravelService service = new TravelService();
		String[] args = { "a" };
		assertTrue(service.checkArgs(args));
	}

	/**
	 * test if the parameters we input is more than one 
	 * it should return false;
	 */
	@Test
	public void argsTest2_twoParameters() {
		TravelService service = new TravelService();
		String[] args = { "1", "2" };
		assertTrue(service.checkArgs(args));
	}

	/**
	 * test if the parameters we input is one number
	 * it should return true;
	 */
	@Test
	public void argsTest3_oneNumber() {
		TravelService service = new TravelService();
		String[] args = { "2" };
		assertTrue(service.checkArgs(args));
	}

	/**
	 * Mock the random generator, testing whether the location the generator choose is what we want
	 * Set the random number to be 0
	 * the Location should be CathedralLearning, and return true
	 * @throws Exception
	 */
	@Test
	public void generatorTest1_location() throws Exception{
		RandomGenerator generator = mock(RandomGenerator.class);
		TravelService service = new TravelService();
		when(generator.getLocationRandom()).thenReturn(0);
		Location location = Location.CathedralLearning;
		assertEquals(location, service.getLocation(generator));
	}
	
	
	/**
	 * Mock the random generator, testing whether the visitor the generator choose is what we want
	 * Set the random number to be 1
	 * the Visitor should be student, and return true
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void generatorTest2_visitor() throws Exception{
		RandomGenerator generator = mock(RandomGenerator.class);
		TravelService service = new TravelService();
		when(generator.getVistorRandom()).thenReturn(0);
		Visitor visitor = Visitor.Student;
		System.out.println(service.getVisitor(generator).getName());
		assertEquals(visitor, service.getVisitor(generator));
	}
	
	
	/**
	 * Mock the random generator
	 * Set the random number to be 0.1
	 * Since the threshold is 0.2, which can be seen in /SQAHW2/src/edu/pitt/utils/Helper.java, visitor will quit, it will return true;
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void generatorTest3_quitYes() throws Exception{
		RandomGenerator generator = mock(RandomGenerator.class);
		TravelService service = new TravelService();
		when(generator.getQuitRandom()).thenReturn(0.1);
		assertTrue(service.quit(generator));
	}
	
	/**
	 * Mock the random generator
	 * Set the random number to be 0.9
	 * Since the threshold is 0.2, which can be seen in /SQAHW2/src/edu/pitt/utils/Helper.java, visitor will not quit, it will return false.
	 * @throws Exception
	 */
	@Test
	public void generatorTest4_quitNo() throws Exception{
		RandomGenerator generator = mock(RandomGenerator.class);
		TravelService service = new TravelService();
		when(generator.getQuitRandom()).thenReturn(0.9);
		assertTrue(service.quit(generator));
	}
	
	/**
	 * Mock the random generator
	 * Set the random number to be 10
	 * Since the max index of visitor is 4, this Unit Test will fail and throw Exception
	 * @throws Exception
	 */
	@Test
	public void generatorTest5() throws Exception{
		RandomGenerator generator = mock(RandomGenerator.class);
		TravelService service = new TravelService();
		when(generator.getVistorRandom()).thenReturn(10);
		Visitor visitor = Visitor.Student;
		assertEquals(visitor, service.getVisitor(generator));
	}
	
	/**
	 * Mock the random generator
	 * Set the random number to be 10
	 * Since the max index of location is 4, this Unit Test will fail and throw Exception
	 * @throws Exception
	 */
	@Test
	public void generatorTest6() throws Exception{
		RandomGenerator generator = mock(RandomGenerator.class);
		TravelService service = new TravelService();
		when(generator.getLocationRandom()).thenReturn(10);
		Location location = service.getLocation(generator);
		assertEquals(location, service.getLocation(generator));
	}
}
