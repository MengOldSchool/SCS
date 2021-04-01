package test_bulldozer;

import static org.junit.Assert.*;

import org.junit.Test;

import simulator.bulldozer;

public class bulldozer_turn_left_02 {

	@Test
	public void test() {
		bulldozer testObj = new bulldozer();
		testObj.turnleft();
		testObj.turnleft();
		testObj.turnleft();
		testObj.turnleft();
		
		int dir = testObj.getDirection();
		
		assertEquals(0, dir);
		//fail("Not yet implemented");
	}

}
