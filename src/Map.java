import java.util.LinkedList;


public class Map {
	
	private Tile grid [][]; // This will be an array holding the path and scenery info
	private int length;
	private int height;
	LinkedList <Path> temp = new LinkedList(); // Will hold all the path before reordering
	LinkedList <Path> finalPath = new LinkedList(); // will hold the final path
	
	public Map(int length, int height){
		
		this.length = length;
		this.height = height;
		grid = new Tile [length][height]; // This will create the grid to hold the tiles
		
	}
	
	public String verify(Map m){
		
		return "Verified";
	}
	
	public int getLength(){
		return length;
	}
	
}
