package week7assignment;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


public class Readxl {	
		public  static String[][] readData(String filename) throws IOException {
		
				XSSFWorkbook wbook =new XSSFWorkbook("Data/"+filename+".xlsx");
				XSSFSheet wsheet = wbook.getSheet("Sheet1");
				int rowcount = wsheet.getLastRowNum();//row count without header
				short columnCount  = wsheet.getRow(0).getLastCellNum();
				String[][] data=new String[rowcount][columnCount];	
				 for (int i =1; i <=rowcount ; i++) {//row
					
					 for (int j = 0; j <columnCount ; j++) {//cell 0 1 2
						String stringCellValue = wsheet.getRow(i).getCell(j).getStringCellValue();
					    data[i-1][j]=stringCellValue;//0,0
					 }
		}
		//to close the workbook
				 wbook.close();
				 return data;
	}
	
}
