package api;

public interface Move 
{
	void doAction(Stooge enemy);
	String getName();
	Type getType();
}
