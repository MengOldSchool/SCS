package test_sitemap;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import simulator.sitemap;

public class sitemap_04 {

	@Test
	public void test() {
		String localDir = System.getProperty("user.dir");	
		char[][] map;
			
		
		File f = new File(localDir + "//src//data//siteMap.txt");
		
		try {
			sitemap testObj = new sitemap(f);
			map = testObj.getMyMap();
			testObj.showMap(map);
			
			boolean result = testObj.updateMap(1, 5);
			System.out.println();
			testObj.showMap(map);
			
			assertEquals(result, false);
			
			result = testObj.updateMap(2, 2);
			System.out.println();
			testObj.showMap(map);
			
			assertEquals(result, true);
			
			result = testObj.updateMap(2, 6);
			System.out.println();
			testObj.showMap(map);
								
			assertEquals(result, false);
			
			// test out of range
			result = testObj.updateMap(5, 6);
			System.out.println();
			testObj.showMap(map);
								
			assertEquals(result, false);
			
			// test out of range
			result = testObj.updateMap(2, 8);
			System.out.println();
			testObj.showMap(map);
								
			assertEquals(result, false);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
