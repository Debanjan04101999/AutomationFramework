package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InsertingMultipleDataToExcelSheet {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("C:\\Users\\LENOVO\\eclipse-workspace\\AdvanceSeleniumAutomationFrameworkDesign11AM\\src\\test\\resources\\TestData.xlsx");

		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet2");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();

		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));

		for (int i = 0; i < allLinks.size(); i++) {
			Row row = sheet.createRow(i);
			Cell cell = row.createCell(0);
			cell.setCellValue(allLinks.get(i).getAttribute("href"));
		}

		FileOutputStream fos = new FileOutputStream("C:\\Users\\LENOVO\\eclipse-workspace\\AdvanceSeleniumAutomationFrameworkDesign11AM\\src\\test\\resources\\TestData.xlsx");
		book.write(fos);
		book.close();
	}

}
