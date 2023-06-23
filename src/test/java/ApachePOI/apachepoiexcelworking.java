package ApachePOI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class apachepoiexcelworking {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream file = new FileInputStream("C:\\Users\\prasa\\eclipse-workspace\\Seleniumtest\\testdata\\Data_Excel.xlsx");
		//we can use System.getProperty also 
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int totalrows = sheet.getLastRowNum();
		int totalcells = sheet.getRow(1).getLastCellNum();
		System.out.println(totalrows);
		System.out.println(totalcells);

		for(int r = 0;r<=totalrows;r++){
			XSSFRow currentrow =  sheet.getRow(r);
			for(int c=0;c<totalcells;c++){
				
				String value = currentrow.getCell(c).toString();
				System.out.println(value);

			}
		}
		workbook.close();
		file.close();

		

	}

}
