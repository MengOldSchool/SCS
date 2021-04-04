package test_report;

import static org.junit.Assert.assertSame;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import resultsManager.report;
import resultsManager.reportTables;

/*
 * test ItemCost Table, defined in class command
 */


public class Test_report_test_01 {

	@Test
	
	public void test() {
		//define the test obj
		HashMap<String, Integer> output = new HashMap<>();
		report testObj = new report();
		output = testObj.getItemCostTable();

		/*
		 * set expect values
		 */
		String[] expect_item = new String[5];
		expect_item[0]= "communication overhead";
		expect_item[1]= "fuel usage";
		expect_item[2]= "unclear squares";
		expect_item[3]= "destruciton of protected tree";
		expect_item[4]= "paint damagee to builldozer";
		
		int[] expect_cost = new int[5];
		expect_cost[0] = 1;
		expect_cost[1] = 1;
		expect_cost[2] = 3;
		expect_cost[3] = 10;
		expect_cost[4] = 2;
		
		Map<String,Integer> expecteds = new HashMap<>();
	    expecteds.put(expect_item[0], expect_cost[0]);
	    expecteds.put(expect_item[1], expect_cost[1]);
	    expecteds.put(expect_item[2], expect_cost[2]);
	    expecteds.put(expect_item[3], expect_cost[3]);
	    expecteds.put(expect_item[4], expect_cost[4]);
	    /**************************************/
		
		
		//System.out.println(output);
		
	    for(Map.Entry<String, Integer> entry : output.entrySet()) {
	    	assertSame(expecteds.get(entry.getKey()), output.get(entry.getKey()));
        }
	}

}
