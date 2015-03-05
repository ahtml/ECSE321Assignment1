
public class driver {
	
	
	public static void main(){
		/*
		 * Case 1: Check if the entry and exit point verification return false
		 */
		Map m = new Map(10,10);
		
		StraightWE e1 = new StraightWE(11,m.getLength()); // Path entry point
		StraightNS e2 = new StraightNS(48,m.getLength()); // Path exit point
		TurnWS e3 = new TurnWS(1,m.getLength()); // extra exit point
		// setting the Path pieces to the correct types
		e1.setisEdge();
		e2.setisEdge();
		e3.setisEdge();
		e1.setEntry();
		e2.setExit();
		e3.setEntry();
		// adding path pieces to map
		m.addPathPiece(e1);
		m.addPathPiece(e2);
		m.addPathPiece(e3);
		
		if(m.entryExitPoints(m)==false){
			System.out.println("Case 1: pass");
		}
		
		/*
		 * Case 2: Check if the entry and exit point verification return true
		 */
		
		// removing the extra entry point
		m.removePathPiece(e3);
		
		if(m.entryExitPoints(m)==true){
			System.out.println("Case 2: pass");
		}
		
	}	
	
	
	public static void main(String [] args){
		
		
		main();
		/*
		StraightWE p = new StraightWE(9,10);
		System.out.println(p.getEntrance());
		System.out.println(p.getExit());
		System.out.println(p.getpos());
		System.out.println(p.getisEdge());
		*/
		
		
		
	}
	
	

}
