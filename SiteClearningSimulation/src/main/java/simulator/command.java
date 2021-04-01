package simulator;

import java.util.HashMap;

public class command {
	final int[] item_comm_overhead = {0, 1};
	final int[] item_fuel = {1, 1};
	final int[] item_unclear_square = {2, 3};
	final int[] item_des_res_tree = {3, 10};
	final int[] item_repare = {4, 2};
	
	//Activity Table
	//Activity vs Fuel Usage
	final HashMap <String, Integer> ActivityFuel = new HashMap<>();
	final String[] ActivityName = new String[4];
	
	//Operation Table
	//Item vs Cost
	final String[] ItemName = new String[5];
	final HashMap <String, Integer> ItemCost = new HashMap<>();
	
	public command(){
		//Init Activity Table
		ActivityName[0] = "Cleaning plain land";
		ActivityName[1] = "Visting any land that has already been cleard";
		ActivityName[2] = "Clearning rocky land";
		ActivityName[3] = "Clearning land containg a tree";
		
		ActivityFuel.put(ActivityName[0], 1);
		ActivityFuel.put(ActivityName[1], 1);
		ActivityFuel.put(ActivityName[2], 2);
		ActivityFuel.put(ActivityName[3], 2);
		
		//Init Operation table
		ItemName[0]= "communication overhead";
		ItemName[1]= "fuel usage";
		ItemName[2]= "unclear squares";
		ItemName[3]= "destruciton of protected tree";
		ItemName[4]= "paint damagee to builldozer";
		
		ItemCost.put(ItemName[0], 1);
		ItemCost.put(ItemName[1], 1);
		ItemCost.put(ItemName[2], 3);
		ItemCost.put(ItemName[3], 10);
		ItemCost.put(ItemName[0], 2);
		
	}

	public String[] getActivityName() {
		return ActivityName;
	}

	public String[] getItemName() {
		return ItemName;
	}
	
	public void operationCost(String operation) {};
	
	public void printReport() {};
	
}
