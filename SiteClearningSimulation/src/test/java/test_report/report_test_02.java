package test_report;

import static org.junit.Assert.*;

import org.junit.Test;

import simulator.report;

public class report_test_02 {

	@Test
	public void test() {
		report testObj = new report();
		
		testObj.printReport();
		testObj.activityFuel(testObj.getActivityName()[3]);
		testObj.printReport();
	}

}
