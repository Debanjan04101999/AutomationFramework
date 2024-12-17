package DDT;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.annotations.Test;

public class FetchingDataFromPDF {
	@Test
	public void FetchingDataFromPDF() throws IOException {
		
		File fis = new File("C:\\Users\\LENOVO\\eclipse-workspace\\AdvanceSeleniumAutomationFrameworkDesign11AM\\src\\test\\resources\\multipage-pdf.pdf");
		PDDocument doc =PDDocument.load(fis);
		int pages =doc.getNumberOfPages();
		System.out.println(pages);
		
		PDFTextStripper pdfData = new PDFTextStripper();
		String readData = pdfData.getText(doc);
		System.out.println(readData);

//		pdfData.setStartPage(3);
//		String readData = pdfData.getText(doc);
//		System.out.println(readData);

			pdfData.setStartPage(1);
			pdfData.setEndPage(2);
			String readData1 = pdfData.getText(doc);
			System.out.println(readData1);
		
	}

}
