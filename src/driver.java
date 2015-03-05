
public class driver {
	
	
	public static void main(){
		/*
		 * Case 1: Check if the entry and exit point verification return false
		 */
		Map m = new Map(10,10);
		
		StraightWE e1 = new StraightWE(11,m.getWidth()); // Path entry point
		StraightNS e2 = new StraightNS(48,m.getWidth()); // Path exit point
		TurnWS e3 = new TurnWS(1,m.getWidth()); // extra exit point
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
		
		/*
		 * Case 3: A Basic case to see if entire verification works
		 */
		
		Map m1 = new Map(10,10);
		
		StraightWE e4 = new StraightWE(11,m1.getWidth());
		StraightWE e5 = new StraightWE(15,m1.getWidth());
		
		e4.setisEdge();
		e5.setisEdge();
		
		e4.setEntry();
		e5.setExit();
		
		StraightWE p1 = new StraightWE(12,m1.getWidth());
		TurnNW p2 = new TurnNW(13,m1.getWidth());
		p2.rotate();
		TurnSE p3 = new TurnSE(3,m1.getWidth());
		TurnWS p4 = new TurnWS(4,m1.getWidth());
		TurnEN p5 = new TurnEN(14,m1.getWidth());
		p5.rotate();
		
		m1.addPathPiece(e4);
		m1.addPathPiece(e5);
		m1.addPathPiece(p1);
		m1.addPathPiece(p2);
		m1.addPathPiece(p3);
		m1.addPathPiece(p4);
		m1.addPathPiece(p5);

		// System.out.println(m1.verify(m1));
		
		if(m1.verify(m1)=="Verified"){
			System.out.println("Case 3: pass");
		}
		
		p5.rotate();
		m1.addPathPiece(p5);
		
		if(m1.verify(m1)=="The path is not connected"){
			System.out.println("Case 4: pass");
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
