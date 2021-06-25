package com.readFile;
import java.io.FileInputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class LogInwithDataFromExcel {
	public static WebDriver driver;
	
	public static String LoginData(int row, int col) throws Exception{
		FileInputStream fis=new FileInputStream("read.xls");
		Workbook wb=Workbook.getWorkbook(fis);
		Sheet sh=wb.getSheet("login");
		Cell c=sh.getCell(col, row);
		String data=c.getContents();
		System.out.println(data);
		return data;
	}
	
  @Test
  public void login() throws Exception {
	  System.setProperty("webdriver.driver.chrome", "chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("file:///D:/Offline%20Website/Offline%20Website/index.html");
	  driver.findElement(By.id("email")).sendKeys(LoginData(0,1));
	  driver.findElement(By.id("password")).sendKeys(LoginData(0,2));
	  
  }
}
