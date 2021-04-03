package test_user;

import static org.junit.Assert.*;

import org.junit.Test;

import userInterface.user;

public class test_user_01 {

	@Test
	public void test() {
		user testObj = new user();
		
		testObj.readInput();
		System.out.println("-------------");
		//fail("Not yet implemented");
		testObj.endInput();
	}

}
