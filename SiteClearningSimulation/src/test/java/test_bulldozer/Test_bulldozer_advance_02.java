package test_bulldozer;

import static org.junit.Assert.*;

import org.junit.Test;

import simulator.bulldozer;

public class Test_bulldozer_advance_02 {

	@Test
	public void test() {
		bulldozer testObj = new bulldozer(0, 0, 90);
		testObj.advance(2);
		
		int dir = testObj.getDirection();
		int x = testObj.getPos_x();
		int y = testObj.getPos_y();
		
		assertEquals(90, dir);
		assertEquals(-2, x);
		assertEquals(0, y);
	}

}
