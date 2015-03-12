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
	}

	@Test
	public void test() {
		
		assertFalse("Did not work",m1.entryExitPoints());
		// worked for empty 
		//fail("Not yet implemented");
	}

}
