package test_sitemap;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import simulator.sitemap;

/*
 * test case: stiemap -> getNumUnclearrLand()
 */

public class Test_sitemap_05 {

	@Test
	public void test() {
		char[][] expected = {
				{'o', 'o', 'o', 't','o', 'o', 'o','o',}, 
				{'o', 'o', 'o', 'o','o', 'T', 'o','o',},
				{'r', 'r', 'r', 'o','o', 'o', 'T','o',},
				{'r', 'r', 'r', 'r','r', 'o', 'o','o',},
				{'r', 'r', 'r', 'r','r', 'r', 'o','o',} 
				};
		
		
		String localDir = System.getProperty("user.dir");	
		char[][] map;
			
		
		File f = new File(localDir + "//src//data//siteMap.txt");
		
		try {
			sitemap testObj = new sitemap(f);
			
			//test: get the number of unclear land
			int numUnCleLand = testObj.getNumUnclearedLand();
			assertEquals(numUnCleLand, 38);
			
			//test: clear r, number of uncleared land is reduced
			boolean result = testObj.updateMap(2, 2);
			numUnCleLand = testObj.getNumUnclearedLand();
			assertEquals(result, true);
			assertEquals(numUnCleLand, 37);
			
			
			//test: clear the tree
			result = testObj.updateMap(0, 3);
			numUnCleLand = testObj.getNumUnclearedLand();
			assertEquals(result, true);
			assertEquals(numUnCleLand, 36);
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
