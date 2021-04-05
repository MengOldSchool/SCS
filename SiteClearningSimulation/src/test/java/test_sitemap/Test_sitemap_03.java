package test_sitemap;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import simulator.sitemap;

/*
 * test: updateMap methond
 */

public class Test_sitemap_03 {

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
		
		File f = new File(localDir + "//src//data//siteMap.txt");
		
		try {
			sitemap testObj = new sitemap(f);
			
			boolean result = testObj.updateMap(0, 3);
			char landtype = testObj.getLandType(0, 3);
		
			assertEquals(result, true);
			assertEquals(landtype, 'y');
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	
	}

}
