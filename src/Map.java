import java.util.Iterator;
import java.util.LinkedList;


public class Map {
	
	private Path grid [][]; // This will be an array holding the path
	private int height;
	private int width;
	LinkedList <Path> temp = new LinkedList<Path>(); // Will hold all the path before reordering
	LinkedList <Path> finalPath = new LinkedList<Path>(); // will hold the final path
	LinkedList <Path> entryExit = new LinkedList<Path>(); // temporarily hold entry and exit points
	
	public Map(int height, int width){
		
		this.height = height;
		this.width = width;
		grid = new Path [height][width]; // This will create the grid to hold the tiles
		/*
		StraightWE p10 = new StraightWE(5,height);
		grid[0][5] = p10;
		System.out.println(p10.getpos());
		*/
		
	}
	
	public String verify(){
		if(entryExitPoints()==false){
			return "There is an incorrect number of entry or exit points";
		}
		if(isConnected()==false){
			return "The path is not connected";
		}
		else{
			return "Verified";
		}
	}
	
	public boolean entryExitPoints(){
		int entrycount = 0; // Check how many entry points there are
		int exitcount = 0; // Check how many exit points there are
		Iterator <Path> iterator = temp.iterator();
		Path tempP;
		while(iterator.hasNext() && entrycount<=1 && exitcount<=1){
			tempP = iterator.next();
			// System.out.println(tempP.pos); // debugging purposes
			if(tempP.getisEdge()==true && tempP.getedgeType()==true){
				// If the Path is and entry point type ...
				entrycount++;
				entryExit.add(tempP);
			}
			else if(tempP.getisEdge()==true && tempP.getedgeType()==false){
				// If the Path is and entry point type ...
				exitcount++;
				entryExit.add(tempP);
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
			grid[calculaterow(entryExit.getFirst().getpos())][calculatecolumn(entryExit.getFirst().getpos())] = entryExit.getFirst();
			grid[calculaterow(entryExit.getLast().getpos())][calculatecolumn(entryExit.getLast().getpos())] = entryExit.getLast();
			return true;
		}
	}
	
	public boolean connected(Path p1,Path p2){
		// Checks if p1 and p2 are connected
		if(p1.getExit()==p2.getpos()){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean isConnected(){
		boolean connected = true; // Keep track if two Path tiles are connected
		int previousPos;
		int nextExit;
		int currentEnt;
		boolean error = false; // if there was an error
		boolean endReached = false; // If reached the exit point
		Iterator <Path> iterator = temp.iterator();
		Path tempP;
		while(iterator.hasNext()){ // Putting all the remaining path values into the Grid
			tempP = iterator.next();
			grid[calculaterow(tempP.getpos())][calculatecolumn(tempP.getpos())] = tempP;
		}
		/*
		System.out.println("Checking Grid");
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid.length;j++){
				if(grid[i][j]!=null){
					System.out.println(i+" "+j+" "+" "+grid[i][j].getpos()+" "+grid[i][j].getEntrance()+ " "+grid[i][j].getExit());
				}
			}
		}
		*/
		
		
		if(entryExit.getFirst().getedgeType()==true){
			previousPos=entryExit.getFirst().getpos();// position of the entry point
			// it is called the previouspos because it is compared to the next tile
			nextExit=entryExit.getFirst().getExit(); // finding where the next tile should be 
			entryExit.getFirst().setVisited(true); // setting the entry point as being visited
		}
		else{
			previousPos=entryExit.getLast().getpos();
			nextExit=entryExit.getLast().getExit();
			entryExit.getLast().setVisited(true);
		}
		
		while(!error && !endReached){
			
			// System.out.println(nextExit);
			// System.out.println(calculaterow(nextExit));
			// System.out.println(calculatecolumn(nextExit));
			// System.out.println(grid[0][0].getpos());
			//System.out.println(grid[calculaterow(nextExit)][calculatecolumn(nextExit)].getpos());
			
			currentEnt = grid[calculaterow(nextExit)][calculatecolumn(nextExit)].getEntrance(); // entrance of current tile
			grid[calculaterow(nextExit)][calculatecolumn(nextExit)].setVisited(true);
			// System.out.println(previousPos+" "+currentEnt);
			if(previousPos!=currentEnt){
				// If both the previous tile's exiting direction is not towards the current tile, then the path is not connected
				error=true;
			}
			else if(grid[calculaterow(nextExit)][calculatecolumn(nextExit)].getisEdge()==true&&grid[calculaterow(nextExit)][calculatecolumn(nextExit)].getedgeType()==false){
				// Once the exit point has been reached ... 
				endReached=true;
			}
			else{
				// move to next tile in path
				previousPos = nextExit;
				nextExit = grid[calculaterow(previousPos)][calculatecolumn(previousPos)].getExit();
			}
			//System.out.println(error+" "+endReached);
		}
		if(error==false){
			return false;
		}
		else{
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
	
	public int getHeight(){
		return height;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int calculaterow(int pos){// calculate row index
		return pos/width;
	}
	
	public int calculatecolumn(int pos){// calculate column index
		return pos%width;
	}
	
}
