
public class StraightNS extends Path {
	
	private int ent;
	private int exit;
	private int length;
	
	public StraightNS(int pos, int length) {
		super(pos, length);
		ent = pos - length;
		exit = pos + length;
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
