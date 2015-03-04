
public class Map {
	
	private Tile grid [][]; // This will be an array holding the path and scenery info
	private int length;
	private int height;
	
	public Map(int length, int height){
		
		this.length = length;
		this.height = height;
		grid = new Tile [length][height]; // This will create the grid to hold the tiles
	}
	
	public int getLength(){
		return length;
	}
	
	public int getPathEntrance(Path p){
		return p.getEntrance();
	}
}
