package week5.day2.Assignments;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] runReadExcel(String fName) throws IOException {
		
		XSSFWorkbook wb=new XSSFWorkbook("./data/"+fName+".xlsx");
		XSSFSheet sheet = wb.getSheet("Sheet1");
		int rowNum = sheet.getLastRowNum();
		System.out.println(rowNum);
		int cellNum = sheet.getRow(0).getLastCellNum();
		System.out.println(cellNum);
		
		String[][] data = new String[rowNum][cellNum];
		for(int i=1;i<=rowNum;i++) {
			for(int j=0;j<cellNum;j++) {
				String text = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(text);
				data[i-1][j]=text;
			}
			
		}
		wb.close();
			return data;	
		

	}

}
