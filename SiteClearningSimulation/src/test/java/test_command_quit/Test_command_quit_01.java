package test_command_quit;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import commandHandler.command_quit;
import resultsManager.report;
import simulator.sitemap;
import systemEnum.OpTypeEnum;

public class Test_command_quit_01 {

	@Test
	public void test() {
		
			//create test objects
			report test_report = new report();
			sitemap test_map = new sitemap();
			command_quit test_obj = new command_quit(test_map, test_report);
			
			
			/*
			 * run test
			 */
			test_obj.action();
			
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
			expect_cost[0] = 0;
			expect_cost[1] = 0;
			expect_cost[2] = 12;
			expect_cost[3] = 0;
			expect_cost[4] = 0;
			
			Map<String,Integer> expecteds = new HashMap<>();
		    expecteds.put(expect_item[0], expect_cost[0]);
		    expecteds.put(expect_item[1], expect_cost[1]);
		    expecteds.put(expect_item[2], expect_cost[2]);
		    expecteds.put(expect_item[3], expect_cost[3]);
		    expecteds.put(expect_item[4], expect_cost[4]);
			
			//evaluation 
			
		    for(Map.Entry<String, Integer> entry : output.entrySet()) {
		    	assertSame(expecteds.get(entry.getKey()), output.get(entry.getKey()));
	        }
		    
	}
		

}
