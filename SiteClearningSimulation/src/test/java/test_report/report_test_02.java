package test_report;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import simulator.report;

/*
 * test Activity table declared in class - command
 */

public class report_test_02 {

	@Test
	public void test() {
		//define the test obj
		HashMap<String, Integer> output = new HashMap<>();
		report testObj = new report();
		output = testObj.getActivityFuelTable();

		/*
		 * set expect values
		 */
		String[] expect_item = new String[4];
		expect_item[0]= "Cleaning plain land";
		expect_item[1]= "Visting any land that has already been cleard";
		expect_item[2]= "Clearning rocky land";
		expect_item[3]= "Clearning land containg a tree";
				
		int[] expect_fuel = new int[4];
		expect_fuel[0] = 1;
		expect_fuel[1] = 1;
		expect_fuel[2] = 2;
		expect_fuel[3] = 2;

		
		Map<String,Integer> expecteds = new HashMap<>();
	    expecteds.put(expect_item[0], expect_fuel[0]);
	    expecteds.put(expect_item[1], expect_fuel[1]);
	    expecteds.put(expect_item[2], expect_fuel[2]);
	    expecteds.put(expect_item[3], expect_fuel[3]);
	   
	    /**************************************/
		
		
		System.out.println(output);
		
	    for(Map.Entry<String, Integer> entry : output.entrySet()) {
	    	assertSame(expecteds.get(entry.getKey()), output.get(entry.getKey()));
        }
	}

}
