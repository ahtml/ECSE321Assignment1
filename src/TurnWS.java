
public class TurnWS extends Path {

	private int ent; // Tile from where critter will enter
	private int exit; // Till which the critter will exit
	private int length; // Length of the Map Used to calculate exit/entrance of tile
	private boolean isEdge; // If this tile is an entrance or exit or if it is part of path
	private boolean edgeType; // If it is an entrance or exit
	private boolean visited; // Check if the tile was visited during verification process
	
	public TurnWS(int pos, int length) {
		super(pos);
		this.length = length;
		ent = pos -1; // calculate entrance
		exit = pos + length; // calculate exit
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
		ent = pos;
	}
	
	public void setExit(){ //setting tile as exit point
		edgeType = false;
		exit = pos;
	}
	
	public boolean getedgeType(){
		return edgeType;
	}
	
	public void setVisited(boolean visited){
		this.visited = visited;
	}
	
	public boolean getVisited(){
		return visited;
	}

}
