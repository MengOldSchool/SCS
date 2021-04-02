package simulator;

import org.junit.Test;

/***********************
 * @author meng
 * bulldozer class
 * pos_x , row index -1 -> out of map
 * pos_y, column, -1 -> out of map
 * direction (degree):
 *  0 -> east facing
 *  90 -> north facing
 *  180 -> west facing
 *  270 -> south facing
 */

public class bulldozer{
	
	private int pos_x; //0, row - 0
	private int pos_y; //0, column - 0
	private int direction;
	
	//constructor 
	public bulldozer() {
		this.pos_x = 0;
		this.pos_y = -1;
		this.direction = 0;		
	}
	
	//?????????, further error handing is required ?????
	public bulldozer(int x, int y, int dir) {
		this.pos_x = x;
		this.pos_y = y;
					
		this.direction = dir;
	}
	
	/*
	 * turn left, anti clock wise direction, increase the direction degree
	 */
	public void turnleft() {
		direction = direction + 90;
		//reset direction = 0 if its value is 360 degree
		if (direction >= 360) {
			direction = 0;
		}
	}
	
	/*
	 * turn right, clockwise direction, decrease the direction degree
	 */
	public void turnright() {
		direction = direction - 90;
		//reset direction = 0 if its value is 360 degree
		if (direction < 0) {
			direction = direction + 360;
		}
	}
	
	/*
	 * advance: take a positive integer, move the bulldozer alone its current direction
	 */
	public void advance(int step) {
		if (step <0) {
			wrongcommand();
		}
		else {
			//current direction = 0, move left, hence increase y(column)
			if (direction == 0) {pos_y = pos_y + step;}
			//current direciton = 90, move up, hence decrease x(row)
			else if(direction == 90) {pos_x = pos_x - step;}
			//current direction = 180, move right, hence decrease y(column)
			else if(direction == 180) {pos_y = pos_y - step;}
			//current dreiciton = 270, move down, hence increae x(row)
			else if (direction == 270) {pos_x = pos_x + step;}
			else {
				wrongcommand();
			}
		}
		
	}
	
	/*
	 * quit the simulation, return the bulldozer to the starting point
	 */
	public void quit() {
		this.pos_x = 0;
		this.pos_y = -1;
		this.direction = 0;
	}
	
	/*
	 * error handling
	 */
	private void wrongcommand() {
		System.out.println("wrong command");
	}

	//standard getter methods
	public int getPos_x() {
		return pos_x;
	}

	public int getPos_y() {
		return pos_y;
	}

	public int getDirection() {
		return direction;
	}
	
	@Test
	public void whereIsVeh() {
		System.out.println("dir= " + this.direction + " degree,"+ " pos_x =" +  this.pos_x + ", pos_y = " + this.pos_y);
			
	}

}
