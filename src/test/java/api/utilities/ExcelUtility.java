package api.utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public FileInputStream fis;
	public XSSFWorkbook book;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	String path;

	public ExcelUtility(String path) {
		this.path = path;
	}

	public int getRowCount(String sheetName) throws Exception {
		fis = new FileInputStream(path);
		book = new XSSFWorkbook(fis);
		sheet = book.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		book.close();
		fis.close();
		return rowCount;
	}

	public int getCellCount(String sheetName, int rowNum) throws Exception {
		fis = new FileInputStream(path);
		book = new XSSFWorkbook(fis);
		sheet = book.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		book.close();
		fis.close();
		return cellCount;
	}

	public String getCellData(String sheetName, int rowNum, int cellNum) throws Exception {
		fis = new FileInputStream(path);
		book = new XSSFWorkbook(fis);
		sheet = book.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);

		DataFormatter formatter = new DataFormatter();
		String data = formatter.formatCellValue(cell);

		book.close();
		fis.close();
		return data;
	}

}
