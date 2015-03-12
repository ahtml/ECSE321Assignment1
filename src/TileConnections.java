import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TileConnections {
	
	Map m;
	StraightWE straightWE;
	StraightNS straightNS;
	StraightWE straightEW;
	StraightNS straightSN;
	TurnEN turnEN;
	TurnEN turnNE;
	TurnNW turnNW;
	TurnNW turnWN;
	TurnSE turnSE;
	TurnSE turnES;
	TurnWS turnWS;
	TurnWS turnSW;
	
	@Before
	public void setUp() throws Exception {
		m = new Map(10,10);
		straightWE = new StraightWE(2,10);
		straightEW = new StraightWE(3,10);
		straightEW.rotate();
		straightNS = new StraightNS(3,10);
		straightSN = new StraightNS(3,10);
		straightSN.rotate();
		
	}

	@Test
	public void test() {
		
		assertFalse("Straright WE at "+straightWE.getpos()+" is not equal to Straight EW at " + straightEW.getpos() + " " + m.connected(straightWE, straightEW), m.connected(straightWE, straightEW));
		assertFalse("Straright WE at "+straightWE.getpos()+" is not equal to Straight EW at " + straightEW.getpos() + " " + m.connected(straightWE, straightEW), m.connected(straightEW, straightWE));
		// System.out.println(straightEW.getEntrance()+" "+straightEW.getExit());
		straightEW.rotate();
		// System.out.println(straightEW.getEntrance()+" "+straightEW.getExit());
		assertTrue("Straright WE at "+straightWE.getExit()+" is not equal to Straight EW at " + straightEW.getEntrance(),m.connected(straightWE,straightEW));
		
		assertFalse("Straright WE at "+straightWE.getExit()+" is not equal to Straight EW at " + straightNS.getEntrance(),m.connected(straightWE, straightNS));
		assertFalse("Straright WE at "+straightWE.getExit()+" is not equal to Straight EW at " + straightSN.getEntrance(),m.connected(straightWE, straightSN));
		assertFalse("Straright WE at "+straightWE.getExit()+" is not equal to Straight EW at " + straightNS.getEntrance(),m.connected(straightNS, straightWE));
		assertFalse("Straright WE at "+straightWE.getExit()+" is not equal to Straight EW at " + straightSN.getEntrance(),m.connected(straightSN, straightWE));
		
	}

}
