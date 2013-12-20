/**
 * TestRover
 * 
 * A Test class for the InputRover class
 * Prints out intermediate results after 
 * calls to track the rover
 * 
 */
package rover;

/**
 * @author Duane Clark
 *
 */
public class TestRover {
	
	InputRover iRover = null;
	
	// Create with limits
	TestRover( String limits )
	{
		String printStr;
		iRover = new InputRover( limits );
		if ( iRover.getLastErrorCode() == 0 )
		{
			printStr = "New rover with limits: " + limits;
		}
		else
		{
			printStr = "New rover creation failed: " + iRover.getLastError();
		}
		System.out.println(printStr);
		return;
	}
	
	// Locate the rover
	public boolean setRover( String loc )
	{
		boolean ret = iRover.init(loc);
		String startLoc;
		if ( ret ) startLoc = "Rover starting at: " + loc;
		else startLoc = "Error placing rover: " + iRover.getLastError();
		System.out.println(startLoc);
		return ret;
	}
	
	// Execute commands
	public boolean commandRover( String commands )
	{
		boolean ret = iRover.execute(commands);
		String comResult;
		if ( ret ) comResult = "Commands successful!";
		else comResult = "Error during command execution: " + iRover.getLastError();
		System.out.println(comResult);
		return ret;
	}
	
	public String getLocation()
	{
		return iRover.getLocation();
	}
	
	public void printResults()
	{
		String outLoc = iRover.getLocation();
		System.out.println("Final location is:");
		System.out.println(outLoc);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
