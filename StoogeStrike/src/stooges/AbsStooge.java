package stooges;

import java.util.ArrayList;
import java.util.Scanner;

import api.Move;
import api.Status;
import api.Stooge;
import api.Type;

public abstract class AbsStooge implements Stooge
{
	private ArrayList<Move> moves;
	
	//TODO what if we want moves that are self changing... 
	//would we make a different interface and abstract class and have select move be a little different to accomodate?
	
	private double value;
	private double capRate;
	private Status status;
	private Type type;
	private int level;
	private int exp;
	private int health;
	private String name;
	
	/**
	 * This is an instance of the enemy of the current stooge
	 * TODO methods that check if the enemy is dead... set the enemy stooge and such
	 * TODO would this implementation be in a different class... or should each stooge be able to do it?
	 */
	private Stooge enemy;
	
	/*
	 * Constructor for creating a stooge at NEUTRAL
	 */
	protected AbsStooge(double givenValue, double givenCapRate, Type givenType, int givenHealth)
	{
		moves = new ArrayList<Move>();
		value = givenValue;
		capRate = givenCapRate;
		status = Status.NEUTRAL;
		type = givenType;
		level = 1;
		health = givenHealth;
		enemy = null;
		
		/**
		 * We did this part because we don't want stooges to have names. They aren't real.
		 * its name must be functional
		 */
		name = this.getClass().getSimpleName();
		
	}
	
	/*
	 * Constructor for creating a stooge with specified status
	 */
	protected AbsStooge(double givenValue, double givenCapRate, Status givenStatus, Type givenType, int givenHealth)
	{
		moves = new ArrayList<Move>();
		value = givenValue;
		capRate = givenCapRate;
		status = givenStatus;
		type = givenType;
		level = 1;	
		health = givenHealth;
		enemy = null;
		
		/**
		 * We did this part because we don't want stooges to have names. They aren't real.
		 * its name must be functional
		 */
		name = this.getClass().getSimpleName();

	}
	
	/*
	 * Constructor for creating a stooge with a specified level
	 */
	protected AbsStooge(double givenValue, double givenCapRate, Type givenType, int givenHealth, int givenLevel)
	{
		moves = new ArrayList<Move>();
		value = givenValue;
		capRate = givenCapRate;
		status = Status.NEUTRAL;
		type = givenType;
		level = givenLevel;
		health = givenHealth;
		enemy = null;
		
		/**
		 * We did this part because we don't want stooges to have names. They aren't real.
		 * its name must be functional
		 */
		name = this.getClass().getSimpleName();
		
	}
	
	public String getName()
	{
		return name;
	}
	
	public void selectMove()
	{
		if(moves.size() > 0)
		{
			for(int i = 0; i < moves.size(); i+=1)
			{
				System.out.println((i) + ") " + moves.get(i).getName());
			}
			
			int choice = 0;
			
			Scanner scan = new Scanner(System.in);
			boolean done = false;
			while(!done)
			{
				System.out.print("Choose action: ");
				choice = scan.nextInt();	//TODO do I want exception handling here?
				
				if(choice < moves.size())
				{
					done = true;
				}
				else
				{
					System.out.println("Not a valid input");
				}
			}
			
			moves.get(choice).doAction(enemy);
		}
	}
	
	public ArrayList<Move> getMoves() 
	{
		return moves;
	}
	
	public void addMove(Move m)
	{
		moves.add(m);
	}
	
	//TODO
	public void omaeWaMouShindeiru(Stooge s)
	{
		
	}
	
	public double getValue()
	{
		return value;
	}
	
	//TODO do we actually need this method? 
	//The other getter methods will likely be displayed to the gamer, but not this one i would think
	public double getCapRate()
	{
		return capRate;
	}
	
	public Status getStatus()
	{
		return status;
	}
	
	public void setStatus(Status givenStatus)
	{
		status = givenStatus;
	}
	
	public Type getType()
	{
		return type;
	}
	
	public int getLevel()
	{
		return level;
	}
	
	public int getExp()
	{
		return exp;
	}
	
	public int getHealth()
	{
		return health;
	}
	
	//TODO implementation if the stooge gains enough exp to level up
	//Manuelly add exp
	public void gainExp(double experience)
	{
		exp += experience;
	}
	
	//Gains the exp equivalent to 2 ^ the enemy's level
	//Only should be called if the enemy stooge dies.
	public void gainExp()
	{
		exp += enemy.getLevel();
	}
	
	//This method checks to see if the exp gained is enough for a level change.
	//Does levels up if so, does nothing if not
	//Planning on calling this whenever exp is gained
	//TODO can we make this private?
	//		and do we want this implementation to be different for each stooge?
	//TODO this code is the nastyiest thing i have ever seen. How could I write this better?
	//TODO change numbers to
	//		"Scale the exp to level up to be the amount of battles at the same level be the next prime number. Say to go from
	//1 ---> 2 you would need 2 battles
	//2--->3 you would need 3 battles
	//3--->4... 5 battles
	//4---> 5... 7 battles
	//5--->6... 11 battles
	protected void adjustLevel()
	{
		if(exp >= 10 && level == 1)
		{
			levelUp();
		}
		if(exp >= 25 && level == 2)
		{
			levelUp();
		}
		if(exp >= 50 && level == 3)
		{
			levelUp();
		}
		if(exp >= 100 && level == 4)
		{
			levelUp();
		}
		if(exp >= 175 && level == 5)
		{
			levelUp();
		}
		if(exp >= 300 && level == 6)
		{
			levelUp();
		}
		if(exp >= 500 && level == 7)
		{
			levelUp();
		}
		if(exp >= 750 && level == 8)
		{
			levelUp();
		}
		if(exp >= 1250 && level == 9)
		{
			levelUp();
		}
		if(exp >= 2000 && level == 10)
		{
			levelUp();
		}
		
	}
	
	//TODO implementation to gain a move if the level is right
	//I think this could be an abstract method deal because each stooge would likely gain moves
	//at different rates.
	public void levelUp()
	{
		level += 1;
	}
	
	//TODO Implementation for if the stooge dies
	public void takeDamage(int d)
	{
		health -= d;
	}
	
	public void setEnemy(Stooge s)
	{
		enemy = s;
	}
	
	//This method relies on the use of \n when creating the portraits.
	//It seems like the scanner sees that as a new line and that is how we may parse into and array.
	public ArrayList<String> getPortraitStrings()
	{
		ArrayList<String> ret = new ArrayList<>();
		String portrait = getPortrait();
		Scanner scan = new Scanner(portrait);
		while(scan.hasNextLine())
		{
			ret.add(scan.nextLine());
		}
		return ret;
	}
	
	

}
