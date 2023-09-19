package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	// -------------Driver initialization---------
	public static void initDriver(String Browser) {
		switch (Browser) {
		case "Chrome": {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		}
		case "Edge": {
			WebDriverManager.chromedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			break;
		}
		case "Firefox": {
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		}
		default:
			System.out.println("Please ENTER the browser name in Pascal Notation or Please Enter a Valid Browser name");

		}
	}

	// ------------To Implicitly Wait-----------
	public static void wait(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));

	}

	// ------------To get URL-------------------
	public static void getURL(String URL) {
		driver.get(URL);
		
	}

	// ------------Data Driven------------------
	public static void readExcel(String FileLocation, String fileName, int rownum, int cellnum) throws IOException {
		File file = new File(FileLocation + "\\" + fileName);
		FileInputStream stream = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(stream);
		Sheet sheet = book.getSheet("Sheet1");
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		CellType cellType = cell.getCellType();

		switch (cellType) {
		case STRING: {
			String stringCellValue = cell.getStringCellValue();
			break;
		}
		case NUMERIC: {
			if (!DateUtil.isCellDateFormatted(cell)) {
				double numericCellValue = cell.getNumericCellValue();
				long l = (long) numericCellValue;
				System.out.println(l);
				break;
			} else {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MMM/yyyy");
				String date = DateFormat.format(dateCellValue);
				System.out.println(date);
				break;
			}
		}
		default:
			System.out.println("Cell is Empty");
		}
	}
	
	//---------Select---------------
	public static void select(String Method,String String,int index,WebElement element) {
		Select s = new Select(element);
		if(Method.equalsIgnoreCase("SelectByValue")){
			s.selectByValue(String);
		}
		else if(Method.equalsIgnoreCase("SelectByIndex")) {
			s.selectByIndex(index);
		}
		else {
			s.selectByVisibleText(String);
		}		
	}
	
	//---------Screen Shot------------
	public static void takeScreenshot(String FileName, String FileLocation) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File SourceFile = ts.getScreenshotAs(OutputType.FILE);
		File TargetFile = new File(FileLocation+"//"+FileName+".jpeg");
		FileUtils.copyFile(SourceFile, TargetFile);
	}	
	
	//---------Switch Back To Parent Frame------
	public static void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}

	//-------- Switch To Frame------------
	public static void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);

	}
	//---------getting Parent Window ID-------
	public static void gettingParentWindowId() {
		String parentWindowId = driver.getWindowHandle();		
	}
	
	//---------switching to parent window ID
	public static void switchParentWindowId(String parentWindowId) {
		driver.switchTo().window(parentWindowId);
	}

	//-------- Switch To two Child Window------
	public static void switchtoChildWindowOfTwo() {
		String parentWindowId = driver.getWindowHandle();
		Set<String> allWindowId = driver.getWindowHandles();
		for (String childWindow : allWindowId) {
			if (!parentWindowId.equals(childWindow));
			driver.switchTo().window(childWindow);
		}
	}
	//--------- Actions----------
	public static void moveTo(WebElement element) {
		Actions ac=new Actions(driver);
		ac.moveToElement(element);
	}
	
	public static void moveToCick(WebElement element) {
		Actions ac=new Actions(driver);
		ac.click(element);
	}
}
