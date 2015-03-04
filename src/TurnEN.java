
public class TurnEN extends Path {

	private int exit;
	private int ent;
	private int length;
	
	public TurnEN(int pos, int length) {
		super(pos,length);
		ent = pos + 1;
		exit = pos - length;
	}
	
	public void rotate() {
		int temp = ent;
		ent = exit;
		exit = ent; 
	}
	
	public int getEntrance(){
		return ent;
	}
	
	public int getExit(){
		return exit;
	}
	
	public int getpos(){
		return pos;
	}

}
