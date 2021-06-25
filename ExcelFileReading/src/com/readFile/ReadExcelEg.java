package com.readFile;
import java.io.FileInputStream;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ReadExcelEg {
	public static void read() throws Exception {
		
			FileInputStream fis=new FileInputStream("read.xls");
			Workbook wb=Workbook.getWorkbook(fis);
			Sheet sh=wb.getSheet("login");
			int rows=sh.getRows();
			int col=sh.getColumns();
			System.out.println("rows are>> "+rows+" and cols are>> "+col);
		for(int i=0;i<rows;i++){
			for(int j=0; j<col;j++){
				Cell c=sh.getCell(j, i);
				String contents=c.getContents();
				System.out.print(contents+" ");
			}
			System.out.println(    );
		}
	}
public static void main(String[] args) throws Exception {
	ReadExcelEg.read();
}
}
