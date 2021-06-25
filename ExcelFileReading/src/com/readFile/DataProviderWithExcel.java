package com.readFile;
import java.io.FileInputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class DataProviderWithExcel {
	WebDriver driver=null;
	Workbook wb=null;
	 
	@BeforeSuite
	public void OpenPage(){
		System.setProperty("webdriver.driver.chrome", "chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///D:/Offline%20Website/Offline%20Website/index.html");
	}
	@Test(dataProvider="jbk")
	public void testPage(String uname, String pw){
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(uname);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(pw);
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
		if(driver.getTitle().contains("Dashboard")){
			driver.findElement(By.xpath("/html/body/div/header/nav/div/ul/li/a")).click();
		}
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Log in");
		
	}
	@AfterTest
	public void tearDown(){
		driver.close();
	}
	@DataProvider public Object[][] jbk(){
		try {  
			FileInputStream fis = new FileInputStream("read.xls");	 
			 wb= Workbook.getWorkbook(fis);   
			}
		catch(Exception e) 
		{   	
			e.printStackTrace();
			    }	 
			 Sheet sh= wb.getSheet("login");	  
			int rows= sh.getRows();//3	  
			int col = sh.getColumns();//2	  
			String data[][]= new String [rows][col];//[3][2]		
			for(int i=0;i<rows;i++) {			
			for(int j=0;j<col;j++) {				
			Cell c = sh.getCell(j,i);				
			String value = c.getContents();			
			data[i][j]=value;			
			}
			}	
			return data;	
			  } 
		
	}

