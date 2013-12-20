/**
 * DefaultTest
 * 
 * JUnit test for the TestRover
 * 
 */
package rover;

import junit.framework.TestCase;

/**
 * @author Duane Clark
 *
 */
public class DefaultTest extends TestCase {

	/**
	 * @param name
	 */
	public DefaultTest(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	// Example test input
	public void testFirst()
	{
		String[] testInput = { "5 5", 
				"1 2 N", "LMLMLMLMM", 
				"3 3 E", "MMRMMRMRRM"};
		TestRover testRover = new TestRover( testInput[0] );
		testRover.setRover( testInput[1] );
		testRover.commandRover( testInput[2] );
		testRover.printResults();
		String res1 = testRover.getLocation();
		testRover.setRover( testInput[3] );
		testRover.commandRover( testInput[4] );
		testRover.printResults();
		assertTrue( "1 3 N".equals(res1) &&
				"5 1 E".equals(testRover.getLocation()) );
		return;
	}
	
	// Additional input test
	public void testSecond()
	{
		String[] testInput = { "5 7", 
				"1 3 N", "LMMLMLMMMMLMM", 
				"3 3 E", "MMRMMRMRRM"};
		TestRover testRover = new TestRover( testInput[0] );
		testRover.setRover( testInput[1] );
		testRover.commandRover( testInput[2] );
		testRover.printResults();
		String res1 = testRover.getLocation();
		testRover.setRover( testInput[3] );
		testRover.commandRover( testInput[4] );
		testRover.printResults();
		return;
	}

	/**
	 * Test method for {@link rover.TestRover#main(java.lang.String[])}.
	 *
	public void testMain() 
	{
		new DefaulTest("firstTest");
		return;
	}*/
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new DefaultTest("testFirst");
		new DefaultTest("testSecond");
		return;
	}	

}
