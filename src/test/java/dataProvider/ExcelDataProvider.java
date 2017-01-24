package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelDataProvider {
	
	/*The main purpose of constructor is that when ever the object is created for this class, 
	the constructor is called automatically and the files are loaded*/
	
	Workbook wb;
	
	public ExcelDataProvider(){
		/* . means it is available inside the project home directory */
		
		File src = new File("./ApplicationTestData/AppData.xlsx");
		try {
			FileInputStream fis = new FileInputStream(src);
			wb = WorkbookFactory.create(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		
		}	
	}
	
	public String getData(int sheetIndex, int rownum, int colnum){
		String data = wb.getSheetAt(sheetIndex).getRow(rownum).getCell(colnum).getStringCellValue();
		return data; 
	}
	
	public String getData(String sheetName, int rownum, int colnum){
		String data = wb.getSheet(sheetName).getRow(rownum).getCell(colnum).getStringCellValue();
		return data; 
	}

}
