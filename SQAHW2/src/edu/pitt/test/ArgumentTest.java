package edu.pitt.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

//import static org.mockito.Mockito.*;
//import static org.junit.Assert.*;
import edu.pitt.utils.TravelService;

public class ArgumentTest {

	

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

}
