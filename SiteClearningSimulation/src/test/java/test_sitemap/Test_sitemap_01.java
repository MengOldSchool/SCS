package test_sitemap;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import simulator.sitemap;

public class Test_sitemap_01 {

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
			int site_row = testObj.getSite_size_row();
			int site_col = testObj.getSite_size_column();
			
			
			assertEquals(site_row, 5);
			assertEquals(site_col, 8);
		
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//System.out.println(newMap);
		
		
	}

}
