package test_bulldozer;

import static org.junit.Assert.*;

import org.junit.Test;

import simulator.bulldozer;

public class bulldozer_quit_01 {

	@Test
	public void test() {
		bulldozer testObj = new bulldozer(0, 0, 0);
		testObj.advance(3);
		testObj.quit();
		
		int dir = testObj.getDirection();
		int x = testObj.getPos_x();
		int y = testObj.getPos_y();
		
			
		assertEquals(0, dir);
		assertEquals(0, x);
		assertEquals(-1, y);
	}

}
