package test_command_advance;

import static org.junit.Assert.*;

import org.junit.Test;

import commandHandler.command_advance;
import commandHandler.command_left;
import commandHandler.command_right;
import resultsManager.report;
import simulator.bulldozer;
import simulator.sitemap;
import systemEnum.CmdType;

/*
 * test - hit reserved tree T
 */

public class manual_test_command_adv_04 {

	@Test
	public void test() {
		//declare test objects
		//declare test objects
		bulldozer test_veh = new bulldozer();
		sitemap test_map = new sitemap();
		report test_report = new report();
		
		command_right test_right = new command_right(test_veh, test_report);
		command_advance test_adv = new command_advance(test_veh, test_map, test_report);
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
		//operate the vehicle
		test_adv.decodeCmd("a3");
		test_adv.action();
		adv_flag = test_adv.getStatus();
		
		test_right.action();
		
		test_adv.decodeCmd("a2");
		test_adv.action();
		adv_flag = test_adv.getStatus();

		System.out.println("move forward status = " + adv_flag +"\n");
		
		test_veh.whereIsVeh();
		System.out.println();
		
		test_report.printReport();
		test_map.showMap();
		
		
		assertEquals(adv_flag, false);
	}

}
