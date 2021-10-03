package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogIn {
	
	private WebDriver wd;
	String homePage;
	
	WebElement signInButtonHome;
	WebElement signOutButton;
	
	WebElement email;
	WebElement pass;
	WebElement signInButton;
	
	public LogIn(WebDriver wd) 
	{
		this.wd = wd;
		
		homePage = "https://www.dominos.ca";
		wd.get(homePage);
	}
	
	public void logInRepeater(String emailStr, String passStr)
	{
		initPage();
		signInButtonHome.click();
		
		initLoginBox();
		email.sendKeys(emailStr);
		pass.sendKeys(passStr);
		signInButton.click();
		
		signOut();
		new WebDriverWait(wd, 10).until(ExpectedConditions.titleIs("Domino's Pizza Canada® - Order Pizza Online - Dominos.ca"));
	}
	
	private void signOut() 
	{
		new WebDriverWait(wd, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/header/nav[1]/div[1]/div[3]/div[2]/span[1]/a")));
		
		signOutButton = wd.findElement(By.xpath("/html/body/header/nav[1]/div[1]/div[3]/div[2]/span[2]/a"));
		signOutButton.click();
	}
	
	private void initPage()
	{
		String x = "/html/body/header/nav[1]/div[1]/div[3]/span/a";
		new WebDriverWait(wd, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(x)));
		
		signInButtonHome = wd.findElement(By.xpath(x));
	}
	
	private void initLoginBox()
	{
		String emailPath = "/html/body/div[7]/section/div/div/form/div[1]/div[1]/input";
		new WebDriverWait(wd, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(emailPath)));
		
		email = wd.findElement(By.xpath(emailPath));
		pass = wd.findElement(By.xpath("/html/body/div[7]/section/div/div/form/div[1]/div[2]/input"));
		signInButton = wd.findElement(By.xpath("/html/body/div[7]/section/div/div/form/div[3]/div/div[1]/div[2]/div[1]/div[2]/button"));
	}
}