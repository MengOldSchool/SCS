package test_bulldozer;

import static org.junit.Assert.*;

import org.junit.Test;

import simulator.bulldozer;

public class bulldozer_advance_03 {

	@Test
	public void test() {
		bulldozer testObj = new bulldozer(1, 1, 180);
		testObj.advance(3);
		
		int dir = testObj.getDirection();
		int x = testObj.getPos_x();
		int y = testObj.getPos_y();
		
		assertEquals(180, dir);
		assertEquals(1, x);
		assertEquals(-2, y);
	}

}
