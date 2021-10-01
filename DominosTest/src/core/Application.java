package core;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import helper.CsvHelper;

public class Application {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\selenium-java-3.141.59\\chromedriver_win32\\chromedriver.exe");
		String csvLoc = "C:\\Users\\heeme\\Documents\\dominos_accounts.csv";
		
		//create list of accounts in csv - not necessary if csv already exists
		//!!! always change accountNum new run, add +1 
		int accountNum = 63;
		
		int totData = 9;
		writeCsv(totData, accountNum, csvLoc);
		
		//read csv data, set threadCount, and divide data based on threadCount
		int threadCount = 4;
		List<List<String>> allData = readCsv(csvLoc);
		
		if(threadCount > 0 && allData.size() > 0) {
			
			if(allData.size() < threadCount)
				threadCount = allData.size();
			
			List<AccountUnit> accountUnit = seperate(threadCount, allData);
			
			//start threads
			for(int i = 0; i < threadCount; i++) 
				new Thread(runEntry(accountUnit.get(i))).start();
		}
	}
	
	public static Runnable runEntry(AccountUnit au)
	{
		Runnable r = new Runnable() {
			@Override
			public void run() {
				WebDriver wd = new ChromeDriver();
				wd.manage().window().maximize();
				
				signUp(au, wd);
				logIn(au, wd);
				
				wd.close();
			}
		};
		
		return r;
	}
	
	public static void logIn(AccountUnit au, WebDriver wd)
	{
		LogIn lin = new LogIn(wd);
		
		for(int i = 0; i < au.getTotal(); i++)
			lin.logInRepeater(au.getEmail().get(i), au.getPassWord().get(i));
	}
	
	public static void signUp(AccountUnit au, WebDriver wd) 
	{
		SignUp su = new SignUp(wd);
		
		for(int i = 0; i < au.getTotal(); i++) 
			su.signUpRepeater(au.getEmail().get(i), au.getFirstName().get(i), au.getLastName().get(i), au.getPhone().get(i), au.getPassWord().get(i));
	}
	
	public static List<AccountUnit> seperate(int numSize, List<List<String>> allData) 
	{
		List<AccountUnit> liAU = new ArrayList<AccountUnit>();
		
		for(int i = 0; i < numSize; i++) 
			liAU.add(new AccountUnit());
		
		int incIndex = 0;
		int extrasIncIndex = 0;
		for(int q = 0; q < allData.size(); q++) {
			
			if(q  < (allData.size() - (allData.size() % numSize))) {
				
				liAU.get(incIndex).addUnit(allData.get(q).get(0), allData.get(q).get(1), allData.get(q).get(2), allData.get(q).get(3), allData.get(q).get(4));
				
				if((q + 1) % (allData.size() / numSize) == 0) 
					incIndex++;
			}
			else {
				
				liAU.get(extrasIncIndex).addUnit(allData.get(q).get(0), allData.get(q).get(1), allData.get(q).get(2), allData.get(q).get(3), allData.get(q).get(4));
				extrasIncIndex++;
			}	
		}
			
		return liAU;
	}
	
	public static List<List<String>> readCsv(String loc)
	{
		CsvHelper csvHelper = new CsvHelper(loc);
		
		return csvHelper.readCsv();
	}
	
	public static void writeCsv(int amt, int accountNum, String loc)
	{
		CsvHelper csvHelper = new CsvHelper(loc);
		
		csvHelper.initCsv(amt, accountNum);
	}
}
