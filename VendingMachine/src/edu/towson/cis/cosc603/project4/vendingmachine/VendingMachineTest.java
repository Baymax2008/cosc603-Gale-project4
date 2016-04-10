package edu.towson.cis.cosc603.project4.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class VendingMachineTest {

	VendingMachine building6008VendingMachine;
	VendingMachineItem reeseCup, butterfingers, milkyWay, fifthAvenue, payDay;
	
	@Before
	public void setUp() throws Exception {
		building6008VendingMachine = new VendingMachine();
		reeseCup = new VendingMachineItem( "Reese Cup", 0.75);
		butterfingers = new VendingMachineItem( "Butterfingers", 1.00);
		milkyWay = new VendingMachineItem( "Milky Way", 1.25);
		fifthAvenue = new VendingMachineItem( "5th Avenue", 1.50);
		payDay = new VendingMachineItem("Pay Day", 1.75);
	}

	@After
	public void tearDown() throws Exception {
		building6008VendingMachine = null;
		reeseCup = null;
		butterfingers = null;
		milkyWay = null;
		fifthAvenue = null;
		payDay = null;
	}
	
	/**
	 * This is testing that a good item is place is a valid slot of the {@link VendingMachine} class.
	 */
	@Test
	public final void testAddItemGoodPosition() {
		building6008VendingMachine.addItem(reeseCup, "A");
		assertEquals(reeseCup, building6008VendingMachine.getItem("A"));
	}

	/**
	 * testing you cannot put an item in a slot that doesn't exist of the {@link VendingMachine} class.
	 */
	@Test
	public final void testAddItemBadPostion() {
		
		try {
			building6008VendingMachine.addItem(reeseCup, "E");
	        fail(); // if we got here, no exception was thrown, which is bad
	    } 
	    catch (Exception e) {
	        final String expected = "Invalid code for vending machine item";
	        assertEquals( expected, e.getMessage());
	    }		
	}

	/**
	 * testing you cannot fill a slot that is already filled of the {@link VendingMachine} class.
	 */
	@Test
	public final void testAddItemDuplicatedPostion() {
		building6008VendingMachine.addItem(reeseCup, "A");
		
		try {
			building6008VendingMachine.addItem(reeseCup, "A");
	        fail(); // if we got here, no exception was thrown, which is bad
	    } 
	    catch (Exception e) {
	        final String expected = "Slot A already occupied";
	        assertEquals( expected, e.getMessage());
	    }		
	}

	/**
	 * testing that you can fill the machine with no errors of the {@link VendingMachine} class.
	 */
	@Test
	public final void testAddItemFull() {
		building6008VendingMachine.addItem(reeseCup, "A");
		building6008VendingMachine.addItem(butterfingers, "B");
		building6008VendingMachine.addItem(milkyWay, "C");
		building6008VendingMachine.addItem(fifthAvenue, "D");
		
		assertEquals(reeseCup, building6008VendingMachine.getItem("A"));
		assertEquals(butterfingers, building6008VendingMachine.getItem("B"));
		assertEquals(milkyWay, building6008VendingMachine.getItem("C"));
		assertEquals(fifthAvenue, building6008VendingMachine.getItem("D"));
	}

	/**
	 * testing that an item was removed of the {@link VendingMachine} class.
	 */
	@Test
	public final void testRemoveItemGood() {
		building6008VendingMachine.addItem(reeseCup, "A");
		building6008VendingMachine.addItem(butterfingers, "B");
		building6008VendingMachine.addItem(milkyWay, "C");
		building6008VendingMachine.addItem(fifthAvenue, "D");
		
		building6008VendingMachine.removeItem("B");
		assertEquals(null, building6008VendingMachine.getItem("B"));
		
	}

	/**
	 * Testing the return part of Removeitem, is working correctly of the {@link VendingMachine} class.
	 */
	@Test
	public final void testRemoveItemGoodReturn() {
		building6008VendingMachine.addItem(reeseCup, "A");
		building6008VendingMachine.addItem(butterfingers, "B");
		building6008VendingMachine.addItem(milkyWay, "C");
		building6008VendingMachine.addItem(fifthAvenue, "D");
		
		VendingMachineItem temp = building6008VendingMachine.removeItem("B");
		
		assertEquals(butterfingers, temp);

		
	}

	/**
	 * Testing filling slots, removing an item, and replacing item with another kind of the {@link VendingMachine} class.
	 */
	@Test
	public final void testRemoveItemAddAnother() {
		building6008VendingMachine.addItem(reeseCup, "A");
		building6008VendingMachine.addItem(butterfingers, "B");
		building6008VendingMachine.addItem(milkyWay, "C");
		building6008VendingMachine.addItem(fifthAvenue, "D");
		
		building6008VendingMachine.removeItem("B");
		building6008VendingMachine.addItem(payDay, "B");
		
		assertEquals(payDay, building6008VendingMachine.getItem("B"));
		
	}

	/**
	 * Testing the removal of an empty item of the {@link VendingMachine} class.
	 */
	@Test
	public final void testRemoveItemEnempty() {
		try {
			building6008VendingMachine.removeItem("B");
	        fail(); // if we got here, no exception was thrown, which is bad
	    } 
	    catch (Exception e) {
	        final String expected = "Slot B is empty -- cannot remove item";
	        assertEquals( expected, e.getMessage());
	    }
	}

	/**
	 * Testing the removal of an invalid item of the {@link VendingMachine} class.
	 */
	@Test
	public final void testRemoveItemInvalid() {
		
		try {
			building6008VendingMachine.removeItem("E");
	        fail(); // if we got here, no exception was thrown, which is bad
	    } 
	    catch (Exception e) {
	        final String expected = "Invalid code for vending machine item";
	        assertEquals( expected, e.getMessage());
	    }
	}

	/**
	 * This test makes sure you an insert money of the {@link VendingMachine} class.
	 */
	@Test
	public final void testInsertMoneyPosAmount() {
		building6008VendingMachine.insertMoney(1.00);
		assertEquals(1.00, building6008VendingMachine.getBalance(), 0.0001);
	}

	/**
	 * This test makes sure if you insert money twice, the balance adds correctly of the {@link VendingMachine} class.
	 */
	@Test
	public final void testInsertMoneyPosAmountTwice() {
		building6008VendingMachine.insertMoney(1.00);
		building6008VendingMachine.insertMoney(0.50);
		assertEquals(1.50, building6008VendingMachine.getBalance(), 0.0001);
	}

	/**
	 * this test verify that the exception of adding negative numbers is working of the {@link VendingMachine} class.
	 */
	@Test
	public final void testInsertMoneyNegAmount() {
		
		try {
			building6008VendingMachine.insertMoney(-1.00);
	        fail(); // if we got here, no exception was thrown, which is bad
	    } 
	    catch (Exception e) {
	        final String expected = "Invalid amount.  Amount must be >= 0";
	        assertEquals( expected, e.getMessage());
	    }
	}

	/**
	 * This test makes sure that get Balance returns the correct amount of the {@link VendingMachine} class.
	 */
	@Test
	public final void testGetBalance() {
		building6008VendingMachine.insertMoney(1.00);
		assertEquals(1.00, building6008VendingMachine.getBalance(), 0.0001);
	}

	/**
	 * This test states that a valid purchase has happened of the {@link VendingMachine} class.
	 */
	@Test
	public final void testMakePurchaseGoodReturn() {
		building6008VendingMachine.addItem(reeseCup, "A");
		building6008VendingMachine.insertMoney(.750);
		boolean temp = building6008VendingMachine.makePurchase("A");
		
		assertEquals(true, temp);
	}

	/**
	 * This test verify that there is enough money to buy the item of the {@link VendingMachine} class.
	 */
	@Test
	public final void testMakePurchaseGoodBalance() {
		building6008VendingMachine.addItem(reeseCup, "A");
		building6008VendingMachine.insertMoney(.750);
		building6008VendingMachine.makePurchase("A");
		
		assertEquals(0.00, building6008VendingMachine.getBalance(), 0.0001);
	}

	/**
	 * This test verify that the purchased item has been remove of the {@link VendingMachine} class.
	 */
	@Test
	public final void testMakePurchaseGoodItemRemoved() {
		building6008VendingMachine.addItem(reeseCup, "A");
		building6008VendingMachine.insertMoney(.750);
		building6008VendingMachine.makePurchase("A");
		
		assertEquals(null, building6008VendingMachine.getItem("A"));
	}

	/**
	 * This test is when there is not enough money in the machine of the {@link VendingMachine} class.
	 */
	@Test
	public final void testMakePurchaseBadBalance() {
		building6008VendingMachine.addItem(reeseCup, "A");
		building6008VendingMachine.insertMoney(0.50);
		boolean temp = building6008VendingMachine.makePurchase("A");
		
		assertEquals(false, temp);
	}

	/**
	 * This test is making sure you cannot buy from an empty slot of the {@link VendingMachine} class.
	 */
	@Test
	public final void testMakePurchaseBadSelection() {
		building6008VendingMachine.addItem(reeseCup, "A");
		building6008VendingMachine.insertMoney(0.750);
		boolean temp = building6008VendingMachine.makePurchase("B");
		
		assertEquals(false, temp);
	}
	
	/**
	 * This test is making sure you cannot buy from an invalid slot of the {@link VendingMachine} class.
	 */
	@Test
	public final void testMakePurchaseInvalidSelection() {
		building6008VendingMachine.addItem(reeseCup, "A");
		building6008VendingMachine.insertMoney(0.750);
		
		try {
			building6008VendingMachine.makePurchase("E");
	        fail(); // if we got here, no exception was thrown, which is bad
	    } 
	    catch (Exception e) {
	        final String expected = "Invalid code for vending machine item";
	        assertEquals( expected, e.getMessage());
	    }
	}
	/**
	 * This is verifying, you cannot purchase from the same slot twice in a row of the {@link VendingMachine} class.
	 * This is true because each slot only has one item
	 */
	@Test
	public final void testMakePurchaseOfSameItem() {
		building6008VendingMachine.addItem(reeseCup, "A");
		building6008VendingMachine.insertMoney(.750);
		boolean temp = building6008VendingMachine.makePurchase("A");
		
		temp = building6008VendingMachine.makePurchase("A");
		assertEquals(false, temp);
	}

	/**
	 * This is making sure that the change is the right amount of the {@link VendingMachine} class.
	 */
	@Test
	public final void testReturnChangeRightAmount() {
		building6008VendingMachine.addItem(reeseCup, "A");
		building6008VendingMachine.insertMoney(1.750);
		building6008VendingMachine.makePurchase("A");
		double temp = building6008VendingMachine.returnChange();
		
		assertEquals(1.00, temp, .0001);
	}

	/**
	 * This is making sure that the Return change set the Balance back to 0.00 of the {@link VendingMachine} class.
	 */
	@Test
	public final void testReturnChangeBalanceSet() {
		building6008VendingMachine.addItem(reeseCup, "A");
		building6008VendingMachine.insertMoney(1.750);
		building6008VendingMachine.makePurchase("A");
		building6008VendingMachine.returnChange();
		
		assertEquals(0.00, building6008VendingMachine.getBalance(), 0.0001);
	}

}
