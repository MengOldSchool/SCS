package test_bulldozer;

import static org.junit.Assert.*;

import org.junit.Test;

import simulator.bulldozer;

public class bulldozer_advance_01 {

	@Test
	public void test() {
		bulldozer testObj = new bulldozer(0, 0, 0);
		testObj.advance(3);
		
		int dir = testObj.getDirection();
		int x = testObj.getPos_x();
		int y = testObj.getPos_y();
		
		assertEquals(0, dir);
		assertEquals(3, x);
		assertEquals(0, y);
		
	}

}
