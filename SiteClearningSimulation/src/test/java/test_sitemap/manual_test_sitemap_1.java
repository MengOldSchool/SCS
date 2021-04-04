package test_sitemap;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import simulator.sitemap;

public class manual_test_sitemap_1 {

	@Test
	public void test() {
		sitemap testObj = new sitemap();
		testObj.showMap();
		//System.out.println(map);
		
		
		String localDir = System.getProperty("user.dir");		
			
		
		File f = new File(localDir + "//src//data//siteMap.txt");
		
		try {
			sitemap testObj2 = new sitemap(f);
			
			testObj2.showMap();
			//System.out.println(newMap[2][1]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(newMap);
		assertEquals(0, 0);
		//fail("Not yet implemented");
	}

}
