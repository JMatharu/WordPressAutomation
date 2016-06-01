package login;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import common.WPAppiumTemplate;
import common.tests.ReadFromCSV;
import helperPage.LoginHelperPage;

/**
 * Login Helper needs to be extended by all Test Classes
 * 
 * Purpose: 1) Log in to application 2) Will Run tests 3) Close Driver
 * 
 * @author jmatharu - Jagdeep Singh Matharu
 *
 */
public class LoginHelper extends WPAppiumTemplate {

	LoginHelperPage loginHelperPageObject;
	ReadFromCSV readFromCSVObject;

	/**
	 * Log in to application before any test to run
	 */
	@BeforeClass(alwaysRun = true)
	public void login() {
		loginHelperPageObject = new LoginHelperPage(driver);
		readFromCSVObject = new ReadFromCSV();
		// Enter User Name
		loginHelperPageObject.enterUserName(readFromCSVObject.getLoginUserName());
		// Enter Password
		loginHelperPageObject.enterPassword(readFromCSVObject.getLoginPassword());
		// Click Sign-in
		loginHelperPageObject.clickSignIn();

	}

	/**
	 * Close Driver
	 */
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
}
