package commandHandler;

import resultsManager.report;
import simulator.bulldozer;
import systemEnum.OpTypeEnum;


public class command_right extends commandInterface{
	
	private bulldozer veh;
	private report result;
	
	/*
	 * constructor
	 */
	public command_right (bulldozer vehIn, report resultIn){
		this.veh = vehIn;
		this.result = resultIn;
	}
	
	/*
	 * override action
	 */
	public void action() {	
		//turn right, update the result with comm overhead
		veh.turnright();	
		result.operationCost(OpTypeEnum.OpComm.value);		

	}
			

}


