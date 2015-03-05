import java.util.Iterator;
import java.util.LinkedList;


public class Map {
	
	private Tile grid [][]; // This will be an array holding the path and scenery info
	private int length;
	private int height;
	LinkedList <Path> temp = new LinkedList(); // Will hold all the path before reordering
	LinkedList <Path> finalPath = new LinkedList(); // will hold the final path
	LinkedList <Path> entryExit = new LinkedList(); // temporarily hold entry and exit points
	
	public Map(int length, int height){
		
		this.length = length;
		this.height = height;
		grid = new Tile [length][height]; // This will create the grid to hold the tiles
		
	}
	
	public String verify(Map m){
		if(entryExitPoints(m)==false){
			return "There is an incorrect number of entry or exit points";
		}
		else{
			return "Verified";
		}
	}
	
	public boolean entryExitPoints(Map m){
		int entrycount = 0; // Check how many entry points there are
		int exitcount = 0; // Check how many exit points there are
		Iterator <Path> iterator = temp.iterator();
		while(iterator.hasNext() && entrycount<=1 && exitcount<=1){
			if(iterator.next().getisEdge()==true && iterator.next().getedgeType()==true){
				// If the Path is and entry point type ...
				entrycount++;
				entryExit.add(iterator.next());
			}
			else if(iterator.next().getisEdge()==true && iterator.next().getedgeType()==false){
				// If the Path is and entry point type ...
				exitcount++;
				entryExit.add(iterator.next());
			}
		}
		if(entrycount>1 || exitcount>1 || entrycount==0 || exitcount==0){
			//if there is more than one entry of exit point or not enough entry or exit points...
			entryExit.clear();
			return false;
		}
		else{
			// Verification for entry and exit point successful
			temp.remove(entryExit.getFirst());
			temp.remove(entryExit.getLast());
			return true;
		}
	}
	
	public void addPathPiece(Path p){ 
		// add path p to temp linked list
		temp.add(p);
	}
	
	public void removePathPiece(Path p){
		// remove path p from temp linked list
		temp.remove(p);
	}
	
	public int getLength(){
		return length;
	}
	
}
