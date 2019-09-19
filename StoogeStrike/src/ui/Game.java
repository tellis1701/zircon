package ui;

import java.util.ArrayList;
import java.util.Scanner;

import api.Stooge;
import api.Type;
import stooges.TvRemote;
public class Game
{
	public static void main(String[] args)
	{
		//TODO do we really need to insantiate game? Can't we just instatiate a player?
		Player main = new Player();
		System.out.println(getTitle());
		System.out.println("Welcome too STOOGE STRIKE!!!");
		System.out.println("You are about to embark on an adventure that will test your endurance, patience, perseverance, appetite, and bladder.");

		String name = null;
		Scanner scan = new Scanner(System.in);
		boolean done = false;
		while(!done)
		{
			System.out.println("What is your name?");
			name = scan.nextLine();

			System.out.println("Is this your name? ---> " + name + " (y/n)");
			//When we change this to next instead of nextLine, it fails. why?
			String response = scan.nextLine();
			if(response.equals("y"))
			{
				done = true;
			}
		}

		main.setName(name);

		System.out.println("So you think you're a hot shot, " + main.getName() +"?\nI'm just kidding. Let's start the game.");
		System.out.println(getTransition());

		System.out.println("...");
		System.out.println("*beep beep*  *beep beep*  *beep beep*");
		System.out.println("It's 10:30 in the morning. Your alarm is quick to let you know such.");
		System.out.println("\n*Yawwwwnnnn*\n");
		System.out.println("You wipe the eye boogers (some people call them crusties) from your eyes, revealing your perpetually messy room.");
		System.out.println("As your feet crunch a half open bag of Doritos, you hear the TV blaring a dramtic soap opera.\n");

		done = false;
		while(!done)
		{
			System.out.println("1) Try to change the channel 'cause this show ain't your jam");
			System.out.println("2) Eat some doritos - ur hungry");
			System.out.println("3) Go use the whiz palace... who wouldn't first thing in the morning?");
			int choice = scan.nextInt();

			//TV
			if(choice == 1)
			{
				System.out.println("You walk over to the TV and begin to underturn your entire room to find the remote.");
				System.out.println("You finally find the remote under a pile of clothes next to... some lotion?");
				System.out.println("Uh okay... this isn't awkward.\n");

				System.out.println("1) You begin to actually watch the soap opera. You're embarassed to feel that you actually want to leave it on.");
				System.out.println("2) Change that sucker to Drake & Josh because quality");
				System.out.println("3) Toss the remote back into the pile of unfolded laundry");

				choice = scan.nextInt();
				if(choice == 2)
				{
					System.out.println("You try to change the channel, but it won't budge.");
					System.out.println("You feel a light little shock - the remote must like soap operas.");
					System.out.println(getTransition());

					System.out.println("It's time FOR COMBAT!!!\n");
					TvRemote remote = new TvRemote();
					System.out.println(remote.getPortrait());
				}


			}
			//Doritos
			else if(choice == 2)
			{

			}
			//bathroom
			else if(choice == 3)
			{

			}
			else
			{
				System.out.println("Not a valid input. You're pretty bad at this.");
			}
		}
	}


	//TODO I think these methods below maybe should be in the Player class because the player is the one fighting?

	public void enterWildCombat(Stooge s)
	{
		//Took this out cause we didn't have an instance of you for the player
		//Instead does have in player class that way we can use that fighter instance
//		Stooge fighter = you.getFighter();

	}

	public void enterPlayerCombat(Player p)
	{

	}


	//TODO work on this a little
	public static String getTitle()
	{
		return    "|¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|\n"
				+ "|     ####      ##############        ####      ####         ####      ##########  |\n"
				+ "|   ##    ##           #            ###  ###  ###  ###     ###         #           |\n"
				+ "|  #       ##          #           ##      ####      ##    ##          #           |\n"
				+ "|  #                   #           #        ##        #    #    ####   #           |\n"
				+ "|   #                  #           ##      ####      ##    ##     #    #           |\n"
				+ "|    ##                #            ###  ###  ###  ###      ###  ##    #           |\n"
				+ "|     ####             #              ####      ####          ###      ##########  |\n"
				+ "|        ##            #                                               #           |\n"
				+ "|          #           #            ###        #####        #  #       #           |\n"
				+ "|           #          #           #  ##         #          # #        #           |\n"
				+ "|  ##       #          #           ###           #          ##         #           |\n"
				+ "|   ##    ##           #           #  #          #          # #        #           |\n"
				+ "|     ####             #           #   #       #####        #  #       ##########  |\n"
				+ "|__________________________________________________________________________________|\n";
	}

	public static String getTransition()
	{
		return   "                       \n"
				+"◊◊◊◊◊◊◊◊◊ SS ◊◊◊◊◊◊◊◊◊◊\n"
                +"                       \n";

	}

	/**
	 * Displays the fight between the two stooges.
	 * @param f
	 * 	The fighter, shown first
	 * @param e
	 * 	The enemy, shown second
	 * @return
	 * 	The display of the fight (level, health, status, and type?)
	 * Illegal
	 */
	public String getBattleScreen(Stooge f, Stooge e)
	{

		ArrayList<String> fighter = f.getPortraitStrings();
		ArrayList<String> enemy = e.getPortraitStrings();

		//Exception handling is new to me.
		//Is this good? TODO try catch block?
		//This exception means that the portraits aren't large enough
		if(fighter.size() < 4 || enemy.size() < 4)
		{
			throw new IllegalArgumentException("Stooge's Protraits are too small");
		}

		//This is very difficult with the white space and the use of arrays to split up the strings... but if it works it works!!!
		String ret = fighter.get(0) + " Level: " + f.getLevel() + getSpaces(20 - getNumDigits(f.getLevel())) + enemy.get(0) + " Level: " + e.getLevel() + "\n"
				   + fighter.get(1) + " Health: " + f.getHealth() + getSpaces(19 - getNumDigits(f.getHealth())) + enemy.get(1) + " Health: " + e.getHealth() + "\n"
				   + fighter.get(2) + " Status: " + f.getStatus() + getSpaces(19 - f.getStatus().toString().length()) + enemy.get(2) + " Status: " + e.getStatus() + "\n"
				   + fighter.get(3) + " Type: " + f.getType() + getSpaces(21 - f.getType().toString().length()) + enemy.get(3) + " Type: " + e.getType();

		for(int i = 4; i < Math.max(fighter.size(), enemy.size()); i+=1)
		{
			if(fighter.size() > i)
			{
				ret += "\n" + fighter.get(i);

				if(enemy.size() > i)
				{
					//28 is arbitrary. It is the amount of white space based on above ^^^
					ret += getSpaces(28) + enemy.get(i);
				}
			}
			else if(enemy.size() > i)
			{
				ret += "\n" + getSpaces(28 + fighter.get(0).length()) + enemy.get(i);
			}
		}
		return ret;

	}

	/**
	 * A helper method that will input whitespace bases on how many spaces you want
	 * @param x
	 * 	The amount of whitespace you want
	 * @return
	 * 	The whitespace as a string
	 */
	private static String getSpaces(int x)
	{
		String ret = "";
		for(int i = 0; i < x; i += 1)
		{
			ret += " ";
		}

		return ret;
	}

	/**
	 * A helper method that calculates how many digits a number may have
	 * @param x
	 * 	The number to be counter through
	 * @return
	 * 	The number of digits in the given number
	 */
	private static int getNumDigits(int x)
	{
		if(x == 0)
		{
			return 1;
		}
		int count = 0;
		while(x > 0)
		{
			x = x / 10;
			count +=1;
		}
		return count;
	}

}
