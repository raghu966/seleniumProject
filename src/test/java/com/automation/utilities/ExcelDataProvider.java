package com.automation.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;

	public ExcelDataProvider() {
		File fil = new File("./Testdata/Testdata.xlsx");

		try {
			FileInputStream fis = new FileInputStream(fil);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable to read the data from excel sheet");
		}
	}
	
	
	public String getStringdata(String sheet, int row, int column) {
		
		return wb.getSheet(sheet).getRow(row).getCell(column).getStringCellValue();
		
	}

	public Double getNumericdata(String sheet, int row, int column) {
		return wb.getSheet(sheet).getRow(row).getCell(column).getNumericCellValue();
	}
}
