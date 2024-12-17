package genericUtilities;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WebDriver_Utility {
	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method is used to wait for page to load
	 * @param driver
	 */
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	/**
	 * THis method is used to switch windows
	 * @param driver
	 * @param partialTitle
	 */
	public void windowSwtiching(WebDriver driver, String partialTitle) {
		Set<String> allWins = driver.getWindowHandles();
		Iterator<String> id = allWins.iterator();

		while (id.hasNext()) {
			String win = id.next();
			driver.switchTo().window(win);
			String title = driver.getTitle();
			if (title.contains(partialTitle))

			{
				break;
			}
		}
	}

}
