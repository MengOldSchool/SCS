package test_command_advance;

import static org.junit.Assert.*;

/*
 * test command advance
 */

import org.junit.Test;

import resultsManager.report;
import simulator.bulldozer;
import simulator.command_advance;
import simulator.command_turn;
import simulator.sitemap;
import systemEnum.CmdType;

/*
 * test case - out of boundary 
 */

public class test_command_adv_01 {

	@Test
	public void test() {
		
		//declare test objects
		bulldozer test_veh = new bulldozer();
		sitemap test_map = new sitemap();
		command_turn test_cmd_turn = new command_turn();
		command_advance test_cmd_adv = new command_advance();
		report test_report = new report();
		boolean adv_flag = true; 
		
		//set a test site
		char[][]myMap =  {
				{'o', 'o', 'o', 'r'}, 
				{'t', 't', 'r', 'o'},
				{'r', 'o', 'T', 'o'}};
		
		test_map.setTestMap(myMap, 3, 4);
		test_map.showMap();
		System.out.println();
	
		
		//operate the vehicle 
		test_cmd_turn.turnVeh(test_veh, CmdType.r, test_report);
		adv_flag = test_cmd_adv.move_forward(test_veh, test_map, test_report, 1);
		System.out.println("move forward status = " + adv_flag +"\n");
		
		test_veh.whereIsVeh();
		System.out.println();
		
		test_report.printReport();
		test_map.showMap();
		
		
		assertEquals(adv_flag, false);
	}

}
