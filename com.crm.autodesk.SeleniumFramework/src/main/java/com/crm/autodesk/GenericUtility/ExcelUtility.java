package com.crm.autodesk.GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * Its developed using Apache POI libraries, which used to handle Microsoft Excel Sheet
 * @author Shakir
 *
 */

public class ExcelUtility {
	/**
	 * Its used to read the data from excel based on below arguments
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return 
	 * @throws Throwable
	 */
	public String getExcelData(String sheetName, int rowNum, int cellNum) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstants.EXCEL_PATH);
		Workbook book=WorkbookFactory.create(fis);
		DataFormatter format=new DataFormatter();
		return format.formatCellValue(book.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
	}
	/**
	 * Used to get the last used row number on specified sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.EXCEL_PATH);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetName);
		book.close();
		return sh.getLastRowNum();
	}
	
	/**
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws Throwable
	 */
	public void setExcelData(String sheetName, int rowNum, int cellNum, String data) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.EXCEL_PATH);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(IPathConstants.EXCEL_PATH);
		book.write(fos);
		book.close();
		
	}
	
}




