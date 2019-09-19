package ui;

import java.util.ArrayList;

import api.Stooge;
import stooges.Doritos;
import stooges.Plunger;
import stooges.TvRemote;

public class Tests 
{
	public static void main(String[] args)
	{
		Doritos dor = new Doritos();		
//		dor.selectMove();
//		System.out.println(dor.getPortrait());
//		
////		System.out.println("¯¯¯¯¯¯ııııı ≤≤≤¯¯¯¯˜ı◊Ç⁄€‹›ﬁﬂﬁ›‹‹€€⁄¡!!›ﬁﬂ‡°·‚————–––——-----±±=≠≠‘«πøˆ");
//		//   ¡™£¢∞§¶•ªº–≠≠≠≠±±|’”∏Øˆ¨Áˇ‰ŒÅÍÎÏ˝ÔÒÚ»»»»»»««««««\\\\|||| 
		Game game = new Game();
		
		Plunger plunge = new Plunger();
//		System.out.println(plunge.getPortrait());
		Stooge ya = new TvRemote();
		game.getBattleScreen(plunge, ya);
		System.out.println(game.getBattleScreen(plunge, ya));
		System.out.println(game.getBattleScreen(ya, dor));
		System.out.println(game.getBattleScreen(dor, ya));
		System.out.println(game.getBattleScreen(dor, plunge));
		System.out.println(ya.getHealth());
		dor.setEnemy(ya);
		dor.selectMove();
		System.out.println(ya.getHealth());
		



//		System.out.println(ya.getPortrait());
//		ArrayList<String> portraitStrings = ya.getPortraitStrings();
//		for(String s : portraitStrings)
//		{
//			System.out.print(s);
////			System.out.println(s);
//		}
//		Player yeet = new Player("yeet boy");
//		yeet.addStooge(dor);
//		yeet.addStooge(ya);
//		
//		yeet.chooseFighter();
//		System.out.println(yeet.getFighter().getName());
	}

}
