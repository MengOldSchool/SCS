package test_sitemap;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import simulator.sitemap;

public class manual_test_sitemap_3 {

	@Test
	public void test() {
		String localDir = System.getProperty("user.dir");	
		
		File f = new File(localDir + "//src//data//siteMap.txt");
		
		try {
			sitemap testObj = new sitemap(f);
			testObj.showMap();
			
			boolean result = testObj.updateMap(0, 3);
			System.out.println();
			testObj.showMap();
			
			assertEquals(result, true);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	
	}

}
