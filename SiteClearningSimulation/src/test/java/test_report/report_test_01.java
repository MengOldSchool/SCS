package test_report;

import static org.junit.Assert.*;

import org.junit.Test;

import simulator.report;

public class report_test_01 {

	@Test
	public void test() {
		report testObj = new report();
		
		testObj.printReport();
		testObj.updateReport(4, 1, 2);
		testObj.printReport();
		
		testObj.updateReport(4, -1, -2);
		testObj.printReport();
		//assertEquals(0, 0);
		//fail("Not yet implemented");
	}

}
