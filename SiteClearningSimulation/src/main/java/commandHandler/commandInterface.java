package commandHandler;

/*
 * @Meng
 * abstract class, define all the command interfaces
 */


abstract class commandInterface {
	
	/*
	 * constructor 
	 */
	public commandInterface (){
		
	}
	
	
	/*
	 * execute the command
	 */
	public void action() {
		
	}
	
	/*
	 * return the status of the command, default is true
	 * true: continue next operation
	 * false: 
	 * 	1)after quite command
	 * 	2)advance command is invalid, e.g outside the boundary 
	 *  
	 */
	public boolean getStatus() {
		return true;
	}
	
		
	/*
	 * decode the command,e.g getting advance step from the command
	 */
	void decodeCmd() {
		
	}

}
