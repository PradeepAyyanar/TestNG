package mygroup.comerce;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
static Object[][] readExcelData(String file) throws IOException{
	XSSFWorkbook wbook = new XSSFWorkbook("D:\\pradeep\\selenium\\comerce\\src\\main\\java\\mygroup\\comerce\\"+file+".xlsx");
	XSSFSheet sheet = wbook.getSheetAt(0);
	int rowCount = sheet.getLastRowNum();
	short colCount = sheet.getRow(0).getLastCellNum();
	Object[][] data = new Object[rowCount][colCount];
	for(int i=1;i<=rowCount;i++) {
		XSSFRow row = sheet.getRow(i);
		for(int j=0;j<colCount;j++) {
			XSSFCell cell = row.getCell(j);
			String stringCellValue = cell.getStringCellValue();
			data[i-1][j]=stringCellValue;
		}
	}
	return data;
}
}
