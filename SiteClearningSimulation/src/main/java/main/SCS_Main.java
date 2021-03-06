package main;

import java.io.File;
import java.io.IOException;

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

	public static void main(String[] args) throws IOException {
		//setup simulation environment  
		bulldozer veh = new bulldozer();
		report result = new report();
		user operator = new user();
		sitemap site = null;	
		
		
		
		//setup site map, a default map will be used, if not defined by user
		if (args.length == 0) {
			System.out.println("\nSimulation will use a site map \n");
			site = new sitemap();
			
		}
		else
		{
			System.out.println("\nLoad the site map from  the file " + args[0] + ".");
			site = new sitemap(args[0]);			
		}
			
		//declare command objects
		command_advance cmd_adv = new command_advance(veh, site, result);
		command_left cmd_left = new command_left(veh, result);
		command_right cmd_right = new command_right(veh, result);
		command_quit cmd_quit = new command_quit(site,result);
		
		//display the map and instructions
		//Show the welcome message
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
				if (userInput.equals(Character.toString(CmdType.Quit.value)))
				{
					//execute quit action
					cmd_quit.action();
					IsFinished = true;
				}
				else if (userInput.equals(Character.toString(CmdType.Left.value))) {
					//execute turn left action
					cmd_left.action();
				}
				else if(userInput.equals(Character.toString(CmdType.Right.value))) {
					//execute turn right action
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
		//site.showMap();

	}
	
	
	/*
	 * print out welcome message
	 */
	private static void printOutWelMsg() {
		System.out.println("\nWelcome to the Aconex Site Clearning Simulator. This is a map of the site:\n");
	}
	
	/*
	 * print out instruction message
	 */
	private static void printOutInstruction() {
		System.out.println("\nThe bulldozer is currently located at the northen Edge of the site, immediately to the West of the site, and facing East. \n");
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
		System.out.println("\nThanks for using the Aconex site clearning simulator. \n ");
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
		System.out.println("\nThis Simulation has ended at your request. There are the commands you issued:\n");
	}
	
	/*
	 * print out no file error message
	 */
	private static void printOutNoFileError() {
		System.out.println("\nSorry, not able to find the site map. Please ensure the site map located at the same directory\n");
		System.exit(0);
	}
	
	

}


