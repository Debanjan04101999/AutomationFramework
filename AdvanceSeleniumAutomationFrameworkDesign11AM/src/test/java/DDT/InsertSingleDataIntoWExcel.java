package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertSingleDataIntoWExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
FileInputStream fis= new FileInputStream("C:\\Users\\LENOVO\\eclipse-workspace\\AdvanceSeleniumAutomationFrameworkDesign11AM\\src\\test\\resources\\TestData.xlsx");
		
		Workbook book= WorkbookFactory.create(fis);
		
		Sheet sheet = book.getSheet("Sheet1");
		Row row = sheet.createRow(5);
		Cell cell = row.createCell(5);
		cell.setCellValue("Qspiders");
		
		FileOutputStream fos= new FileOutputStream("C:\\Users\\LENOVO\\eclipse-workspace\\AdvanceSeleniumAutomationFrameworkDesign11AM\\src\\test\\resources\\TestData.xlsx");
		book.write(fos);
		book.close();
	}

}
