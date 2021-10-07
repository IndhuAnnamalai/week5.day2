package week5.day2.Assignments;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelServiceNow {

public static String[][] readExcel(String fname) throws IOException {
	XSSFWorkbook book=new XSSFWorkbook("./data/"+fname+".xlsx");
	XSSFSheet sheet = book.getSheet("Sheet1");
	int lastRowNum = sheet.getLastRowNum();
	System.out.println("Row "+lastRowNum);
	XSSFRow row = sheet.getRow(0);
	int lastCellNum = row.getLastCellNum();
	System.out.println("Columns "+lastCellNum);
	String data[][]=new String[lastRowNum][lastCellNum];
	//XSSFCell cell = row.getCell(0);
	for(int i=1;i<=lastRowNum;i++) {
		for (int j=0;j<lastCellNum;j++) {
			String stringCellValue = sheet.getRow(i).getCell(j).getStringCellValue();
			  System.out.println(stringCellValue);
			 data[i-1][j] = stringCellValue;
	
	}
		
	}
book.close();
return data;
}

}
