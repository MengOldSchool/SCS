package test_user;

import static org.junit.Assert.*;

import org.junit.Test;

import userInterface.user;

public class Test_user_01 {

	@Test
	public void test() {
		user testObj = new user();
		boolean inputStatus;
		String curCmd = null;
		
		inputStatus = testObj.readInput();
		if (inputStatus) {
			curCmd = testObj.curValidCmd();
			System.out.println("You entered an valid command " + curCmd);
			testObj.showAllCmd();
		}
		System.out.println(curCmd.equals("q") + " comparing");
		System.out.println("-------------");
			
		inputStatus = testObj.readInput();
		if (inputStatus) {
			curCmd = testObj.curValidCmd();
			System.out.println("You entered an valid command " + curCmd);
			testObj.showAllCmd();
		}
		System.out.println(curCmd.equals("q") + " comparing");
		System.out.println("-------------");
		
		inputStatus = testObj.readInput();
		if (inputStatus) {
			curCmd = testObj.curValidCmd();
			System.out.println("You entered an valid command " + curCmd);
			testObj.showAllCmd();
		}
		System.out.println(curCmd.equals("q") + " comparing");
		System.out.println("-------------");
		
		
	
		testObj.endInput();
	}

}
