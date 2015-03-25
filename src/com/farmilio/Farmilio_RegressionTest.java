package com.farmilio;

import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Farmilio_RegressionTest {

	public WebDriver driver = new FirefoxDriver();
	
	@Before
	public void setUp() throws Exception {
		 String appUrl = "http://staging.farmilio.net/";	
		  driver.get(appUrl);
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void verify_Registration() {
		
	  //Executing Test Case# 1
	    System.out.println("Executing Test Case# 1 - User registration");
	    driver.findElement(By.partialLinkText("Log")).click(); ;
	    driver.findElement(By.partialLinkText("Konto")).click(); ; 
	     
	    WebElement usernamereg = driver.findElement(By.name("user[email]"));
	    usernamereg.clear();
	    usernamereg.sendKeys("mehedizaman@ymail.com");
	    WebElement passwordreg = driver.findElement(By.name("user[password]"));
	    passwordreg.clear();
	    passwordreg.sendKeys("carbon");
	    
	    if ( !driver.findElement(By.id("user_terms_and_conditions")).isSelected())
	    {
	         driver.findElement(By.id("user_terms_and_conditions")).click();
	    }
	   	
	    WebElement kontoAnlegenButton = driver.findElement(By.xpath("(//button[@type='submit'])"));
	    kontoAnlegenButton.click();
	    
	    if(driver.findElement(By.id("error_explanation")).getText()=="Email ist bereits vergeben")
	    {	
	    System.out.println("Account already exists.");
	    }
	}
	
	@Test
	public void verifyBlankLogin() {
		
		// Executing Test Case# 2(A)
		    System.out.println("Executing Test Case# 2(A) - Blank Login");
		    WebElement logInSubmit = driver.findElement(By.partialLinkText("Log"));
		    logInSubmit.click();
		    WebElement username = driver.findElement(By.name("user[email]"));
		    username.clear();
		    username.sendKeys("");
		    WebElement password = driver.findElement(By.name("user[password]"));
		    password.clear();
		    password.sendKeys("   ");
		    WebElement logInButton = driver.findElement(By.xpath("//button[@type='submit']"));
		    logInButton.click();
		    
		    if(driver.findElement(By.name("user[password]")).getText() == "")
		    {
		
		    	assertEquals("×\nE-Mail-Adresse oder Passwort ungültig.", driver.findElement(By.className("message")).getText());
		    }
		    
		    else
		    	
		    	assertEquals("×\nUngültige Anmeldedaten.", driver.findElement(By.className("message")).getText());	
	 
	}


	  @Test
	  public void verifyInvalidLogin() {
	  
		    
		 //Executing Test Case# 2(B)
		     System.out.println("Executing Test Case# 2(B) - Invalid Login");
		     WebElement logInSubmit = driver.findElement(By.partialLinkText("Log"));
		      logInSubmit.click();
		      WebElement username = driver.findElement(By.name("user[email]"));
		      username.clear();
		      username.sendKeys("sqaone@b.com");
		    WebElement password = driver.findElement(By.name("user[password]"));
		    password.clear();
		    password.sendKeys("carbon");

		    WebElement logInButton = driver.findElement(By.xpath("//button[@type='submit']"));
		    logInButton.click();
		    
		    assertEquals("×\nE-Mail-Adresse oder Passwort ungültig.", driver.findElement(By.className("message")).getText());
	  }
	  
	  @Test
	  public void verifyValidLogin() {
	  
		    
		 // Executing Test Case# 2(C)
		      System.out.println("Executing Test Case# 2(C) - Valid Login");

		      WebElement logInSubmit = driver.findElement(By.partialLinkText("Log"));
		      logInSubmit.click();
		      WebElement username = driver.findElement(By.name("user[email]"));
		      username.clear();
		      username.sendKeys("sqaone@yahoo.com");
		      WebElement password = driver.findElement(By.name("user[password]"));
		      password.clear();
		      password.sendKeys("carbon");
		      WebElement logInButton = driver.findElement(By.xpath("//button[@type='submit']"));
		      logInButton.click();
	  }
	  
		    @Test
			  public void verifyQuickSearch()  {
	    
		    //Executing Test Case# 3(A)
			   System.out.println("Executing Test Case# 3(A) - Quick Search");
		    	WebElement searchBox = driver.findElement(By.xpath("//input[@type='text']")); 
		    	searchBox.clear();
		    	searchBox.sendKeys("fruits");
			    WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
			    searchButton.click();
		  }
	

		    @Test
			  public void verifyMyOffers() {
			  
		    	//Executing Test Case# 4(A)
			    System.out.println("Executing Test Case# 4(A) - My Offers");
			    WebElement logInSubmit = driver.findElement(By.partialLinkText("Log"));
			    logInSubmit.click();
			    WebElement username = driver.findElement(By.name("user[email]"));
			    username.clear();
			    username.sendKeys("sqaone@yahoo.com");
			    WebElement password = driver.findElement(By.name("user[password]"));
			    password.clear();
			    password.sendKeys("carbon");
			    WebElement logInButton = driver.findElement(By.xpath("//button[@type='submit']"));
			    logInButton.click();
		    	WebElement myAccountButton = driver.findElement(By.partialLinkText("Benutzer"));
			    myAccountButton.click();    
			    WebElement myOfferButton = driver.findElement(By.partialLinkText("Eigene"));
			    myOfferButton.click();  	    	   	   
			    WebElement offerDetailsLink = driver.findElement(By.linkText("Apfelsaft"));
			    offerDetailsLink.click();
			    WebElement offerBreadcrumbsLink = driver.findElement(By.linkText("Getränke"));
			    offerBreadcrumbsLink.click();
		    }
		    
			@Test
		    public void verifyAdvancedSearch() {
				  
		   //Executing Test Case# 4(A)
			 System.out.println("Executing Test Case# 5(A) - Advanced Search");
				   WebElement advancedSearchLink = driver.findElement(By.partialLinkText("Suche"));
				   advancedSearchLink.click();    
					 WebElement categoryDDL = driver.findElement(By.id("category"));
					 Select clickCategoryDDL = new Select(categoryDDL); 
					 clickCategoryDDL.selectByValue("16");    
					 WebElement productDDL = driver.findElement(By.id("product"));
					 Select clickProductDDL = new Select(productDDL); 
					 clickProductDDL.selectByValue("36");				    
					 WebElement subproductDDL = driver.findElement(By.name("subproduct"));
					 Select clickSubproductDDL = new Select(subproductDDL); 
					 clickSubproductDDL.selectByValue("");			    
					 WebElement searchAdvancedButton = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
					 searchAdvancedButton.click();  		         
	  }
	 
		@Test
		public void verifyShareFarmilio() {
				  
		// Executing Test Case# 6(A)
			    System.out.println("Executing Test Case# 6(A) - Share Farmilio");
				System.lineSeparator();
				WebElement logInSubmit = driver.findElement(By.partialLinkText("Log"));
			    logInSubmit.click();
			    WebElement username = driver.findElement(By.name("user[email]"));
			    username.clear();
			    username.sendKeys("sqaone@yahoo.com");
				 WebElement password = driver.findElement(By.name("user[password]"));
				 password.clear();
			     password.sendKeys("carbon");
				  WebElement logInButton = driver.findElement(By.xpath("//button[@type='submit']"));
				 logInButton.click();
				 WebElement shareFarmilioLink = driver.findElement(By.partialLinkText("Teilen"));
				 shareFarmilioLink.click();	
				 WebElement recommendFarmilioLink = driver.findElement(By.partialLinkText("Empfehlen"));
				 recommendFarmilioLink.click();			      
				 WebElement templateButton = driver.findElement(By.partialLinkText("Vorlage"));
				 templateButton.click();	      
				 WebElement inputEmailReceiver = driver.findElement(By.id("inputEmail3"));
				 inputEmailReceiver.clear();
				 inputEmailReceiver.sendKeys("mehedizaman@rocketmail.com,mehedizmn@yahoo.com");      
				 WebElement inputEmailSubject = driver.findElement(By.name("subject"));
				 inputEmailSubject.clear();
				 inputEmailSubject.sendKeys("Farmilio MVP 1.0 Selenium Test Automation");	      
				 WebElement inputEmailMessage = driver.findElement(By.name("message"));
				 inputEmailMessage.clear();
				 inputEmailMessage.sendKeys("Ich habe eine neue Internet-Plattform entdeckt die Dir sicher auch gefallen wird. Auf FARMILIO findest Du aktuelle Angebote von Bauern, Jägern und Fischern in Deiner Nachbarschaft.Direkt vom Bauern - beste Qualität und ein Beitrag zum Erhalt der heimischen, bäuerlichen Landwirtschaft.");      
				 WebElement inputEmailSubmit = driver.findElement(By.cssSelector("button.send-email.btn.btn-default"));
				 inputEmailSubmit.click();
			      }
			      
	@After
	public void tearDown() throws Exception {
		
		driver.close();
	    System.lineSeparator();
	}
	
}
