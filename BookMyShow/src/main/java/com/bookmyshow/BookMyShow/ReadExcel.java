package com.bookmyshow.BookMyShow;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws IOException {
	
		FileInputStream fi= new FileInputStream(new File("E:\\Bookmyshow\\BookMyShow\\File\\Credentials.xlsx"));
		XSSFWorkbook wb= new XSSFWorkbook(fi);
		XSSFSheet sheet= wb.getSheetAt(0);
		// counting the max row till which data is available
		int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		for (int i=1; i<rowCount+1;i++) {
			Row row=sheet.getRow(i);
			{
				for (int j=0; j<row.getLastCellNum();j++)
				{
					System.out.print(row.getCell(j).getStringCellValue()+" ");
				}
			}
		}
		
		wb.close();
	}

}
