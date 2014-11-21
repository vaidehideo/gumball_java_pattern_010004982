

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GumballMachineTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class GumballMachineTest
{
    private GumballMachine gumballM1;
    private GumballMachine gumballM2;
    /**
     * Default constructor for test class GumballMachineTest
     */
    public GumballMachineTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        gumballM1 = new GumballMachine(3);
        gumballM2 = new GumballMachine(5);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    /*My Test Cases*/
    
    @Test
    public void testIdealCase_010004982()
    {
        gumballM1.insertQuarter();
        gumballM1.insertDime();
        gumballM1.insertNickel();
        gumballM1.insertDime();
        assertEquals(3,gumballM1.count);
        assertEquals(false,gumballM1.isGumballInSlot());
        gumballM1.turnCrank();
        assertEquals(2,gumballM1.count);
        assertEquals(true,gumballM1.isGumballInSlot());
    }

    @Test
    public void testWithLessAmount_010004982()
    {
        gumballM1.insertDime();
        gumballM1.insertNickel();
        assertEquals(3,gumballM1.count);
        assertEquals(false,gumballM1.isGumballInSlot());
        gumballM1.turnCrank();
        assertEquals(3,gumballM1.count);
        assertEquals(false,gumballM1.isGumballInSlot());
    }

    @Test
    public void testTake2Gumballs_010004982()
    {
        gumballM1.insertQuarter();
        gumballM1.insertQuarter();
        assertEquals(3,gumballM1.count);
        assertEquals(false,gumballM1.isGumballInSlot());
        gumballM1.turnCrank();
        assertEquals(2,gumballM1.count);
        assertEquals(true,gumballM1.isGumballInSlot());
        gumballM1.insertQuarter();
        gumballM1.insertQuarter();
        gumballM1.turnCrank();
        assertEquals(1,gumballM1.count);
        assertEquals(true,gumballM1.isGumballInSlot());
        gumballM1.takeGumballFromSlot();
        assertEquals(false,gumballM1.isGumballInSlot());
    }

    @Test
    public void testNoGumballState_010004982()
    {
        gumballM1.insertQuarter();
        gumballM1.insertQuarter();
        assertEquals(3,gumballM1.count);
        assertEquals(false,gumballM1.isGumballInSlot());
        gumballM1.turnCrank();
        assertEquals(2,gumballM1.count);
        assertEquals(true,gumballM1.isGumballInSlot());
        gumballM1.insertQuarter();
        gumballM1.insertQuarter();
        gumballM1.turnCrank();
        assertEquals(1,gumballM1.count);
        assertEquals(true,gumballM1.isGumballInSlot());
        gumballM1.takeGumballFromSlot();
        assertEquals(false,gumballM1.isGumballInSlot());
        gumballM1.insertQuarter();
        gumballM1.insertQuarter();
        gumballM1.turnCrank();
        assertEquals(0,gumballM1.count);
        assertEquals(true,gumballM1.isGumballInSlot());
        gumballM1.turnCrank();
        assertEquals(0,gumballM1.count);
        gumballM1.takeGumballFromSlot();
        assertEquals(false,gumballM1.isGumballInSlot());
        gumballM1.insertNickel();
    }

    @Test
    public void testReturnchange_010004982()
    {
        gumballM1.insertNickel();
        gumballM1.insertDime();
        assertEquals(3,gumballM1.count);
        assertEquals(false,gumballM1.isGumballInSlot());
        gumballM1.ejectQuarter();
        assertEquals(3,gumballM1.count);
        assertEquals(false,gumballM1.isGumballInSlot());
        gumballM1.insertQuarter();
        gumballM1.insertQuarter();
        gumballM1.turnCrank();
        assertEquals(2,gumballM1.count);
        assertEquals(true,gumballM1.isGumballInSlot());
        gumballM1.refill(5);
        assertEquals(5,gumballM1.count);
        assertEquals(true,gumballM1.isGumballInSlot());
    }
    
    /*Friend's test cases*/
    
    @Test
    public void testReturnsChange()
    {
        gumballM2.insertQuarter();
        gumballM2.insertQuarter();
        gumballM2.insertDime();
        gumballM2.insertNickel();
        assertEquals(5,gumballM2.count);        
        gumballM2.turnCrank();
        assertEquals(4,gumballM2.count);
        assertEquals(true,gumballM2.isGumballInSlot());
        gumballM2.takeGumballFromSlot();
        assertEquals(false,gumballM2.isGumballInSlot());
    }

    @Test
    public void twiceInsertAndCrank()
    {
        gumballM2.insertQuarter();
        gumballM2.insertQuarter();
        assertEquals(5,gumballM2.count);     
        gumballM2.turnCrank();
        assertEquals(4,gumballM2.count);     
        gumballM2.insertQuarter();
        gumballM2.insertQuarter();
        assertEquals(4,gumballM2.count);          
        gumballM2.turnCrank();
        assertEquals(3,gumballM2.count);  
        assertEquals(true,gumballM2.isGumballInSlot());
        gumballM2.takeGumballFromSlot();
        assertEquals(false,gumballM2.isGumballInSlot());
    }

    @Test
    public void testRemembersInsertedAmt()
    {
        gumballM2.insertQuarter();
        assertEquals(5,gumballM2.count);    
        gumballM2.turnCrank();
        assertEquals(5,gumballM2.count);    
        gumballM2.insertQuarter();
        assertEquals(5,gumballM2.count);    
        gumballM2.turnCrank();
        assertEquals(4,gumballM2.count);    
        assertEquals(true,gumballM2.isGumballInSlot());
        gumballM2.takeGumballFromSlot();
        assertEquals(false,gumballM2.isGumballInSlot());
    }

    @Test
    public void testInsertionWhenInventoryIsZero()
    {
        gumballM2.insertQuarter();
        gumballM2.insertQuarter();
        assertEquals(5,gumballM2.count);
        gumballM2.turnCrank();
        assertEquals(4,gumballM2.count);
        gumballM2.insertQuarter();
        gumballM2.insertQuarter();
        assertEquals(4,gumballM2.count);
        gumballM2.turnCrank();
        assertEquals(3,gumballM2.count);
        gumballM2.insertQuarter();
        gumballM2.insertQuarter();
        assertEquals(3,gumballM2.count);
        gumballM2.turnCrank();
        assertEquals(2,gumballM2.count);
        gumballM2.insertQuarter();
        gumballM2.insertQuarter();
        assertEquals(2,gumballM2.count);
        gumballM2.turnCrank();
        assertEquals(1,gumballM2.count);
        gumballM2.insertQuarter();
        gumballM2.insertQuarter();
        assertEquals(1,gumballM2.count);
        gumballM2.turnCrank();
        assertEquals(0,gumballM2.count);
        assertEquals(true,gumballM2.isGumballInSlot());
        gumballM2.takeGumballFromSlot();
        assertEquals(false,gumballM2.isGumballInSlot());
        gumballM2.insertNickel();
        gumballM2.turnCrank();
        assertEquals(0,gumballM2.count);
    }

    

    @Test
     public void testRefill()
    {
        gumballM2.insertQuarter();
        gumballM2.insertQuarter();
        assertEquals(5,gumballM2.count);
        gumballM2.turnCrank();
        assertEquals(4,gumballM2.count);
        gumballM2.insertQuarter();
        gumballM2.insertQuarter();
        assertEquals(4,gumballM2.count);
        gumballM2.turnCrank();
        assertEquals(3,gumballM2.count);
        assertEquals(true,gumballM2.isGumballInSlot());
        gumballM2.takeGumballFromSlot();
        assertEquals(false,gumballM2.isGumballInSlot());
        gumballM2.insertQuarter();
        gumballM2.insertQuarter();
        assertEquals(3,gumballM2.count);
        gumballM2.turnCrank();
        assertEquals(2,gumballM2.count);
        gumballM2.insertQuarter();
        gumballM2.insertQuarter();
        assertEquals(2,gumballM2.count);
        gumballM2.turnCrank();
        assertEquals(1,gumballM2.count);
        assertEquals(true,gumballM2.isGumballInSlot());
        gumballM2.takeGumballFromSlot();
        assertEquals(false,gumballM2.isGumballInSlot());
        assertEquals(1,gumballM2.count);
        gumballM2.refill(4);
        assertEquals(4,gumballM2.count);
        gumballM2.insertQuarter();
        gumballM2.insertNickel();
        gumballM2.insertQuarter();
        assertEquals(4,gumballM2.count);
        gumballM2.turnCrank();
        assertEquals(3,gumballM2.count);
        assertEquals(3,gumballM2.count);

        gumballM2.turnCrank();
        assertEquals(3,gumballM2.count);        
        assertEquals(true,gumballM2.isGumballInSlot());
        gumballM2.takeGumballFromSlot();
        assertEquals(false,gumballM2.isGumballInSlot());
    }
}





