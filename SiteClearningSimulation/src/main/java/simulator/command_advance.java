package simulator;

import java.util.Arrays;

public class command_advance extends command{
	
	private boolean CompleteSucces;
	private int credit;
	
	public command_advance() {
		this.CompleteSucces = true;
		this.credit = 1; //by default, 1 credit for a new command
	}
	
	public void move_forward (bulldozer veh, sitemap map, report cost, int step) {
		
		int cur_pos_x;
		int cur_pos_y;
		int new_pos_x;
		int new_pos_y;
		int site_size_row;
		int site_size_col;
		char land_type;
		
		//get current x, y of bulldozer
		cur_pos_x = veh.getPos_x();
		cur_pos_y = veh.getPos_y();
		
		//get site size, (row - 1) -> maximum of pos_x
		//get site size, (col - 1) -> maximum of pos_y
		site_size_row = map.getSite_size_row();
		site_size_col = map.getSite_size_column();
		
	
		//advance one step at a time
		for (int i=0; i<=step; i++) {
			veh.advance(1);
			new_pos_x = veh.getPos_x();
			new_pos_y = veh.getPos_y();
			land_type = map.getLandType(cur_pos_x, cur_pos_y);
			
			//check if it is outside boundary, if so, exit advance loop
			if (!insideSite(new_pos_y, new_pos_y, site_size_row, site_size_col)) {
				this.CompleteSucces = false;
				break;
			}
			
			//check if hits a reserve tree, if so, exit advance loop
			if ( land_type == 'T') {
				this.CompleteSucces = false;
				this.credit = this.credit + 10;
				break;
			}
			
			//check if this is the last step, if not, check if the tree is hit
			if (i < step) {
				if (land_type == 't') {
					cost.updateReport(super.item_repare[0], 1, super.item_repare[1]);
				}
			}
			else {
				if(land_type == 't') {
					cost.updateReport(super.item_fuel[0], 1, 1);
				}
			}
			
		}
	}
	
	private boolean insideSite(int x, int y, int site_row, int site_col) {
		
		if (x<0 || x>=site_row) {
			return false;
		}
		else if (y<=0 || y>=site_col) {
			return false;
		}
		
		return true;
	}
	
	private int activity(String act) {
		return super.ActivityFuel.get(act);
	}
}





