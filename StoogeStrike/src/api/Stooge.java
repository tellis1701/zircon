package api;

import java.util.ArrayList;

public interface Stooge 
{
	void omaeWaMouShindeiru(Stooge s);
	void selectMove();

	ArrayList<Move> getMoves();
	void addMove(Move m);
	
	double getValue();
	double getCapRate();
	
	Status getStatus();
	void setStatus(Status givenStatus);
	
	Type getType();
	
	String getName();
	
	public int getLevel();
	public int getExp();
	
	public void gainExp(double experience);
	public void gainExp();
	public void levelUp();
	
	public int getHealth();
	public void takeDamage(int d);
	
	public String getPortrait();
	public ArrayList<String> getPortraitStrings();
	
	public void setEnemy(Stooge s);
	
}