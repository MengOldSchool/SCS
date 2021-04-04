package test_command_turn;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import commandHandler.command_left;
import commandHandler.command_right;
import resultsManager.report;
import simulator.bulldozer;
import systemEnum.OpTypeEnum;

public class manual_cmd_turn_test_01 {

	@Test
	public void test() {
		//creat test objects
		bulldozer test_veh = new bulldozer();
		report test_report = new report();
		command_left test_turn_left = new command_left(test_veh, test_report);
		command_right test_turn_right = new command_right(test_veh, test_report);
		
		/*
		 * run test
		 */
		
		//turn left
		test_turn_left.action();
		
		//turn right
		test_turn_right.action();
		
		HashMap<String, Integer> output = test_report.getResult_cost();
		
		/*
		 * set expected outcomes 
		 */
		String[] expect_item = new String[5];
		expect_item[0]= OpTypeEnum.OpComm.value;
		expect_item[1]= OpTypeEnum.OpFuel.value;
		expect_item[2]= OpTypeEnum.OpUncldLd.value;
		expect_item[3]= OpTypeEnum.OpDesResTree.value;
		expect_item[4]= OpTypeEnum.OpRepDmg.value;
		
		int[] expect_cost = new int[5];
		expect_cost[0] = 2;
		expect_cost[1] = 0;
		expect_cost[2] = 0;
		expect_cost[3] = 0;
		expect_cost[4] = 0;
		
		Map<String,Integer> expecteds = new HashMap<>();
	    expecteds.put(expect_item[0], expect_cost[0]);
	    expecteds.put(expect_item[1], expect_cost[1]);
	    expecteds.put(expect_item[2], expect_cost[2]);
	    expecteds.put(expect_item[3], expect_cost[3]);
	    expecteds.put(expect_item[4], expect_cost[4]);
		
		//evaluation 

		test_report.printReport();
		assertEquals(test_veh.getDirection(), 0);
		for(Map.Entry<String, Integer> entry : output.entrySet()) {
	    	assertSame(expecteds.get(entry.getKey()), output.get(entry.getKey()));
        }
		

	}

}
