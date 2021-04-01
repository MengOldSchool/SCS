package simulator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class sites{
	private static char[][] sites = new char[5][8];

	//private static char[][] site;
	
	/*
	 * constructor 
	 */
	public void sitemap(String inputSite) {

		
	}
	
	private static ArrayList <String> linePointer = new ArrayList<>();
	
	public static char[][] readLines(File f) throws IOException{
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		//sites = null;
		
		String line;
		int row = 0;
		int column = 0;
		//char[] curLine = null;
		
		while((line = br.readLine()) != null) {
			System.out.println(line);
			
			
			char[] curLine =line.toCharArray();
			
			sites[row] = curLine;
			linePointer.add(line);
			
			
			//for (int i = 0; i<curLine.length; i++){
			//	System.out.println(curLine[i]);
			//	sites[row][i] = curLine[i];
			//}
			row = row + 1;
			
		}
		br.close();
		fr.close();
		
		System.out.println(sites[1][5]);
		System.out.println(linePointer);
		System.out.println(linePointer.get(1));
		System.out.println(linePointer.size());
		
		char[] cur =(linePointer.get(1)).toCharArray();
		System.out.println(cur.length);
		row = linePointer.size();
		column = cur.length;
		
		char[][] myMap = new char[row][column];
		
		for (int i = 0; i<linePointer.size(); i++){
			//System.out.println(curLine[i]);
			myMap[i] = (linePointer.get(i)).toCharArray();
		}
		
		System.out.println(myMap[1][3]);
		
		
		return myMap;
	}
	
	public static void main(String[] args){
		String localDir = System.getProperty("user.dir");
		
		char[][] newMap;
		
		File f = new File(localDir + "//src//data//siteMap.txt");
		try {
			newMap = readLines(f);
			System.out.println(newMap[2][1]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(newMap);
	}

}
