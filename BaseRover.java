/**
 * BaseRover 
 * 
 * A simple implementation of the basic functionality.
 * 
 */
package rover;

/**
 * @author Duane Clark
 *
 */
public class BaseRover {
	
	// Initialize all values to zero
	int limitX = 0;			// Maximum allowed values
	int limitY = 0;
	int currentX = 0;		// Current location
	int currentY = 0;
	int currentFacing = 0;	// 0 = North, 1 = East, 2 = South, 3 = West
	
	/*
	 * Require starting values to create.
	 */
	BaseRover( int maxX, int maxY, int startX, int startY, int facing )
	{
		// Validate inputs
		if ( maxX > 0 ) limitX = maxX;
		if ( maxY > 0 ) limitY = maxY;
		if ( (startX >= 0) && (startX <= limitX) ) 
		{
			currentX = startX;
		}
		if ( (startY >= 0) && (startY <= limitY) ) 
		{
			currentY = startY;
		}
		if ( (facing >= 0) && (facing < 4) ) 
		{
			currentFacing = facing;
		}
	}
	
	// Methods to execute commands
	public void faceRight()
	{
		if ( currentFacing == 3 ) currentFacing = 0;
		else currentFacing++;
	}
	
	public void faceLeft()
	{
		if ( currentFacing == 0 ) currentFacing = 3;
		else currentFacing--;
	}
	
	public boolean move()
	{
		boolean ret = true;
		
		switch( currentFacing )
		{
		case 0:		// North
			if ( currentY < limitY ) currentY++;
			else ret = false;
			break;
		case 1:		// East
			if ( currentX < limitX ) currentX++;
			else ret = false;
			break;
		case 2:		// South
			if ( currentY > 0 ) currentY--;
			else ret = false;
			break;
		case 3:		//West
			if ( currentX > 0 ) currentX--;
			else ret = false;
			break;
		default:	// Shouldn't happen!
			ret = false;
		}
		
		return ret;
	}
	
	// Methods to return current values
	public int getX()
	{
		return currentX;
	}
	
	public int getY()
	{
		return currentY;
	}
	
	public int getFacing()
	{
		return currentFacing;
	}
}
