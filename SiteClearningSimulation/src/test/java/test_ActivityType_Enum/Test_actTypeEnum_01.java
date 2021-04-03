package test_ActivityType_Enum;

import static org.junit.Assert.*;

import org.junit.Test;

import systemEnum.ActTypeEnum;
import systemEnum.OpTypeEnum;

public class Test_actTypeEnum_01 {

	@Test
	public void test() {
		String[] expect = new String[4];
		
		expect[0]= "Cleaning plain land";
		expect[1]= "Visting any land that has already been cleard";
		expect[2]= "Clearning rocky land";
		expect[3]= "Clearning land containg a tree";
		
		assertSame (ActTypeEnum.ActClrPL.value, expect[0]);
		assertSame (ActTypeEnum.ActVisCldLd.value, expect[1]);
		assertSame (ActTypeEnum.ActClrRL.value, expect[2]);
		assertSame (ActTypeEnum.ActClrTree.value, expect[3]);
		
		System.out.println(ActTypeEnum.ActClrPL.value);
	}

}
