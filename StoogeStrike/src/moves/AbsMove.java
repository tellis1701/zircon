package moves;

import api.Move;
import api.Type;

public abstract class AbsMove implements Move 
{
	String name;
	Type type;
	
	protected AbsMove(String givenName, Type givenType)
	{
		name = givenName;
		type = givenType;
	}

	@Override //TODO add override to other classes?
	public String getName() 
	{
		return name;
	}

	@Override
	public Type getType() 
	{
		return type;
	}
	

}
