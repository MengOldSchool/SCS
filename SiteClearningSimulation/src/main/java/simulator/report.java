package simulator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;





public class report extends command {
	
	//private HashMap<String, List<Integer>> report = new HashMap<>();
	private HashMap<String, int[]> result = new HashMap<>();
	private static final String[] Items = { 
			"communication overhead", 
			"fuel usage",
			"unclear squares",
			"destruciton of protected tree",
			"paint damagee to builldozer"
			
	};
	
	private int[][] value = {{0,0},{0,0},{0,0},{0,0},{0,0}};
		
	/*
	 * constructor
	 */
	public report() {
		int[] init_value = {0,0};
		result.put(ActivityName[0], init_value);
	}

		
	
	/*
	 * method: generate the report
	 */
	public void printReport() {
	
		int total_cost = 0;
		
		//print out the title 
		System.out.printf("%-32s%10s%16s%n", "Item", "Quality", "Cost");
						
	
		//print out the whole table - Items & Value
		for (int i = 0; i < super.ItemName.length; i++) {
			//System.out.println(Items[i]);
			System.out.printf("%-32s%10d%16d%n", super.ItemName[i], value[i][0], value[i][1]);
			total_cost = total_cost + value[i][1];
		}
		
		//print out ---
		System.out.println("---");
		//output the total
		System.out.printf("%-32s%26d%n", "Total", total_cost);
		System.out.println();
		
		
	}
	
	/*
	 * update the report
	 */
	public void updateReport(int idx, int quality, int cost) {
		value[idx][0] = value[idx][0] + quality;
		value[idx][1] = value[idx][1] + cost; 
	}
		

}
