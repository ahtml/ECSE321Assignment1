
public class StraightWE extends Path{

	int ent; // Tile from where critter will enter
	int exit; // Till which the critter will exit
	int length; // Length of the Map Used to calculate exit/entrance of tile
	boolean isEdge; // If this tile is an entrance or exit or if it is part of path
	boolean edgeType; // If it is an entrance or exit
	
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
	
	public void setisEdge(){ //setting that there it may be either an entrance or exit
		isEdge = true;
	}
	
	public boolean getisEdge(){ //know if its a regular path or either entrance or exit
		return isEdge;
	}
	
	public void setEntry(){ //setting tile as entry point
		edgeType = true;
	}
	
	public void setExit(){ //setting tile as exit point
		edgeType = false;
	}
	
	public boolean getedgeType(){
		return edgeType;
	}

}
