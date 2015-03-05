
public abstract class Path extends Tile{
	
	private int length; // this will be used to calculate the entrance and exit of the path
	int pos;
	
	/*
	 * Naming all the subclasses is done by using one direction using compass headings
	 * For example, the horizontal piece comes in from the west and exits the east; called StraightWE
	 * Instead of creating another subclass called StraightEW for the opposite direction, have a method called rotate which switches the
	 * entrance and exit variables
	 */
	public Path(int pos){
		super(pos);
	}
	
	// used abstract methods so that Map can call upon Path and the method will be chosen in the 
	// correct subclass
	abstract public void rotate();
	abstract public int getEntrance();
	abstract public int getExit();
	abstract public int getpos();
	abstract public void setisEdge();
	abstract public boolean getisEdge();
	abstract public void setEntry();
	abstract public void setExit();
	abstract public boolean getedgeType();
	abstract public void setVisited(boolean visited);

}
