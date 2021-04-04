package commandHandler;

import resultsManager.report;
import simulator.bulldozer;
import systemEnum.OpTypeEnum;

/*
 * @Meng
 * command to turn bulldozer
 */
public class command_left extends commandInterface{
	
	private bulldozer veh;
	private report result;
	
	/*
	 * constructor
	 */
	public command_left (bulldozer vehIn, report resultIn){
		this.veh = vehIn;
		this.result = resultIn;
	}
	
	/*
	 * override action
	 */
	public void action() {
	
		//turn right, update the result with comm overhead
		veh.turnleft();
		result.operationCost(OpTypeEnum.OpComm.value);
	
	}
			
}


