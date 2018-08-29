package com.kurs.selenium.przyklad1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadanie10 {
	
	private WebDriver driver;
	boolean isElementPresent;
	
	String firstName = "Jan";
	String lastName =  "Kowalski";
	String address = "Wroc³aw";
	String email = "mail@test.com";
	String password = "123456";
	String company = "CodersLab";
	String comment = "First test case";
	
	// lokatory
	String firstNameLocator = "first-name";
	String lastNameLocator = "last-name";
	String genderLocator = "/html/body/div/div/form/div[3]/div/div/label[1]/input";
	String dateOfBirthLocator = "dob";
	String calendarLocator = "/html/body/div[2]/div[1]/table/tbody/tr[2]/td[4]";
	String addressLocator = "address";
	String emailLocator = "email";
	String passwordLocator = "password";
	String companyLocator = "company";
	String roleLocator= "role";
	String jobExpectationLocator= "expectation";
	String checkboxLocator = "//*[@id='infoForm']/div[11]/div/div[1]/label/input";
	String commentLocator = "comment";
	String submitLocator = "submit";
	
	
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "D:/TESTERAUTOMATYCZNYWARSZTATY/eclipse/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();		
	}
	
	@After
	public void tearDown() throws Exception {
	    // driver.close();
	}
	
	@Test
	public void testUserSuccesfullyCreated() {
		driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
		


		
		// wpisz imiê
		WebElement firstNameElement = driver.findElement(By.id(firstNameLocator));
		// wpisz do konsoli nazwe i wartoœæ elementu
// - poprzednia wersja		assertTrue(firstNameElement.isEnabled());
// 		System.out.println(firstNameElement.getAttribute("name") + ":" + firstName);
	// nowa wersja wydruku
		isElementPresent = firstNameElement.isEnabled();
		System.out.println(
				firstNameElement.getAttribute("name") + " - Element is Enabled: " + isElementPresent + "\n" + firstNameElement.getAttribute("name") + " Value: " + firstName);
		firstNameElement.clear();
		firstNameElement.sendKeys(firstName);

		// wpisz nazwisko
		WebElement lastNameElement = driver.findElement(By.id(lastNameLocator));
		// wpisz do konsoli nazwe i wartoœæ elementu
		isElementPresent = lastNameElement.isEnabled();	
		System.out.println(
				"Element is Enabled: " + isElementPresent + "\n" + lastNameElement.getAttribute("name") + ": " + lastName);
		lastNameElement.clear();
		lastNameElement.sendKeys(lastName);
		
		// kliknij p³eæ
		WebElement genderElement = driver.findElement(By.xpath(genderLocator));
		genderElement.click();
		isElementPresent = genderElement.isEnabled();
		// tutaj pisany gender z palca - jeszcze nie automat :)
		System.out.println(
				"Element is Enabled: " + isElementPresent + "\n" + "Gender: Mele");
		
		// wype³nij datê urodzenia
		WebElement dobElement = driver.findElement(By.id(dateOfBirthLocator));
		dobElement.click();
		WebElement calenderElement = driver.findElement(By.xpath(calendarLocator));
		calenderElement.click();
		dobElement.click();
		// wpisz do konsoli nazwe i wartoœæ elementu;
		 
		
		// wpisz adres
		WebElement addressElement = driver.findElement(By.id(addressLocator));
		addressElement.click();
		addressElement.clear();
		addressElement.sendKeys(address);
		
		// wpisz email
		WebElement emailElement = driver.findElement(By.id(emailLocator));
		emailElement.clear();
		assertThat(email, containsString("@"));
		emailElement.sendKeys(email);
		
/*		// Sprawdz czy przechodzi b³êdny mail
		WebElement mailMessage =driver.findElement(By.id("email-error"));
		String result2 =mailMessage.getText();
		assertEquals("Please enter a valid email address.", result2);
*/		
		// wpisz has³o
		WebElement passwordElement = driver.findElement(By.id(passwordLocator));
		passwordElement.clear();
		passwordElement.sendKeys(password);
		
		//WebElement passwortMassage = driver.findElement(By.id("password-error"));
		//assert
		
		// wpisz firme
		WebElement companyElement = driver.findElement(By.id(companyLocator));
		companyElement.clear();
		companyElement.sendKeys(company);
		
		// wybierz role QA
		Select roleDropDown = new Select (driver.findElement(By.id(roleLocator)));
	//	roleDropDown.selectByVisibleText("QA");
//		String selectedOption = roleDropdown   - by³ fajny kod - poprosiæ o wklejenie
		
		// wybierz oczekiwania High salary i Good teamwork
		Select jobExpectationDropDown = new Select (driver.findElement(By.id(jobExpectationLocator)));
		jobExpectationDropDown.selectByVisibleText("High salary");
		jobExpectationDropDown.selectByVisibleText("Good teamwork");
			
		// wybierz development checkbox
		WebElement readBooksCheckbox = driver.findElement(By.xpath(checkboxLocator));
		readBooksCheckbox.click();
		
		// wpisz komentarz
		WebElement commentElement = driver.findElement(By.id(commentLocator));
		commentElement.clear();
		commentElement.sendKeys(comment);				

		// kliknij submit
		WebElement submitButton = driver.findElement(By.id(submitLocator));
		submitButton.click();	
		
		// Sprawdz czy uzytkownik zostal zalozony

	//	WebElement submitMessage =driver.findElement(By.id("submit-msg"));
		//String result =submitMessage.getText();
		//assertEquals("Successfully submitted!", result);
		
		// assertEquals("Successfully submitted!", driver.findElement(By.id("submit-msg"), getText();
	}

	private void assertThat(String email, Object containsString) {
		// TODO Auto-generated method stub
		
	}

	private Object containsString(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
