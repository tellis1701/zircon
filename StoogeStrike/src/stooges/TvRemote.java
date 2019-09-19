package stooges;

import api.Type;

public class TvRemote extends AbsStooge
{
	public TvRemote()
	{
		//TODO the balancing of these stats
		super(17.99, 45, Type.ELECTRONIC, 55);
	}

	@Override
	public String getPortrait() 
	{
		return    "|¯¯¯¯¯¯¯¯¯|\n"
				+ "|    ^    |\n"
				+ "|   < >   |\n"
				+ "|    v    |\n"
				+ "|         |\n"
				+ "|  ^   ^  |\n"
				+ "| VOL CHA |\n"
				+ "|  v   v  |\n"
				+ "|         |\n"
				+ "|  1 2 3  |\n"
				+ "|  4 5 6  |\n"
				+ "|  7 8 9  |\n"
				+ "|    0    |\n"
				+ " ¯¯¯¯¯¯¯¯¯ \n";
	}
	
}
