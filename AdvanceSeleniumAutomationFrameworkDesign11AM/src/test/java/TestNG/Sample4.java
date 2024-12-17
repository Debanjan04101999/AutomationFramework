package TestNG;

import org.testng.annotations.Test;

public class Sample4 {
	@Test
	public void createContact()
	{

	System.out.println("contact created");

	}

	@Test(dependsOnMethods = "createContact")
	public void modifyContact()
	{
		System.out.println("modify contact");
	}
	
	@Test(dependsOnMethods = "createContact")
	public void deleteContact()
	{
		System.out.println("delete contact");
	}

}
