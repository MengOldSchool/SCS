package test_bulldozer;

import static org.junit.Assert.*;

import org.junit.Test;

import simulator.bulldozer;

public class bulldozer_turn_right_01 {

	@Test
	public void test() {
		bulldozer testObj = new bulldozer(1, 1, 90);
		testObj.turnright();
		
		int dir = testObj.getDirection();
		
		assertEquals(0, dir);
	}

}
