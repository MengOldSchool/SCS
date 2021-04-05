package test_sitemap;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import simulator.sitemap;

/*
 * test case: stiemap -> getNumUnclearrLand()
 */

public class manual_test_sitemap_5 {

	@Test
	public void test() {
		String localDir = System.getProperty("user.dir");	
		char[][] map;
			
		
		File f = new File(localDir + "//src//data//siteMap.txt");
		
		try {
			sitemap testObj = new sitemap(f);
			testObj.showMap();
			
			//test: get the number of unclear land
			int numUnCleLand = testObj.getNumUnclearedLand();
			System.out.println();
			testObj.showMap();
			
			assertEquals(numUnCleLand, 38);
			
			//test: clear r, number of uncleared land is reduced
			boolean result = testObj.updateMap(2, 2);
			numUnCleLand = testObj.getNumUnclearedLand();
			System.out.println();
			testObj.showMap();
			
			assertEquals(result, true);
			assertEquals(numUnCleLand, 37);
			
			
			//test: clear the tree
			result = testObj.updateMap(0, 3);
			numUnCleLand = testObj.getNumUnclearedLand();
			System.out.println();
			testObj.showMap();
								
			assertEquals(result, true);
			assertEquals(numUnCleLand, 36);
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
