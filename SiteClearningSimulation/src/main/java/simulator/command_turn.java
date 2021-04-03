package simulator;

import resultsManager.report;
import systemEnum.CmdType;
import systemEnum.OpTypeEnum;

/*
 * @Meng
 * command to turn bulldozer
 */
public class command_turn {
	public void turnVeh(bulldozer veh, CmdType cmd, report result) {
		switch (cmd) {
		case r:
			//turn right, update the result with comm overhead
			veh.turnright();	
			result.operationCost(OpTypeEnum.OpComm.value);
			break;
		case l:
			//turn right, update the result with comm overhead
			veh.turnleft();
			result.operationCost(OpTypeEnum.OpComm.value);
			break;
		default:
			break;
	
		}
			
	}

}
