package ui;

import java.util.ArrayList;
import java.util.Scanner;

import api.Stooge;

public class Player 
{
	private ArrayList<Stooge> stooges;
	private String name;
	private double money;
	
	//TODO We may want to make another constructor for enemy players that sets name and stooges and such.
	
	/**
	 * This is the first fighter in your list that will come out at the start of battle.
	 */
	private Stooge fighter;
	
	//TODO add something that lets ya store items. Maybe have different lists for potions vs power ups or something.
	
	/**
	 * 
	 * @param givenName
	 * 	The name of the player at construction
	 */
	public Player(String givenName)
	{
		stooges = new ArrayList<Stooge>();
		name = givenName;
		money = 0;
		fighter = null;
	}
	
	/**
	 * Constructor without specifiying name
	 */
	public Player()
	{
		stooges = new ArrayList<Stooge>();
		name = null;
		money = 0;
		fighter = null;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String givenName)
	{
		name = givenName;
	}
	
	public double getMoney()
	{
		return money;
	}
	
	public void addMoney(double d)
	{
		money += d;
	}
	
	public void addStooge(Stooge s)
	{
		stooges.add(s);
		
		//This is where we decided to set the default fighter if you got one.
		if(stooges.size() == 1)
		{
			fighter = stooges.get(0);
		}
	}
	
	public void chooseFighter()
	{
		//Maybe do a private that lets you pick from your list for anything, even beyond fighter.
		//TODO just that this picking from a list logic will likely be used more, even for moves maybe and stuff.
		if(stooges.size() > 0)
		{
			for(int i = 0; i < stooges.size(); i+=1)
			{
				System.out.println((i) + ") " + stooges.get(i).getName());
			}
			
			int choice = 0;
			
			Scanner scan = new Scanner(System.in);
			boolean done = false;
			while(!done)
			{
				System.out.print("Choose fighter: ");
				choice = scan.nextInt();	//TODO do I want exception handling here?
				
				if(choice < stooges.size())
				{
					done = true;
				}
				else
				{
					System.out.println("Not a valid input");
				}
			}
			
			fighter = stooges.get(choice);
		}
	}
	
	public Stooge getFighter()
	{
		return fighter;
	}
}
