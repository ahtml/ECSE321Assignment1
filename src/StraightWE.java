
public class StraightWE extends Path{

	static int ent; // Tile from where critter will enter
	static int exit; // Till which the critter will exit
	static int length; // Length of the Map Used to calculate exit/entrance tile
	
	public StraightWE(int pos, int length) {
		super(pos, length); 
		ent = pos-1; // calculate entrance
		exit = pos+1; // Calculate exit
	}
	
	public void rotate() { // Rotate piece
		int temp = ent;
		ent = exit;
		exit = ent; 
	}
	
	public int getEntrance(){ // return entrance of tile
		return ent;
	}
	
	public int getExit(){ // return exit of tile
		return exit;
	}
	
	public int getpos(){ // return position of tile
		return pos;
	}

}
