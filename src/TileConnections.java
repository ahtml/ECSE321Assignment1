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
		turnEN = new TurnEN(3,10);
		turnNE = new TurnEN(3,10);
		turnNE.rotate();
		turnNW = new TurnNW(3,10);
		turnWN = new TurnNW(3,10);
		turnWN.rotate();
		turnSE = new TurnSE(3,10);
		turnES = new TurnSE(3,10);
		turnES.rotate();
		turnWS = new TurnWS(3,10);
		turnSW = new TurnWS(3,10);
		turnSW.rotate();
		
	}

	@Test
	public void test() {
		
		assertFalse("Straright WE at "+straightWE.getpos()+" is not equal to Straight EW at " + straightEW.getpos() + " " + m.connected(straightWE, straightEW), m.connected(straightWE, straightEW));
		assertFalse("Straright WE at "+straightWE.getpos()+" is not equal to Straight EW at " + straightEW.getpos() + " " + m.connected(straightWE, straightEW), m.connected(straightEW, straightWE));
		// System.out.println(straightEW.getEntrance()+" "+straightEW.getExit());
		straightEW.rotate();
		// System.out.println(straightEW.getEntrance()+" "+straightEW.getExit());
		assertTrue("Straright WE at "+straightWE.getExit()+" is not equal to Straight EW at " + straightEW.getEntrance(),m.connected(straightWE,straightEW));
		straightEW.rotate();
		
		assertFalse("Straright WE at "+straightWE.getExit()+" is not equal to Straight EW at " + straightNS.getEntrance(),m.connected(straightWE, straightNS));
		assertFalse("Straright WE at "+straightWE.getExit()+" is not equal to Straight EW at " + straightSN.getEntrance(),m.connected(straightWE, straightSN));
		assertFalse("Straright WE at "+straightWE.getExit()+" is not equal to Straight EW at " + straightNS.getEntrance(),m.connected(straightNS, straightWE));
		assertFalse("Straright WE at "+straightWE.getExit()+" is not equal to Straight EW at " + straightSN.getEntrance(),m.connected(straightSN, straightWE));
		// Works up till here
		
		assertTrue("Straright WE at "+straightWE.getExit()+" is not equal to Turn WS at " + turnWS.getEntrance(),m.connected(straightWE, turnWS));
		assertFalse("Straright WE at "+straightWE.getExit()+" is not equal to Turn WS at " + turnWS.getEntrance(),m.connected(turnWS, straightWE));
		assertFalse("Straright WE at "+straightWE.getExit()+" is not equal to Turn EN at " + turnEN.getEntrance(),m.connected(straightWE, turnES));
	}

}
