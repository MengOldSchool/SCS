package simulator;

import resultsManager.report;
import systemEnum.OpTypeEnum;

/*
 * command quit: update the number of uncleared land & communication overhead
 */

public class command_quit{
	public void quit(sitemap map, report result) {
		//update the cost for uncleared land
		int numUncleardLand = map.getNumUnclearedLand();
		result.operationCost(numUncleardLand);
		
		//update the cost for comm overhead
		result.operationCost(OpTypeEnum.OpComm.value);
	}

}
