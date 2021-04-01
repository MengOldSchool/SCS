package simulator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//https://stackoverflow.com/questions/35034212/how-to-create-a-hashmap-in-java-class
public class trainee {
	
	
	/*
	 * constructor
	 */
	public trainee() {
	}
	
	
	
	public void operateBulldozer(CmdType cmd, bulldozer veh, sitemap map, report outcome) {
		List<Integer> result = null;
		
		switch (cmd) {
		case a:
			result = cmd_a(veh, map);
			//outcome.updateReport(result);
			break;
		case r:
			break;
		case l:
			break;
		case q:
			break;
		default:
			break;
	
		}
	}
	
	private List<Integer> cmd_a(bulldozer veh, sitemap map){
		List<Integer> result = null;
		
		return result;
	}
}


