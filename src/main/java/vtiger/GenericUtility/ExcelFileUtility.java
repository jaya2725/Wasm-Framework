package vtiger.GenericUtility;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This method is used to read data from excelsheet  and return the value
 * @author Jaya
 *
 */

public class ExcelFileUtility {
	public String getDataFromExcel(String sheet,int row,int cel) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(ConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		 Sheet s = wb.getSheet(sheet);
		 Row r = s.getRow(row);
		 Cell cell = r.getCell(cel);
		 String value = cell.getStringCellValue();
		
		
		 return value;
	}
	/**
	 * This method will return the last row number in particular sheet
	 * @param sheet
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public int getRowCount(String sheet) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(ConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		 Sheet s = wb.getSheet(sheet);
		int lastRow = s.getLastRowNum();
		return lastRow;
	}
	/**
	 * This method will write data into the excel sheet
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	public void  writeDataToExcel(String sheet,int row,int cel) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(ConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		 Sheet s = wb.getSheet(sheet);
		 Row r = s.getRow(row);
		 Cell cell = r.getCell(cel);
		 String value = cell.getStringCellValue();
		 FileOutputStream fos=new FileOutputStream(ConstantsUtility.ExcelFilePath);
		 wb.write(fos);
		 wb.close();
		
	}
	//This method is used to read multiple data in same script
	public Object[][] readMultipleDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(ConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[lastRow][lastCell];
		
		for(int i=0;i<lastRow;i++)
		{ 
			for(int j=0;j<lastCell;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		
		return data;
	}
}
		
	
	
	
	

