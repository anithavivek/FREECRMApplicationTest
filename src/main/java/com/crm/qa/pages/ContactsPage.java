package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//div[@class='ui header item mb5 light-black']")
	WebElement contactsLabel;
	
	@FindBy(xpath = "//button[contains(text(),'New')]")
	WebElement newContactLink;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(xpath="//div[@name='company']//input[@class='search']")
	WebElement company;
	
	@FindBy(xpath = "//button[@class='ui linkedin button']")
	WebElement saveBtn;
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement newcontact;
	
	
	// Initializing the Page Objects:
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyContactsLabel(){
		return contactsLabel.isDisplayed();
	}
	
	public void clickOnNewContactLink(){
		newContactLink.click();
		
	}
	
	public String selectContactsByName(String name){
		return driver.findElement(By.xpath("//td[contains(text(),'"+name+"')]")).getText();
	}
	
	
	public void createNewContact(String ftName, String ltName, String comp) throws InterruptedException{
				
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(comp);
		saveBtn.click();
		Thread.sleep(2000);
		
	}
	
	public String newcontactvalidate() {
		return newcontact.getText();
		
	}
	

}
