package org.roughtests;

public class BaseClass {
	package org.base;

	import java.io.File;
	import java.io.FileInputStream;
	import java.math.BigDecimal;
	import java.text.SimpleDateFormat;
	import java.time.Duration;
	import java.util.Date;
	import java.util.LinkedList;
	import java.util.List;
	import java.util.Set;

	import org.apache.commons.io.FileUtils;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.CellType;
	import org.apache.poi.ss.usermodel.DateUtil;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseClass {

		
		
		public static WebDriver driver;

		// ----------------Initialization Of Web Browser--------------

		public static void iniBrow(String browser) {

			switch (browser) {
			case "Chrome":

				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				break;
			case "Edge":

				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				driver.manage().window().maximize();

				break;

			default:
				System.out.println("Not Initialized");
				break;
			}

		}

		// ---------------------------Getting Url----------------------

		public static void getUrl(String url) {
			driver.get(url);

		}

		// --------------------------Getting Text-------------------------

		public static void gettingText(WebElement element) {
			String text = element.getText();
			System.out.println(text);

		}

		// --------------------Getting Sendkeys Attribute Value------------

		public static void gettingAttributeValue(WebElement element) {

			String attribute = element.getAttribute("value");
			System.out.println(attribute);
		}

		// ----------------------------Select-----------------------------

		public static void selectByIndexId(WebElement element, int index) {

			Select s = new Select(element);
			s.selectByIndex(index);
			

		}
		public static void selectByValue(WebElement element, String Value) {

			try {
				
				Select s = new Select(element);
				s.selectByValue(Value);
				
			} catch (Exception e) {
				
			}
			

		}

		public static void selectByValueForMultipleElement(WebElement webElement, String Value) {

			Select s = new Select((WebElement) webElement); 
			s.selectByValue(Value);

		}
		
		

		public static void selectByVisibleText(WebElement element, String text) {

			Select s = new Select(element);
			s.selectByVisibleText(text);

		}

		// Select - Multiple Options

		// Select All OPtions From Drop Down------------

		public static void getAllOption(WebElement element) {
			Select s = new Select(element);
			List<WebElement> options = s.getOptions();

			for (int i = 0; i < options.size(); i++) {

				WebElement webElement = options.get(i);
				String text = webElement.getText();
				System.out.println(text);

			}

		}

		// can Select multi option or not----------

		public static void isMultiple(WebElement element) {
			Select s = new Select(element);
			boolean multiple = s.isMultiple();
			System.out.println(multiple);

		}

		// Get All Option From Drop Down-------------

		public static void AllOptionFromDropDown(WebElement element) {
			Select s = new Select(element);
			List<WebElement> options = s.getOptions();
			for (int i = 0; i < options.size(); i++) {

				WebElement webElement = options.get(i);
				String text = webElement.getText();
				System.out.println(text);

			}

		}

		// Get Selected Options From Drop Down-----------

		public static void allSelectedOptions(WebElement element) {
			Select s = new Select(element);
			List<WebElement> allSelectedOptions = s.getAllSelectedOptions();

			for (int i = 0; i < allSelectedOptions.size(); i++) {

				WebElement webElement = allSelectedOptions.get(i);
				String text = webElement.getText();
				System.out.println(text);
			}

		}

		// Get First Selected Options------------

		public static void firstSelectedOptions(WebElement element) {
			Select s = new Select(element);
			WebElement firstSelectedOption = s.getFirstSelectedOption();
			String text = firstSelectedOption.getText();
			System.out.println(text);

		}

		// -----------------------De-select----------------------------------

		public static void deSelectByIndexId(WebElement element, int index) {

			Select s = new Select(element);
			s.deselectByIndex(index);

		}

		public static void deSelectByValue(WebElement element, String Value) {

			Select s = new Select(element);
			s.deselectByValue(Value);

		}

		public static void deSelectByVisibleText(WebElement element, String text) {

			Select s = new Select(element);
			s.deselectByVisibleText(text);
		}

		public static void deSelectAll(WebElement element) {

			Select s = new Select(element);
			s.deselectAll();
		}

		// -------------------------Alert--------------------------

		// Simple Alert-----------------
		public static void simpleALert() {

			Alert simpleAlert = driver.switchTo().alert();
			simpleAlert.accept();
		}

		// Confirm Alert-----------------

		public static void confirmAlert(String acceptOrDismiss) {
			Alert confirmAlert = driver.switchTo().alert();

			if (acceptOrDismiss == "accept") {
				confirmAlert.accept();
			} else if (acceptOrDismiss == "dismiss") {
				confirmAlert.dismiss();

			}

		}

		// Prompt Alert------------------

		public static void promptAlert(String comment, String acceptOrDismiss) {

			Alert promptAlert = driver.switchTo().alert();
			promptAlert.sendKeys(comment);

			if (acceptOrDismiss == "accept") {
				promptAlert.accept();
			} else if (acceptOrDismiss == "dismiss") {
				promptAlert.dismiss();

			}

		}

		// ------------------Actions-----------------------------

		// Mouse Hover-----------

		public static void moveToElement(WebElement element) {
			Actions act = new Actions(driver);

			act.moveToElement(element).build().perform();
		}
		// Drag And Drop----------

		public static void dragAndDrop(WebElement sourceElement, WebElement targetElement) {
			Actions act = new Actions(driver);
			act.dragAndDrop(sourceElement, targetElement).build().perform();

		}
		// rightClick----------------

		public static void rightClick(WebElement element) {
			Actions act = new Actions(driver);
			act.contextClick(element).build().perform();

		}
		// doubleClick---------------

		public static void doubleClick(WebElement element) {
			Actions act = new Actions(driver);
			act.doubleClick(element).build().perform();

		}

		// --------------------TakesScreenShot--------------------

		public static void screenShot(String name) {
			try {

				TakesScreenshot shot = (TakesScreenshot) driver;
				File source = shot.getScreenshotAs(OutputType.FILE);
				File target = new File("D:\\App Test\\TakeScreenshot\\e-bay Project\\Ebay Cucumber\\" + name + ".jpeg");
				FileUtils.copyFile(source, target);

			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		// ---------------------Javascript Executor------------

		public static void javaScriptKey(WebElement element, String textValue) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('value'='" + textValue + "')", element);

		}

		public static void javaScriptGetKeyValue(WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("return arguments[0].getAttribute('value')", element);

		}

		public static void javaScriptClick(WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", element);

		}

		public static void javaScriptScroll(WebElement element, boolean trueOrFalse) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(" + trueOrFalse + ")", element);

		}

		// ----------------------Frame-----------------------

		// Switch To Frame
		public static void switchToFrame(WebElement element) {
			driver.switchTo().frame(element);

		}

		// Switch Back To Parent Frame

		public static void switchToParentFrame() {
			driver.switchTo().parentFrame();

		}

		// Switch To Default Frame
		public static void switchToDefaultFrame() {
			driver.switchTo().defaultContent();
		}

		// -------------------Window Handling------------------------

		//  getting Parent Window ID-------

		public static void gettingParentWindowId() {

			String parentWIndowId = driver.getWindowHandle();
			
		}
		
		// switching to parent window ID
		
		public static void switchParentWindowId(String parentWIndowId) {
			driver.switchTo().window(parentWIndowId);

		}

		// Switch To Child Window(for Only 2 window)------

		public static void switchtoChildWindowForTwoWindow() {
			String parentWIndowId = driver.getWindowHandle();
			Set<String> allWindowId = driver.getWindowHandles();
			for (String childWindow : allWindowId) {
				if (!parentWIndowId.equals(childWindow))
					;

				driver.switchTo().window(childWindow);
			}
		}

		// Switch To Child Window (For Multiple WIndows)

		public static void switchtoChildWindowForMultiWindow(int SwitchWindowIndex) {

			Set<String> allWindowId = driver.getWindowHandles();

			List<String> li = new LinkedList<>();

			li.addAll(allWindowId);
			String windowHandles = li.get(SwitchWindowIndex);
			driver.switchTo().window(windowHandles);

		}

		// ----------------------Navigation-------------------------

		public static void navigateTo(String url) {

			driver.navigate().to(url);
		}

		public static void navigateBack() {
			driver.navigate().back();

		}

		public static void navigateForward() {
			driver.navigate().forward();

		}

		public void navigateRefresh() {
			driver.navigate().refresh();

		}

		// ------------------------wait---------------------------

		public static void implicitlyWait(int seconds) {

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
		}

		// --------------------Data Driven----------------------------

		public static String readExcel(int rowN, int cellN) {

			String value = null;

			try {

				File file = new File("D:\\App Test\\Book1.xlsx");
				FileInputStream stream = new FileInputStream(file);

				Workbook book = new XSSFWorkbook(stream);
				Sheet sheet = book.getSheet("Sheet1");
				Row row = sheet.getRow(rowN);
				Cell cell = row.getCell(cellN);

				CellType cellType = cell.getCellType();

				switch (cellType) {
				case STRING:

					value = cell.getStringCellValue();

					break;

				default:

					if (DateUtil.isCellDateFormatted(cell)) {

						Date dateCellValue = cell.getDateCellValue();

						SimpleDateFormat sim = new SimpleDateFormat("dd/MM/yyyy");

						value = sim.format(dateCellValue);

					} else {

						double numericCellValue = cell.getNumericCellValue();
						long lo = (long) numericCellValue;
						BigDecimal valueOf = BigDecimal.valueOf(lo);
						value = valueOf.toString();

					}

					break;
				}

			} catch (Exception e) {
				// TODO: handle exception
			}

			return value;

		}

		
	}

}
