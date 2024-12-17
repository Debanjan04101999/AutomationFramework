package DDT;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingSingleDataFromWExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		
FileInputStream fis= new FileInputStream("C:\\Users\\LENOVO\\eclipse-workspace\\AdvanceSeleniumAutomationFrameworkDesign11AM\\src\\test\\resources\\TestData.xlsx");
		
		Workbook book= WorkbookFactory.create(fis);
		String getcellvalue =book.getSheet("Sheet1").getRow(0).getCell(0).getStringCellValue();
		System.out.println(getcellvalue);
		
	}

}
