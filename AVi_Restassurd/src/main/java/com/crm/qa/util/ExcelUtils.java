package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.crm.qa.base.TestBase;

public class ExcelUtils extends TestBase{

	private static Sheet ExcelWSheet;
	private static Workbook ExcelWBook;
	private static Cell Cellx;
	private static Row Rowx;

	//static WebDriver driver;

	public ExcelUtils (WebDriver superDriver)
	{
		driver = superDriver;
	}

	//This method is to set the XLSX File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method

	public void setExcelFile(String Path,String SheetName) throws Exception {

		try {
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = WorkbookFactory.create(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		} catch (Exception e){
			throw (e);
		}
	}

	//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num

	public String getCellData(int RowNum, int ColNum) throws Exception{
		DataFormatter df = new DataFormatter();
		try{
			Cellx = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = df.formatCellValue(Cellx);
			return CellData;
		}catch (Exception e){
			return"";
		}
	}


	public String getCellDataString(int RowNum, int ColNum) throws Exception{

		try{
			Cellx = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cellx.getStringCellValue();
			return CellData;
		}catch (Exception e){
			return"";
		}

	}

	// Different Types of Methods to Fetch Data

	public String getFirstRowDataUsingColumnName(String colName) throws Exception{

		String getData="";

		try{
			int Row1 = ExcelWSheet.getFirstRowNum();
			int Row2 = ExcelWSheet.getRow(Row1).getLastCellNum();

			for(int i=Row1;i<=Row2;i++)
			{
				Cellx = ExcelWSheet.getRow(Row1).getCell(i);

				String CellData = Cellx.getStringCellValue();
				if (CellData.trim().equalsIgnoreCase(colName))
				{
					Cellx = ExcelWSheet.getRow((Row1+1)).getCell(i);
					String CellData1 = Cellx.getStringCellValue();
					getData= CellData1;
					return getData;
				}

			}
		}
		catch (Exception e){
			return "";
		}
		return "";
	}

	public ArrayList<String> getColumnDataUsingColumnName(String colName) throws Exception{

		ArrayList<String> getData = new ArrayList<String>();
		int lastRow = ExcelWSheet.getPhysicalNumberOfRows();
		System.out.println("Last Row in Excel sheet is : "+ lastRow);

		try{
			int Row1 = ExcelWSheet.getFirstRowNum();
			int Row2 = ExcelWSheet.getRow(Row1).getLastCellNum();
			for(int i=Row1;i<=Row2;i++)
			{
				Cellx = ExcelWSheet.getRow(Row1).getCell(i);
				String CellData = Cellx.getStringCellValue();
				if (CellData.trim().equalsIgnoreCase(colName))
				{
					for(int j=Row1+1; j<lastRow; j++)
					{
						Cellx = ExcelWSheet.getRow(j).getCell(i);
						String CellData1 = Cellx.getStringCellValue();
						System.out.println("### Data Read From Excel for row : " + j + ": "+ CellData1);
						getData.add(CellData1);
					}
					break;
				}
			}
			return getData;
		}
		catch (Exception e){
			System.out.println(" Exception occured durong reading data from Excel.");
			return null;
		}
	}

	public ArrayList<String> getRowDatausingRowName(String rowName, int column) throws Exception{

		ArrayList<String> getData = new ArrayList<String>();
		int lastRow = ExcelWSheet.getPhysicalNumberOfRows();
		System.out.println("Last Row in Excel sheet is : "+ lastRow);

		try{
			int Row1 = ExcelWSheet.getFirstRowNum();		
			int LastCol = ExcelWSheet.getRow(Row1).getLastCellNum();

			System.out.println("First Row : " + Row1);
			System.out.println("Last Column in First Row : " + LastCol);

			for(int i=Row1;i<=lastRow;i++)
			{
				Cellx = ExcelWSheet.getRow(i).getCell(column);
				String CellData = Cellx.getStringCellValue();
				System.out.println("##Cell Data : "+ CellData);

				if (CellData.trim().equalsIgnoreCase(rowName))
				{
					for(int j=column+1; j<LastCol; j++)
					{
						Cellx = ExcelWSheet.getRow(i).getCell(j);
						String CellData1 = Cellx.getStringCellValue();
						System.out.println("### Data Read From Excel for row : " + i + ": "+ CellData1);
						getData.add(CellData1);
					}
					break;
				}
			}
			return getData;
		}
		catch (Exception e){
			System.out.println(" Exception occured durong reading data from Excel.");
			return null;
		}
	}

	//This Function is used to add results to the excel file

	public void setCellDataXLSX(String Result,  int RowNum, int ColNum) throws Exception	{
		try{
			Rowx = ExcelWSheet.getRow(RowNum);
			Cellx = Rowx.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
			if (Cellx == null) {
				Cellx = Rowx.createCell(ColNum);
				Cellx.setCellValue(Result);
			} else {
				Cellx.setCellValue(Result);
			}
			FileOutputStream fileOut = new FileOutputStream(System.getProperty("user.dir")+prop.getProperty("testdata_excel"));
			ExcelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		}catch(Exception e){
			throw (e);
		}
	}
	
	// This function is to read entire sheet content and return as 2d Array of Objects
	
	public Object[][] getTestData() throws EncryptedDocumentException {

		Object[][] data = new Object[ExcelWSheet.getLastRowNum()][ExcelWSheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < ExcelWSheet.getLastRowNum(); i++) {
			for (int k = 0; k < ExcelWSheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = ExcelWSheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}

	// This function is to read Locator and return web element from Object Repo File

	public WebElement readXpathandReturnElement(String objects) throws Exception	{

		String type = "";
		String actLoc = "";
		try{

			int lastRow = ExcelWSheet.getLastRowNum();
			System.out.println("Last Row" + lastRow);
			for(int i =1; i<(lastRow+1);i++)
			{
				Rowx = ExcelWSheet.getRow(i);
				Cellx = Rowx.getCell(0);
				System.out.println(Cellx.toString()+" ########### ");
				if(Cellx.toString().equalsIgnoreCase(objects))
				{
					type   = Rowx.getCell(1).toString().toLowerCase();
					actLoc = Rowx.getCell(2).toString();
					System.out.println("Located Identified of Type : " + type + " with Locator as : " + actLoc );

				}

			}
		}catch(Exception e){
			throw (e); 		
		}
		switch(type)
		{
		case "xpath":
			return driver.findElement(By.xpath(actLoc)); 
		case "css":
			return driver.findElement(By.cssSelector(actLoc));
		case "id":
			return driver.findElement(By.id(actLoc));
		case "name":
			return driver.findElement(By.name(actLoc)); 
		default :
			return driver.findElement(By.xpath(actLoc)); 

		} 
	}
}
