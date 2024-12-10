package com.shivprasadpatil.AppiumFrameworkDeisgin;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.shivprasadpatil.PageObject.android.FormPage;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class eCommerce_tc_4 extends BaseTest {
	
	
	@Test
	public void FillForm() throws InterruptedException
	{
		
		FormPage formpage=new FormPage(driver);
		formpage.setNameField("Shobha Patil");
		formpage.selectGenderOption("female");
		//formpage.setCountrySelection("Argentina");
		formpage.submitForm();
		
		
		
			    
	    driver.findElements(By.xpath("//android.widget.TextView[@Text='ADD TO CART")).get(0).click();
	    driver.findElements(By.xpath("//android.widget.TextView[@Text='ADD TO CART")).get(0).click();
	    Thread.sleep(3000);
	    driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	    WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text","Cart"));
	    //its return list of webelement
	    Thread.sleep(3000);
	   List<WebElement> productprices= driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
	   int count=productprices.size();
	   double sum=0;
	   //we want sum for that 
	   Thread.sleep(3000);        
	   for(int i=0;i<count;i++)
	   {
		   //we want product price &GET TEXT METHOD ALAWAYS RETURN STRING
		   String amoutString=productprices.get(i).getText();
		   //we dont want use $ That swhy we used string
		   //we have to use double method we have to store into double 
		  Double price=getFormattedAmount(amoutString);
				sum=sum+price;//160.97+120=280.97  
		   //integer doest not support decimal value
		   
		   //we have to convert string into double
	   }
	   Thread.sleep(3000);
	  String displaysum= driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
	  Double displayFormattedSum= getFormattedAmount(displaysum);
	  Assert.assertEquals(sum,displayFormattedSum);
	  WebElement ele=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
	  longPressAction(ele);
	  driver.findElement(By.id("android:id/button1")).click();
	  driver.findElement(AppiumBy.className("android.widget.Checkbox")).click();
	  driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
	  Thread.sleep(6000);
	  Set<String>contexts= driver.getContextHandles();
	  for(String contextName:contexts)
	  {
		  System.out.println(contextName);
	  }
	  
	  driver.context("WEBVIEW_com.androidsample.generalstore");
	  driver.findElement(By.name("q")).sendKeys("shivprasad kailas patil");
	  driver.pressKey(new KeyEvent(AndroidKey.BACK));
	  driver.context("NATIVE_APP");
	  
	  
	  //how t shift form mobile to web 
	  
	  
	  
	  
	  
	   
	   

	   

	   }

}