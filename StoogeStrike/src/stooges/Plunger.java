package stooges;

import api.Type;

public class Plunger extends AbsStooge
{

	//TODO do we want the status to be initially poisend?
	public Plunger() 
	{
		super(13.36, 80, Type.UTILITY, 75);
	}

	@Override
	public String getPortrait() 
	{
		String test = "     _     \n"
					+ "    |P|    \n"
					+ "    |L|    \n"
					+ "    |U|    \n"
					+ "    |N|    \n"
					+ "    |G|    \n"
					+ "   / E \\   \n"
					+ "  |  R  |  \n"
					+ "  ¯¯¯¯¯¯¯  \n";
		
		String test2 = "     -     \n"
					 + "    |P|    \n"
					 + "    |L|    \n"
					 + "    |U|    \n"
					 + "    |N|    \n"
					 + "    |G|    \n"
					 + "   | E |   \n"
				   	 + "  |  R  |  \n"
					 + "  -------  \n";
		
		return test;
	}

}
