
public class TurnSE extends Path {

	private int exit;
	private int ent;
	private int length;
	
	public TurnSE(int pos, int length) {
		super(pos,length);
		ent = pos - length;
		exit = pos + 1;
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
