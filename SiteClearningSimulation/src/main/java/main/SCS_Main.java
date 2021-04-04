package main;

import commandHandler.command_advance;
import commandHandler.command_left;
import commandHandler.command_quit;
import commandHandler.command_right;
import resultsManager.report;
import simulator.bulldozer;
import simulator.sitemap;
import systemEnum.CmdType;
import userInterface.user;

public class SCS_Main {

	public static void main(String[] args) {
		//setup simulation environment  
		bulldozer veh = new bulldozer();
		sitemap site = new sitemap();
		report result = new report();
		user operator = new user();
		
		//declare command objects
		command_advance cmd_adv = new command_advance(veh, site, result);
		command_left cmd_left = new command_left(veh, result);
		command_right cmd_right = new command_right(veh, result);
		command_quit cmd_quit = new command_quit(site,result);
		
		//display the map and instructions
		printOutWelMsg();
		site.showMap();
		printOutInstruction(); 
		
		boolean IsFinished  = false;
		String userInput = null;
	
		//Loop to listen the user input
		while(!IsFinished) {
			
			//evaluate the user input
			//if the input is invalid, instruct the user to input again
			if (operator.readInput()) {
				
				//Valid user input, run the simulation accordingly
				userInput = operator.curValidCmd();
				
				//Execute the user command
				if (userInput.equals("q"))
				{
					cmd_quit.action();
					IsFinished = true;
				}
				else if (userInput.equals("l")) {
					cmd_left.action();
				}
				else if(userInput.equals("r")) {
					cmd_right.action();
				}
				else {
					//it must be an advance command
					cmd_adv.decodeCmd(userInput);
					cmd_adv.action();
					//check the action status
					if (!cmd_adv.getStatus()) {
						//action is not successful,stop the simulation
						IsFinished = true;
					}
				}	
			}
			else {
				//invalid input, instruct the user to re-input the command
				askInputAgainMsg();
			}
			
		}
		
		//close input
		operator.endInput();
		
		//display all the command
		printOutCmdMsg();
		operator.showAllCmd();
		
		//display the result
		printOutReportMsg();
		result.printReport();
		
		//say good bye
		printOutEnding();

	}
	
	
	/*
	 * print out welcome message
	 */
	private static void printOutWelMsg() {
		System.out.println("\nWelcome to Site Clearning Simulator. This is a map of the site:\n");
	}
	
	/*
	 * print out instruction message
	 */
	private static void printOutInstruction() {
		System.out.println("\nThe bulldozer is currently located at the northen Edge of the site, immediately to the West of the site, and facing Easy. \n");
	}
	
	/*
	 * print out ending message
	 */
	private static void printOutReportMsg() {
		System.out.println("\nThe costs for this land clearing operation were: \n");
	}
	
	/*
	 * print out ending message
	 */
	private static void printOutEnding() {
		System.out.println("\nThanks for using the site clearning simulator \n");
	}
	
	/*
	 * request operator to retype the command
	 */
	private static void askInputAgainMsg() {
		System.out.println("\nDon't undersand your input, please do again. \n");
	}
	
	/*
	 * print out all the commands
	 */
	private static void printOutCmdMsg() {
		System.out.println("\nThis Simulation has ended at your request. There are the commands you issued \n");
	}

}


