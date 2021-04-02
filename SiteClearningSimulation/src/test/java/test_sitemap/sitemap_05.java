package test_sitemap;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import simulator.sitemap;

/*
 * test case: stiemap -> getNumUnclearrLand()
 */

public class sitemap_05 {

	@Test
	public void test() {
		String localDir = System.getProperty("user.dir");	
		char[][] map;
			
		
		File f = new File(localDir + "//src//data//siteMap.txt");
		
		try {
			sitemap testObj = new sitemap(f);
			map = testObj.getMyMap();
			testObj.showMap(map);
			
			//test: get the number of unclear land
			int numUnCleLand = testObj.getNumUnclearedLand();
			System.out.println();
			testObj.showMap(map);
			
			assertEquals(numUnCleLand, 15);
			
			//test: clear r, number of uncleared land is reduced
			boolean result = testObj.updateMap(2, 2);
			numUnCleLand = testObj.getNumUnclearedLand();
			System.out.println();
			testObj.showMap(map);
			
			assertEquals(result, true);
			assertEquals(numUnCleLand, 14);
			
			
			//test: clear the tree
			result = testObj.updateMap(0, 3);
			numUnCleLand = testObj.getNumUnclearedLand();
			System.out.println();
			testObj.showMap(map);
								
			assertEquals(result, true);
			assertEquals(numUnCleLand, 13);
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
