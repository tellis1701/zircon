package stooges;

import api.Type;
import moves.Fling;

public class Doritos extends AbsStooge
{
	public Doritos() 
	{
		super(3.98, 50, Type.FOOD, 100);
		addMove(new Fling()); //TODO Is this how we want to initialize with a move?
	}

	@Override
	public String getPortrait() 
	{
		return    "-----------\n"
				+ "|         |\n"
				+ "|         |\n"
				+ "| Doritos |\n"
				+ "|         |\n"
				+ "|         |\n"
				+ "|         |\n"
				+ "-----------";
	}

	
}
