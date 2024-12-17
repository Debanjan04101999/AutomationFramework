package DDT;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingDataFromExcelUsingDataFormatter {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
        FileInputStream fis= new FileInputStream("C:\\Users\\LENOVO\\eclipse-workspace\\AdvanceSeleniumAutomationFrameworkDesign11AM\\src\\test\\resources\\TestData.xlsx");
		
		Workbook book= WorkbookFactory.create(fis);
		
		Sheet sheet = book.getSheet("Sheet1");
		Row row = sheet.getRow(0);
		Cell cell =row.getCell(0);
		DataFormatter f =new DataFormatter();
		String ExcelData =f.formatCellValue(cell);
		System.out.println(ExcelData);

}
}
