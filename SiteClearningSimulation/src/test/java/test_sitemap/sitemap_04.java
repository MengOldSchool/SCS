package test_sitemap;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import simulator.sitemap;

/*
 * test case: sitemap -> updateMap()
 */
public class sitemap_04 {

	@Test
	public void test() {
		String localDir = System.getProperty("user.dir");	
			
		
		File f = new File(localDir + "//src//data//siteMap.txt");
		
		try {
			sitemap testObj = new sitemap(f);
			testObj.showMap();
			
			//test: clear T
			boolean result = testObj.updateMap(1, 5);
			System.out.println();
			testObj.showMap();
			
			assertEquals(result, false);
			
			//test: clear r
			result = testObj.updateMap(2, 2);
			System.out.println();
			testObj.showMap();
			
			assertEquals(result, true);
			
			//test: clear T
			result = testObj.updateMap(2, 6);
			System.out.println();
			testObj.showMap();
								
			assertEquals(result, false);
			
			//test: clear the tree
			result = testObj.updateMap(0, 3);
			System.out.println();
			testObj.showMap();
								
			assertEquals(result, true);
			
			
			// test out of range
			result = testObj.updateMap(5, 6);
			System.out.println();
			testObj.showMap();
								
			assertEquals(result, false);
			
			// test out of range
			result = testObj.updateMap(2, 8);
			System.out.println();
			testObj.showMap();
								
			assertEquals(result, false);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
