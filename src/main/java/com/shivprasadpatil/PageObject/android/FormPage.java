package com.shivprasadpatil.PageObject.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.shivprasadpatil.Utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidActions {
	
	AndroidDriver driver;
	
	
	//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Shobha Patil");
	
	
	public FormPage(AndroidDriver driver) 
	{
		// we have to use super keyword show parent class constructor and driver
		super(driver);
		driver=this.driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		//in appium there are one decorated class we have to create obj of that 
	}
	//Before access any element inilisation method will call and all object will constructed  you behind the screen
	//when you create obj of that class automatically constructor will call.
	//what kind of tool we have to use.
	@AndroidBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	//driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
	@AndroidBy(xpath="//android.widget.RadioButton[@text='Female']")
	 private WebElement FemaleOption;
	
	@AndroidBy(xpath="//android.widget.RadioButton[@text='Male']")
	 private WebElement MaleOption;
	
	@AndroidBy(id="android:id/text1")
	private WebElement contrySelection;
	
	@AndroidBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopButton;
	
	//this will be automatically constructed once you created obj of class constructor will call.driver get activated it will place in local varibale 
	//it will call init element called only one begining all locator will call when you have constructoe behind screen.
	
	//We have to create action method
	public void setNameField(String name)
	{
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}
	
	

	public void selectGenderOption(String gender) 
	{
		
		if(gender.contains("female"))
		{
			FemaleOption.click();
		}
		else
		{
			MaleOption.click();
		}
		
	}
	public void setCountrySelection(String countryName)
	{
		contrySelection.click();
		scrollToText(countryName);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
	}
	public void submitForm()
	{
		shopButton.click();
	}
	

}
