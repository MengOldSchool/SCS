package resultsManager;

import java.util.HashMap;

/*
 * @Meng
 * report class:
 * calculate costs and fuel usage based on Operation and Activity type
 * update the result
 * generate the final report
 */



public class report extends reportTables {
	
	//private HashMap<String, List<Integer>> report = new HashMap<>();
	//Two Result tables 
	//result_quantity: ItemName, Quality, 
	//result_cost: ItemName, Cost
	private HashMap<String, Integer> result_quantity = new HashMap<>();
	private HashMap<String, Integer> result_cost = new HashMap<>();
		
	/*
	 * constructor: init result quantity and result cost tables
	 */
	public report() {
		
		for (int i=0; i < (super.ItemName).length; i++){
			result_quantity.put((super.ItemName)[i], 0);
			result_cost.put((super.ItemName)[i], 0);
		}
	}
	
	
	/*
	 * method: generate the report
	 */
	public void printReport() {
	
		int total_cost = 0;
		
		//print out the title 
		System.out.printf("%-32s%10s%16s%n", "Item", "Quantity", "Cost");
	
		//print out the whole table - Items & Value
		for (int i = 0; i < result_cost.size(); i++) {
			System.out.printf("%-32s%10d%16d%n", super.ItemName[i], result_quantity.get(ItemName[i]), result_cost.get(ItemName[i]));
			total_cost = total_cost + result_cost.get(super.ItemName[i]);
		}
		
		//print out ---
		System.out.println("---");
		//output the total
		System.out.printf("%-32s%26d%n", "Total", total_cost);
		System.out.println();
		
		
	}
	
	/*
	 * update the result for operation cost
	 */
	public void operationCost(String operation) {
		
		int cost= result_cost.get(operation) + (super.ItemCost).get(operation);
		int quantity = result_quantity.get(operation) + 1;
	
		result_cost.put(operation, cost);
		result_quantity.put(operation, quantity);
	}
	
	public void operationCost(int numUnclearedLand) {
			
		String operation = super.ItemName[2];
		
		int cost= result_cost.get(operation) + ((super.ItemCost).get(operation))*numUnclearedLand;
		int quantity = result_quantity.get(operation) + numUnclearedLand;
	
		result_cost.put(operation, cost);
		result_quantity.put(operation, quantity);
}
	/*
	 * update the result for activity fuel
	 */
	public void activityFuel(String activity) {
		//get item to be updated in the result tables - Fuel Item
		String fuel_item = super.ItemName[1];
		
		//calculate the new fuel consumption
		int fuel = result_cost.get(fuel_item) + (super.ActivityFuel).get(activity);
		int quantity = result_quantity.get(fuel_item) + (super.ActivityFuel).get(activity);
		//update the result tables
		result_cost.put(fuel_item, fuel);
		result_quantity.put(fuel_item, quantity);
	}


	public HashMap<String, Integer> getResult_quantity() {
		return result_quantity;
	}

	public HashMap<String, Integer> getResult_cost() {
		return result_cost;
	}

	
	

}
