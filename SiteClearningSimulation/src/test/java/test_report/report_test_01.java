package test_report;

import org.junit.Test;

import simulator.command;
import simulator.report;

public class report_test_01 {

	@Test
	public void test() {
		report testObj = new report();
		
		testObj.printReport();
		testObj.operationCost(testObj.getItemName()[3]);
		testObj.printReport();
		
		System.out.println(testObj.getResult_cost());
	}

}
