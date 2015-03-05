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
		
		return "Verified";
	}
	
	public boolean entrExitPoints(Map m){
		int entrycount = 0; // Check how many entry points there are
		int exitcount = 0; // Check how many exit points there are
		Iterator <Path> iterator = temp.iterator();
		while(iterator.hasNext() && entrycount<=1 && exitcount<=1){
			if(iterator.next().getisEdge()==true && iterator.next().getedgeType()==true){
				// If the Path is and entry point type ...
				entrycount++;
			}
			else if(iterator.next().getisEdge()==true && iterator.next().getedgeType()==false){
				// If the Path is and entry point type ...
				exitcount++;
			}
		}
		if(entrycount>1 || exitcount>1){
			//if there is more than one entry of exit point...
			return false;
		}
		else{
			// Verification for entry and exit point successful
			return true;
		}
	}
	
	public int getLength(){
		return length;
	}
	
}
