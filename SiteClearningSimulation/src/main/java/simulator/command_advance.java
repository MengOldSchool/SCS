package simulator;

import resultsManager.report;
import systemEnum.ActTypeEnum;
import systemEnum.OpTypeEnum;

/*
 * @Meng
 * move bulldover forward, update the map, the result accordingly
 * return false: command exit due to 1)hit reserved tree, 2)out of boundary 
 */

public class command_advance{
	
		
	public command_advance() {
	
	}
	
	public boolean move_forward (bulldozer veh, sitemap map, report result, int step) {
		
		int new_pos_x;
		int new_pos_y;
		int site_size_row;
		int site_size_col;
		char land_type;
		boolean CompleteSucces = true;
		
		//get site size, (row - 1) -> maximum of pos_x
		//get site size, (col - 1) -> maximum of pos_y
		site_size_row = map.getSite_size_row();
		site_size_col = map.getSite_size_column();
		
	
		//update the result to include communication overhead
		result.operationCost(OpTypeEnum.OpComm.value);
		
		//advance one step at a time
		for (int i=0; i< step; i++) {
			veh.advance(1);
			new_pos_x = veh.getPos_x();
			new_pos_y = veh.getPos_y();
			
			//check if it is outside boundary, if so, exit advance loop
			if (!insideSite(new_pos_x, new_pos_y, site_size_row, site_size_col)) {
				//update the flag, set to false
				CompleteSucces = false;
				System.out.println("debug0");	
				//update the cost for uncleared land
				int numUncleardLand = map.getNumUnclearedLand();
				result.operationCost(numUncleardLand);
				break;
			}
			else {
				//within in site, check out the land type
				land_type = map.getLandType(new_pos_x, new_pos_y);
			}
			
			//check if hits a reserve tree, if so, exit advance loop
			if ( land_type == 'T') {
				CompleteSucces = false;
				//hit a reserved tree, update the operation cost to the result
				result.operationCost(OpTypeEnum.OpDesResTree.value);
				
				//update the cost for uncleared land
				int numUncleardLand = map.getNumUnclearedLand();
				result.operationCost(numUncleardLand);
				
				break;
			}
			
			//check if this is the last step, if not, check if the tree is hit
			if (i < (step-1)) {
				//not the last step, if hit a tree, an extra operation cost incurred
				if (land_type == 't') {
					//hit a tree and repairing paint damage required
					System.out.println("debug01");
					result.operationCost(OpTypeEnum.OpRepDmg.value);
				}
				else if(land_type == 'o') {
					//visiting a cleared land
					System.out.println("debug02");
					result.activityFuel(ActTypeEnum.ActVisCldLd.value);
				}
				else if(land_type == 'r') {
					//visiting rocky land, so clear it, update the map
					System.out.println("debug03");
					result.activityFuel(ActTypeEnum.ActClrRL.value);
					map.updateMap(new_pos_x, new_pos_y);
				}
			}
			else {
				//this is the end of operation, conduct the activity based on the type of the land
				
				if(land_type == 'o') {
					//clearing plain land
					System.out.println("debug04");
					result.activityFuel(ActTypeEnum.ActClrPL.value);				
				}
				else if(land_type == 'r') {
					//clearing rocky land, update the map
					System.out.println("debug05");
					result.activityFuel(ActTypeEnum.ActClrRL.value);
					map.updateMap(new_pos_x, new_pos_y);
				}
				else if(land_type == 't') {
					//clearing tree, update the map
					System.out.println("debug06");
					result.activityFuel(ActTypeEnum.ActClrTree.value);
					map.updateMap(new_pos_x, new_pos_y);
				}
			}
			
		}
		return CompleteSucces;
	}
	
	/*
	 * private method to check if bulldozer is inside the site
	 */
	private boolean insideSite(int x, int y, int site_row, int site_col) {
		
	
		if (x < 0 || x>= site_row) {
			return false;
			
		}
		else if (y<0 || y>= site_col) {
			return false;
		}
		
		return true;
	}
	
	
}





