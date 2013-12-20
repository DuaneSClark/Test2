/**
 * InputRover
 * 
 * Adds specific input processing to wrap a base rover
 * 
 */
package rover;

/**
 * @author Duane Clark
 *
 */
public class InputRover {
	
	int lastError = 0;
	int x = 0;
	int y = 0;
	BaseRover rover = null;
	
	static String errors[] = { "No Error",
		"Invalid creation limit string.",
		"Invalid starting location string.",
		"Invalid x position.",
		"Invalid y position.",
		"Invalid facing.",
		"Rover not created.",
		"Move off plateau not allowed.",
		"Invalid command." };
	
	// Create using limits string
	InputRover( String limits )
	{
		if ( (limits == null) || (limits.trim().length() == 0) )
		{
			lastError = 1;
		}
		else
		{
			int off = limits.indexOf(" ");
			if ( (off == -1) || (off == (limits.length() - 1) ) )
			{
				lastError = 1;
			}
			else
			{
				String strX = limits.substring(0, off);
				String strY = limits.substring(off+1);
				x = Integer.parseInt(strX);
				y = Integer.parseInt(strY);
				if ( x < 0 ) 
				{
					x = 0;
					lastError = 1;
				}
				if ( y < 0 )
				{
					y = 0;
					lastError = 1;
				}
			}
		}
		
	}
	
	// Initialize with the starting location string
	public boolean init( String loc )
	{
		if ( (loc == null) || (loc.trim().length() == 0) )
		{
			lastError = 2;
			return false;
		}
		
		int off = loc.indexOf(" ");
		if ( (off == -1) || (off == (loc.length() - 1) ) )
		{
			lastError = 2;
			return false;
		}
		
		String strX = loc.substring(0, off);
		String strYF = loc.substring(off+1);
		
		off = strYF.indexOf(" ");
		if ( (off == -1) || (off == (strYF.length() - 1) ) )
		{
			lastError = 2;
			return false;
		}
		
		String strY = strYF.substring(0, off);
		String strF = strYF.substring(off+1);
		
		int curX = Integer.parseInt(strX);
		if ( curX < 0 )
		{
			lastError = 3;
			return false;
		}
		
		int curY = Integer.parseInt(strY);
		if ( curY < 0 )
		{
			lastError = 4;
			return false;
		}
		
		int curF;
		if ( strF.equalsIgnoreCase("N") ) curF = 0;
		else if ( strF.equalsIgnoreCase("E") ) curF = 1;
		else if ( strF.equalsIgnoreCase("S") ) curF = 2;
		else if ( strF.equalsIgnoreCase("W") ) curF = 3;
		else 
		{
			lastError = 5;
			return false;
		}
		
		rover = new BaseRover( x, y, curX, curY, curF );
		
		lastError = 0;
		return true;
	}

	// Execute a command string
	public boolean execute( String commands )
	{
		if ( rover == null )
		{
			lastError = 6;
			return false;
		}
		
		for( int i = 0; i < commands.length(); i++ )
		{
			char com = commands.charAt(i);
			if ( 'M' == com )
			{
				if ( !rover.move() )
				{
					lastError = 7;
					return false;
				}
			}
			else if ( 'L' == com ) rover.faceLeft();
			else if ( 'R' == com ) rover.faceRight();
			else
			{
				lastError = 8;
				return false;
			}
		}

		lastError = 0;
		return true;
	}
	
	// Return the current location as a string
	public String getLocation()
	{
		
		char[] facings = { 'N', 'E', 'S', 'W' };
		String retStr = "Unknown";
		
		if ( rover == null )
		{
			lastError = 6;
			return "";
		}
		
		int curX = rover.getX();
		int curY = rover.getY();
		int curF = rover.getFacing();
		
		retStr = "" + curX + " " + curY + " " + facings[curF];
		
		return retStr;
	}
	
	// Return current error code
	public int getLastErrorCode()
	{
		return lastError;
	}
	
	// Return the last error as a string
	public String getLastError()
	{
		String ret;
		ret = errors[lastError];
		return ret;
	}
}
