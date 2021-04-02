package test_command_turn;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import simulator.CmdType;
import simulator.OpTypeEnum;
import simulator.bulldozer;
import simulator.command_turn;
import simulator.report;

/*
 * test command_turn.java
 */

public class test_command_turn_01 {

	@Test
	public void test() {
		//creat test objects
		command_turn test_obj = new command_turn();
		bulldozer test_veh = new bulldozer();
		report test_report = new report();
		
		/*
		 * run test
		 */
		CmdType test_cmd = CmdType.l;
		
		test_obj.turnVeh(test_veh, test_cmd, test_report);
		
		test_cmd = CmdType.r;
		test_obj.turnVeh(test_veh, test_cmd, test_report);
		
		test_cmd = CmdType.a;
		test_obj.turnVeh(test_veh, test_cmd, test_report);
		
		test_cmd = CmdType.q;
		test_obj.turnVeh(test_veh, test_cmd, test_report);
		
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
		for(Map.Entry<String, Integer> entry : output.entrySet()) {
	    	assertSame(expecteds.get(entry.getKey()), output.get(entry.getKey()));
        }
		

	}

}
