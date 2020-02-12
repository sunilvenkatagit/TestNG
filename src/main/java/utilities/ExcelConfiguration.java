package utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConfiguration {

	XSSFWorkbook workbook;
	XSSFSheet sheet;

	public ExcelConfiguration(String excelPath) throws Exception {
		try {
			File source = new File(excelPath);
			FileInputStream fis = new FileInputStream(source);
			workbook = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int getRowCount(int sheetNumber) {
		int row = workbook.getSheetAt(sheetNumber).getLastRowNum();
		row = row + 1;
		System.out.println("hello " + row);
		return row;
	}

	public String getCellValue(int sheetNumber, int rowNumber, int columnNumber) {
		sheet = workbook.getSheetAt(sheetNumber);
		String value = sheet.getRow(rowNumber).getCell(columnNumber).getStringCellValue();
		return value;
	}

}
