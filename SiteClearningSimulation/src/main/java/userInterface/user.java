package userInterface;

import java.util.Scanner;

public class user {
	
	private Scanner in = new Scanner(System.in);
	private String input;
	
	private final int MAX_CMD_SIZE = 2;
	
	/*
	 * constructor
	 */
	
	
	public user() {
		
		
	}
	
	/*
	 * read user input command
	 */
	public void readInput() {
		// Using Scanner for Getting Input from User
      
		System.out.print("(l)eft, (r)right, (a)dvance <n>, (q)uit: ");	  
		this.input = in.nextLine();
		checkInput();
        System.out.println("You entered string " + this.input);
  
        //int a = in.nextInt();
        //System.out.println("You entered integer " + a);
  
        //float b = in.nextFloat();
        //System.out.println("You entered float " + b);
        
        
	}
	
	public void endInput() {
		in.close();
	}
	
	private void checkInput() {
		char[] ch = this.input.toCharArray();
		int cmd_lengh = ch.length; 
		
		if (cmd_lengh == 1) {
			//if (ch[0] != (char)(CmdType.l)) {
				
			//}
		}
		if (ch.length <= MAX_CMD_SIZE) {
			System.out.println(input);
		}
		else {
			System.out.printf("wrong command");
		}
	}
	

}
