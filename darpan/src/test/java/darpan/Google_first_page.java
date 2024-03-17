package darpan;


import java.io.IOException;

import org.testng.annotations.BeforeClass;

import Base.Test_Base1;

public class Google_first_page extends Test_Base1 {
	
	@BeforeClass
	public void launchBrowser() throws IOException {
		Test_Base1 tbase1= new Test_Base1();
		tbase1.Base_url();
		
	}
}
		
		
