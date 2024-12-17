/* Login to vtiger application->mouseOverOn more Link->click on campaigns->
 * click on create campaign lookup image->Enter campaignName->click on save Btn->
 * verify whether the campaign is created in campaign Information page and Logout from the application. */
package Campaing;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import genericUtilities.BaseClass;
import genericUtilities.Excel_Utility;
import genericUtilities.File_Utility;
import genericUtilities.Java_Utility;
import genericUtilities.WebDriver_Utility;
import objectRepository.CampDetailedPage;
import objectRepository.CampValidatePage;
import objectRepository.CreateCampPage;
import objectRepository.LoginVtigerPage;
import objectRepository.VtigerHomePage;

public class CreateCapaign  extends BaseClass{

	@Test
	public void createCampaignTest() throws Throwable {

		WebDriver_Utility wlib = new WebDriver_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();
		File_Utility flib = new File_Utility();


		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickMoreLink();
		home.clickCampLink();

		CampDetailedPage img = new CampDetailedPage(driver);
		img.clickCampLookUpImg();

		int ranNum = jlib.getRandomNum();
//----------------------------------------------------------------------------------------------------------		

		String CampName = elib.readExcelData("Campaign", 0, 0) + ranNum;

		CreateCampPage createPage = new CreateCampPage(driver);
		createPage.enterCampName(CampName);

		createPage.clickSaveButton();

		CampValidatePage validate = new CampValidatePage(driver);
		validate.validateCampaign(driver, CampName);

	}
}

