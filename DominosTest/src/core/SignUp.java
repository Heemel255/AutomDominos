package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUp {
	
	private WebDriver wd;
	String signUpPage;
	
	private WebElement fn;
	private WebElement ln;
	private WebElement email;
	private WebElement confirmEmail;
	private WebElement phone;
	private WebElement pass;
	private WebElement confirmPass;
	private WebElement suButton;
	
	public SignUp(WebDriver wd) 
	{
		this.wd = wd;
		
		signUpPage = "https://www.dominos.ca/en/pages/rewards/#!/create-profile/?enrollnow=true&EnrollmentSourceTag=undefined";
		wd.get(signUpPage);
	}
	
	public void signUpRepeater(String email, String fn, String ln, String phone, String pass)
	{
		init();
		
		confirm(email, fn, ln, phone, pass);
		
		signOut();
		
		//have to wait until it goes back to the home page then go back to sign up page
		new WebDriverWait(wd, 10).until(ExpectedConditions.titleIs("Domino's Pizza Canada® - Order Pizza Online - Dominos.ca"));
		
		wd.navigate().to(signUpPage);
	}
	
	private void signOut()
	{
		String signOutXpath = "/html/body/header/nav[1]/div[1]/div[2]/div[2]/span[2]/a";
		new WebDriverWait(wd, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(signOutXpath)));
		wd.findElement(By.xpath(signOutXpath)).click();
	}
	
	private void confirm(String email, String fn, String ln, String phone, String pass)
	{
		setFn(fn);
		setLn(ln);
		setEmail(email);
		setConfirmEmail(email);
		setPhone(phone);
		setPass(pass);
		setPassConfirm(pass);
		
		suButton.click();
	}
	
	private void setFn(String s)
	{
		fn.sendKeys(s);
	}
	
	private void setLn(String s)
	{
		ln.sendKeys(s);
	}
	
	private void setEmail(String s)
	{
		email.sendKeys(s);
	}
	
	private void setConfirmEmail(String s)
	{
		confirmEmail.sendKeys(s);
	}
	
	private void setPhone(String s)
	{
		phone.sendKeys(s);
	}
	
	private void setPass(String s)
	{
		pass.sendKeys(s);
	}
	
	private void setPassConfirm(String s)
	{
		confirmPass.sendKeys(s);
	}
	
	
	private void init() 
	{

		wd.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		String fnXpath = "/html/body/div[2]/div[2]/div/section/div/form/div[1]/div/label[1]/input";
		new WebDriverWait(wd, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fnXpath)));
		
		fn = wd.findElement(By.xpath(fnXpath));
		ln = wd.findElement(By.xpath("/html/body/div[2]/div[2]/div/section/div/form/div[1]/div/label[2]/input"));
		email = wd.findElement(By.xpath("/html/body/div[2]/div[2]/div/section/div/form/div[1]/div/label[3]/input"));
		confirmEmail = wd.findElement(By.xpath("/html/body/div[2]/div[2]/div/section/div/form/div[1]/div/label[4]/input"));
		phone = wd.findElement(By.xpath("/html/body/div[2]/div[2]/div/section/div/form/div[1]/div/div[1]/input[1]"));
		pass = wd.findElement(By.xpath("/html/body/div[2]/div[2]/div/section/div/form/div[1]/div/div[2]/label/input"));
		confirmPass = wd.findElement(By.xpath("/html/body/div[2]/div[2]/div/section/div/form/div[1]/div/label[5]/input"));
		suButton = wd.findElement(By.xpath("/html/body/div[2]/div[2]/div/section/div/form/div[2]/button"));
	}
}
