package userInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import systemEnum.CmdType;

/*
 * @Meng
 * user interface: 
 * 1) read the user input and return the status 
 * 2) return the command 
 * 3) store all the inputs and print out 
 */

public class user {
	
	private Scanner in = new Scanner(System.in);
	private String input;
	private List<String> userCmd;
	private String validCmd;
	
	/*
	 * constructor
	 */
	
	
	public user() {
		userCmd = new ArrayList<String>();
	}
	
	/*
	 * read user input command
	 */
	public boolean readInput() {
		// Using Scanner for Getting Input from User
		boolean isInputValid = true;
      
		System.out.print("(l)eft, (r)right, (a)dvance <n>, (q)uit: ");	  
		this.input = in.nextLine();
		isInputValid = checkInput();
        
        return isInputValid;               
	}
	
	public void endInput() {
		in.close();
	}
	
	
	private boolean checkInput() {
		char[] ch = this.input.toCharArray();
		int cmd_length = ch.length; 
		
		if (cmd_length == 1) {
			//if input is one char, check it is "l", "r", "q"
			if (ch[0] == (CmdType.Left.value)) {
				//store the commmand
				userCmd.add(input);
				validCmd = input;
				return true;
			}
			else if (ch[0] == CmdType.Right.value) {
				userCmd.add(input);
				validCmd = input;
				return true;
			}
			else if (ch[0] == CmdType.Quit.value) {
				userCmd.add(input);
				validCmd = input;
				return true;
			}
			else {
				//invalid command
				return false;
			}
		}
		else{
			//if it is longer then 1 char
			if (ch[0] == (CmdType.Adv.value)) {
				//this first one must be "a"
				//And, the reset must be number
				for (int i=1; i<cmd_length; i++) {
					if (Character.isDigit(input.charAt(i)) == false) {
						//not digital, invalid command
						return false;
					}
				}
				userCmd.add(input);
				validCmd = input;
				return true;
			}
			else {
				//invalid command
				return false;
			}
		}
	}

	public void showAllCmd() {
		System.out.println(userCmd);
	}
	
	public String curValidCmd() {
		return validCmd;
	}
		

}
