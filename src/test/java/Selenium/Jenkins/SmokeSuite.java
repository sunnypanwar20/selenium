package Selenium.Jenkins;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SmokeSuite {

	@Test(dataProvider = "sunny",groups= {"Smoke","Regression"})
	public static void smoke1(String firstname, String lastname) {

		System.out.println("my firstname is " + firstname + " and my lastname is " + lastname + "");

	}

	@DataProvider(name = "sunny")
	public Object[][] getData() {
		return new Object[][] { { "sunny", "panwar" },{"rahul","panwar"},{"pooja","panwar"}};
	}

}
