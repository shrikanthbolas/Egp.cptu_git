package com.egp.qa.helper.assertion;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.egp.qa.base.TestBase;
import com.egp.qa.helper.logger.LoggerHelper;

public class VerificationHelper extends TestBase{
	//private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(VerificationHelper.class);
	
	public VerificationHelper(WebDriver driver){
		this.driver = driver;
		log.info("VerificationHelper object is created..");
	}
	
	public boolean isDisplayed(WebElement element) {
		try{
			element.isDisplayed();
			log.info("element is Displayed.."+element.getText());
			//TestBase.logExtentReport("element is Displayed.."+element.getText());
			return true;
		}
		catch(Exception e){
			log.error("element is not Displayed.."+e.getCause());
			//TestBase.logExtentReport("element is not Displayed.."+e.getMessage());
			return false;
		}
	}
	
	public boolean isNotDisplayed(WebElement element) {
		try{
			element.isDisplayed();
			log.info("element is present.."+element.getText());
			//TestBase.logExtentReport("element is present.."+element.getText());
			return false;
		}
		catch(Exception e){
			log.error("element is not present.."+e.getCause());
			return true;
		}
	}
	
	/*public String readValueFromElement(WebElement element) {
		if (null == element) {
			log.info("Webelement is null");
			return null;
		}
		boolean status=isDisplayed(element);
		if (status) {
			log.info("element text is .."+element.getText());
			return element.getText();
		}else {
			return null;
		}
	}*/
	
	public String getText(WebElement element) {
		if (null == element) {
			log.info("Webelement is null");
			return null;
		}
		
		boolean status=isDisplayed(element);
		if (status) {
			log.info("element text is .."+element.getText());
			return element.getText();
		}else {
			return null;
		}
	}
	
	public String getTitle() {
		log.info("page title is : "+driver.getTitle());
		return driver.getTitle();
	}
	
}
