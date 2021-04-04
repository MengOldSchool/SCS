package test_OperationType_Enum;

import static org.junit.Assert.*;

import org.junit.Test;

import systemEnum.OpTypeEnum;

public class Test_operationType_01 {

	@Test
	
	
	public void test() {
		String[] expect = new String[5];
		
		expect[0]= "communication overhead";
		expect[1]= "fuel usage";
		expect[2]= "unclear squares";
		expect[3]= "destruciton of protected tree";
		expect[4]= "paint damagee to builldozer";
		
		assertSame (OpTypeEnum.OpComm.value, expect[0]);
		assertSame (OpTypeEnum.OpFuel.value, expect[1]);
		assertSame (OpTypeEnum.OpUncldLd.value, expect[2]);
		assertSame (OpTypeEnum.OpDesResTree.value, expect[3]);
		assertSame (OpTypeEnum.OpRepDmg.value, expect[4]);
		
		System.out.println(OpTypeEnum.OpComm.value);
	}

}
