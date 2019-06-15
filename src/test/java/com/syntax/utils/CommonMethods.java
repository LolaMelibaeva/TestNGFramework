package com.syntax.utils;

import java.io.File;
import com.syntax.utils.BaseClass;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.syntax.utils.BaseClass;

public class CommonMethods extends  BaseClass {

	
	

	/**
	 * This method will select a specified value from a drop down
	 * 
	 * @author Syntax
	 * @param Select element, String text
	 */
	public static void selectValueFromDD(WebElement element, String text) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		boolean isSelected = false;
		for (WebElement option : options) {
			String optionText = option.getText();
			if (optionText.equals(text)) {
				select.selectByVisibleText(text);
				System.out.println("Option with text " + text + " is selected");
				isSelected = true;
				break;
			}
		}
		if (!isSelected) {
			System.out.println("Option with text +" + text + "is not available");
		}
	}

	/**
	 * This method will select a specified value from a drop down by its index
	 * 
	 * @author Syntax
	 * @param Select element, int index
	 */
	public static void selectValueFromDD(WebElement element, int index) {
		Select select = new Select(element);
		
		List<WebElement> options = select.getOptions();
		if (options.size() > index) {
			select.selectByIndex(index);
			
		} else {
			System.out.println("Invalid index has been passed");
		}
	}

	public static void sendText(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	/**
	 * Method will accept alert
	 * 
	 * @throws NoAlertPresentException if alert is not present
	 */
	public static void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert was not present");
		}
	}

	/**
	 * Method will dismiss alert
	 * 
	 * @throws NoAlertPresentException if alert is not present
	 */
	public static void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert was not present");
		}
	}

	/**
	 * Method will get text of an alert
	 * 
	 * @throws NoAlertPresentException if alert is not present
	 * @return String text
	 */
	public static String getAlertText() {

		try {
			Alert alert = driver.switchTo().alert();
			return alert.getText();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert was not present");
			return null;
		}

	}

	/**
	 * Method that will switch control to the specified frame
	 * 
	 * @param frame id or frame name
	 */
	public static void switchToFrame(String idOrName) {
		try {
			driver.switchTo().frame(idOrName);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}

	/**
	 * Method that will switch control to the specified frame
	 * 
	 * @param frame element
	 */
	public static void switchToFrame(WebElement element) {
		try {
			driver.switchTo().frame(element);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}

	/**
	 * Method that will switch control to the specified frame
	 * 
	 * @param frame index
	 */
	public static void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}

	/**
	 * Method that will click a specified WebElement
	 * 
	 * @param element
	 */
	public static void click (WebElement element) {
		element.click();

	}

	public static void selectDateFromCalendar(List<WebElement> rows, String expectedValue) {

		boolean isSelected=false;
		for (WebElement row : rows) {
			String rowText = row.getText();
			if (rowText.contains(expectedValue)) {
				row.click();
				System.out.println(expectedValue + " is selected");
				isSelected=true;
				break;
			}

		}
		if (!isSelected) {
			System.out.println("Expected value " + expectedValue + " is NOT selected");

		}
	}
			
	

	public static void selectCellFromTable(List<WebElement> rows, String expectedValue) {

		
		boolean isSelected=false;
		for (WebElement row : rows) {
			String rowText = row.getText();
			if (rowText.contains(expectedValue)) {
				row.click();
				System.out.println(expectedValue + " is selected");
				isSelected=true;
				break;
			}

		}
		if (!isSelected) {
			System.out.println("Expected value " + expectedValue + " is NOT selected");

		}
	}
			

	

	public static void selectRadioBtn(List<WebElement> list, String expectedValue) {
		boolean isSelected=false;
		for (WebElement button : list) {
			String buttonText = button.getAttribute("value");

			if (button.isDisplayed() && button.isEnabled() && buttonText.equals(expectedValue)) {
				button.click();
				System.out.println(expectedValue + " is selected");
				isSelected=true;
				break;
			}

		}
		if (!isSelected) {
			System.out.println("Expected value " + expectedValue + " is NOT selected");

		}
	}

	

	public static void selectCheckbox(List<WebElement> list, String expectedValue) {
		boolean isSelected = false;
		for (WebElement checkbox : list) {
			String checkboxText = checkbox.getText();

			if (checkbox.isDisplayed() && checkbox.isEnabled() && checkboxText.equals(expectedValue)) {
				checkbox.click();
				System.out.println(expectedValue + " is selected");
				isSelected = true;
				break;
			}

		}
		if (!isSelected) {
			System.out.println("Expected value " + expectedValue + " is NOT selected");

		}
	}
	
	/**
	 * Method that will wait for element to be visible
	 * 
	 * @param WebElement element, int time
	 */
	public static void waitForElementBeVisible(WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitForElementBeVisible(By locator, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void waitForElementBeClickable(WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitForElementBeClickable(By locator, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public static void takeScreenshot(String folderName, String fileName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File scr = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scr, new File("screenshots/"+folderName+"/"+fileName+".png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Screenshot is NOT taken");
		}
	}
	public static void scrollDown(int pixels) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,"+pixels+")");
	}
	
	public static void scrollUp(int pixels) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-"+pixels+")");
	}
	
	public static void jsClick(WebElement element) {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
		
	}
	
	/**
	 * Method that compares each cell in the table
	 * 
	 * @param List<WebElement>cells, String expValue
	 */

	public static void tableCompareCellValueToExpected(List<WebElement> cells, String expValue) {
		boolean isSelected = false;
		
		for (WebElement cell : cells) {
			String cellText = cell.getText();
			if (cellText.contains(expValue)) {
				System.out.println(expValue + " is verified on the table");
				isSelected = true;
				break;
			}
		}

		if (!isSelected) {
			System.out.println("Expected value is NOT verified on the table");

		}
	}

	public static void selectList(WebElement element, String text) {

		List<WebElement> listLocations = element.findElements(By.tagName("li"));

		for (WebElement li : listLocations) {
			String liText = li.getAttribute("innerHTML");

			if (liText.contains(text)) {
				li.click();
				break;
			}
		}
	}
	
	
	public static boolean compareListValueReturnBoolean(List<WebElement> cell, String expectedValue) {
        boolean flag = false;
        new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOfAllElements(cell));

        for (WebElement cells : cell) {
            String cellText = cells.getText();
            if (cellText.contains(expectedValue)) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            System.err.println(expectedValue +" is NOT verified");
        }
        return flag;
    }

}



