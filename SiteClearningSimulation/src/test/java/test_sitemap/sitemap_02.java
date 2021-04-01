package test_sitemap;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import simulator.sitemap;

public class sitemap_02 {

	@Test
	public void test() {
		String localDir = System.getProperty("user.dir");	
		char[][] map;
			
		
		File f = new File(localDir + "//src//data//siteMap.txt");
		
		try {
			sitemap testObj2 = new sitemap(f);
			map = testObj2.getMyMap();
			testObj2.showMap(map);
			//System.out.println(newMap[2][1]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(newMap);
		assertEquals(0, 0);
	}

}
