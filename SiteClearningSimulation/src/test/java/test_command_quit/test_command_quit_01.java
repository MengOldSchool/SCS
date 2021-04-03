package test_command_quit;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import resultsManager.report;
import simulator.command_quit;
import simulator.sitemap;
import systemEnum.OpTypeEnum;

public class test_command_quit_01 {

	@Test
	public void test() {
		
			//create test objects
			command_quit test_obj = new command_quit();
			report test_report = new report();
			sitemap test_map = new sitemap();
			
			/*
			 * run test
			 */
			test_obj.quit(test_map, test_report);
			
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
			expect_cost[0] = 1;
			expect_cost[1] = 0;
			expect_cost[2] = 6;
			expect_cost[3] = 0;
			expect_cost[4] = 0;
			
			Map<String,Integer> expecteds = new HashMap<>();
		    expecteds.put(expect_item[0], expect_cost[0]);
		    expecteds.put(expect_item[1], expect_cost[1]);
		    expecteds.put(expect_item[2], expect_cost[2]);
		    expecteds.put(expect_item[3], expect_cost[3]);
		    expecteds.put(expect_item[4], expect_cost[4]);
			
			//evaluation 
			test_map.showMap();
		    test_report.printReport();
			
		    for(Map.Entry<String, Integer> entry : output.entrySet()) {
		    	assertSame(expecteds.get(entry.getKey()), output.get(entry.getKey()));
	        }
	}
		

}
