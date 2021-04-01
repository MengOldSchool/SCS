package test_bulldozer;

import static org.junit.Assert.*;

import org.junit.Test;

import simulator.bulldozer;

public class bulldozer_advance_04 {

	@Test
	public void test() {
		bulldozer testObj = new bulldozer(1, 3, 270);
		testObj.advance(4);
		
		int dir = testObj.getDirection();
		int x = testObj.getPos_x();
		int y = testObj.getPos_y();
		
		assertEquals(270, dir);
		assertEquals(1, x);
		assertEquals(7, y);
	}

}
