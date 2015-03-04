
public abstract class Path{
	
	private int length; // this will be used to calculate the entrance and exit of the path
	int pos;
	
	
	public Path(int pos, int length){
		this.pos = pos;
		this.length = length;
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

}
