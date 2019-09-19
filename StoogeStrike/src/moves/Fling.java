package moves;

import api.Stooge;
import api.Type;

public class Fling extends AbsMove
{

	public Fling()
	{
		//TODO Okay... do we want the type of fling to depend on the stooge that is using the move?
		//If so, we could have the type of the stooge be declared in the Fling constructor
		super("Fling", Type.NEUTRAL);
	}

	@Override
	public void doAction(Stooge enemy) 
	{
		System.out.println("Hyaaaaaa");
		enemy.takeDamage(22);
		//TODO how to designate that you are attacking another stooge?
		//We need to add methods that take damage and get health.
	}

}
