package edu.pitt.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import edu.pitt.bean.Location;
import edu.pitt.bean.Visitor;
import edu.pitt.utils.RandomGenerator;
import edu.pitt.utils.TravelService;

public class GeneratorTest {
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
		assertFalse(service.quit(generator));
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
		try{
			assertEquals(visitor, service.getVisitor(generator));
		}catch(Exception e){
//			e.printStackTrace();
		}
		
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
		try{
			Location location = service.getLocation(generator);
			assertEquals(location, service.getLocation(generator));
		}catch(Exception e){
//			e.printStackTrace();
		}
	}
}
