package simulator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/************
 * 
 * @author meng
 * create sitemap - 2d char array
 * size of row --> max of pos_x + 1
 * size of column -> max of pos_y + 1
 * pos_x, pos_y inputs to the class
 * pos_x: index of row, starting from 0
 * pos_y: index of column, starting from 0
 *
 */
public class sitemap {
	
	private static char[][] myMap;
	private static int site_size_row;
	private static int site_size_column;



	/*
	 * constructor for static test
	 */
	public sitemap() {
		site_size_column = 1;
		site_size_row = 1;
		//myMap = new char[site_size_row][site_size_column];
		myMap = new char[][] {{'o', 'o'}, {'t', 't'}};
		
			
	}
	
	/*
	 * constructor - read the text file as input	
	 */
	public sitemap(File f) throws IOException{
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		ArrayList <String> linePointer = new ArrayList<>();
		String line;
		
			
		while((line = br.readLine()) != null) {
			//System.out.println(line);
			linePointer.add(line);					
		}
		br.close();
		fr.close();
		
			
		//find the sizes (row, column) of the map
		site_size_row = linePointer.size();
		//????? need to check the consistence of all lines ????
		char[] cur =(linePointer.get(1)).toCharArray();
		site_size_column = cur.length;
		
		//create a new map with the right size and assign the land type
		myMap = new char[site_size_row][site_size_column];
		for (int i = 0; i<linePointer.size(); i++){
			//System.out.println(curLine[i]);
			myMap[i] = (linePointer.get(i)).toCharArray();
		}	
				
	}
	
	/*
	 * method to update the map based on the command
	 * return true if the update is successful
	 */
	public boolean updateMap(int pos_x, int pos_y) {
		//check if the update is alowed
		if (pos_x <= (this.site_size_row -1) && pos_y <=(this.site_size_column - 1)) {
			if (this.myMap[pos_x][pos_y] != 'T'){
				this.myMap[pos_x][ pos_y] = 'o';
				return true;
			}
			else
			{
				return false;
			}
		}
		else {
			return false;
		}
	
	}
	
	/*
	 * method to show the map
	 */
	public void showMap(char[][] map) {
		for (int row=0; row<map.length; row++) {
			for (int col=0; col<map[row].length; col++) {
				System.out.print(map[row][col]);
			}
			System.out.println();
		}
	}
	
	
	/*
	 * get the type of land
	 */
	public char getLandType(int x, int y) {
		return myMap[x][y];
	}
	/*
	 * getter: return the map pointer
	 */
	public char[][] getMyMap() {
		return myMap;
	}

	public int getSite_size_row() {
		return site_size_row;
	}

	
	public int getSite_size_column() {
		return site_size_column;
	}

	
	

	
}
	
	

