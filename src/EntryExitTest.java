import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class EntryExitTest {
	Map m1;
	Map m2;
	Path ent1;
	Path ent2;
	Path exit1;
	Path exit2;
	
	@Before
	public void setUp() throws Exception {
		m1 = new Map(10,10);
		m2 = new Map(10,10);
		ent1 = new StraightWE(1,10);
		ent1.setEntry();// Set as an entry point
		ent2 = new TurnNW(2,10);
		ent2.setEntry();
		exit1 = new TurnEN(5,10);
		exit1.rotate();
		exit1.setExit();
		exit2 = new StraightNS(3,10);
		exit2.setExit();
		m2.addPathPiece(ent1);
		m2.addPathPiece(ent2);
		m2.addPathPiece(exit1);
		m2.addPathPiece(exit2);
	}

	@Test
	public void test() {
		
		// Case 1 (Failure) : Try with empty no entry or exit points
		assertFalse("Case 1 did not work",m1.entryExitPoints());
		// worked for empty 
		
		// Case 2 (Failure): Try with incorrect number of exit and entry points
		assertFalse("Case 2 did not work",m2.entryExitPoints());
		// worked
		
		// Case 3 (Success) : remove one one entry and one exit
		m2.removePathPiece(ent1);
		m2.removePathPiece(exit2);
		assertTrue("Case 3 did not work",m2.entryExitPoints());
		
	}

}
