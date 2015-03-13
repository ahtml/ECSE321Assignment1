
public class TurnWS extends Path {

	private int ent; // Tile from where critter will enter
	private int exit; // Till which the critter will exit
	private int width; // width of the Map Used to calculate exit/entrance of tile
	private boolean isEdge; // If this tile is an entrance or exit or if it is part of path
	private boolean edgeType; // If it is an entrance or exit
	private boolean visited; // Check if the tile was visited during verification process
	private int pos;
	
	public TurnWS(int pos, int width) {
		
		this.width = width;
		setParameters(pos);
		
	}
	
	public void rotate() { // Rotate piece
		int temp = ent;
		ent = exit;
		exit = temp; 
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
		setisEdge();
		edgeType = true;
		ent = pos;
	}
	
	public void setExit(){ //setting tile as exit point
		setisEdge();
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
	
	public void setParameters(int pos){
		
		this.pos = pos;
		ent = pos -1; // calculate entrance
		exit = pos + width; // calculate exit
		
	}


}
