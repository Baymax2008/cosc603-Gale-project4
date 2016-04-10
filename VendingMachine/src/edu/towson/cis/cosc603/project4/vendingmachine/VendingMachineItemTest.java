package edu.towson.cis.cosc603.project4.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//import edu.towson.cis.cosc603.project4.rectangle.Rectangle;

public class VendingMachineItemTest {
	
	/** Declaring necessary test objects for  */
	VendingMachineItem reeseCup;

	@Before
	public void setUp() throws Exception {
		
		reeseCup = new VendingMachineItem( "Reese Cup", 1.00);
		
	}

	@After
	public void tearDown() throws Exception {
		
		reeseCup = null;
		
	}

	@Test
	public final void testVendingMachineItemNegPrice() {
		
		try {
			VendingMachineItem butterFingers = new VendingMachineItem( "Butter Fingers", -1.00);
	        fail(); // if we got here, no exception was thrown, which is bad
	    } 
	    catch (Exception e) {
	        final String expected = "Price cannot be less than zero";
	        assertEquals( expected, e.getMessage());
	    }        
	}

	@Test
	public final void testVendingMachineItemNormalName() {
		String butterFingerName = "Butter Fingers";
		VendingMachineItem butterFingers = new VendingMachineItem( butterFingerName, 1.00);
		assertEquals(butterFingerName, butterFingers.getName());
	}
	
	@Test
	public final void testVendingMachineItemNormalPrice() {
		String butterFingerName = "Butter Fingers";
		VendingMachineItem butterFingers = new VendingMachineItem( butterFingerName, 1.00);
		assertEquals(1.00, butterFingers.getPrice(),0.0001);
	}
	
	@Test
	public final void testGetName() {
		assertEquals("Reese Cup", reeseCup.getName());
	}

	@Test
	public final void testGetPrice() {
		assertEquals(1.00, reeseCup.getPrice(),0.001);
	}

}
