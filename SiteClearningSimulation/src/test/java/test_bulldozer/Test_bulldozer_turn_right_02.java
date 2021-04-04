package test_bulldozer;

import static org.junit.Assert.*;

import org.junit.Test;

import simulator.bulldozer;

public class Test_bulldozer_turn_right_02 {

	@Test
	public void test() {
		bulldozer testObj = new bulldozer(1, 1, 90);
		testObj.turnright();
		testObj.turnright();
		testObj.turnright();
		
		int dir = testObj.getDirection();
		
		assertEquals(180, dir);
	}

}
