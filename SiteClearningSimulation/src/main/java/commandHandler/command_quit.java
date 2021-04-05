package commandHandler;

import resultsManager.report;
import simulator.sitemap;
import systemEnum.OpTypeEnum;

/*
 * command quit: update the number of uncleared land & communication overhead
 */

public class command_quit extends commandInterface{
	
	
	private sitemap map;
	private report result;
	
	/*
	 * constructor
	 */
	public command_quit(sitemap mapIn, report resultIn){
		map = mapIn;
		result = resultIn;
	}

	/*
	 * override action
	 */
	
	public void action() {
		//update the cost for uncleared land
		int numUncleardLand = map.getNumUnclearedLand();
		result.operationCost(numUncleardLand);

	}

}
