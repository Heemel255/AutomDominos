package core;

import java.util.ArrayList;
import java.util.List;

//holds separated csv file data so that it is equally divided based on number of threads
public class AccountUnit {
	
	private int total;
	private List<String> email;
	private List<String> firstName;
	private List<String> lastName;
	private List<String> phone;
	private List<String> passWord;
	
	public AccountUnit()
	{
		email = new ArrayList<String>();
		firstName = new ArrayList<String>();
		lastName = new ArrayList<String>();
		phone = new ArrayList<String>();
		passWord = new ArrayList<String>();
		total = 0;
	}
	
	public void addUnit(String e, String f, String l, String ph, String ps)
	{
		addEmail(e);
		addFirstName(f);
		addLastName(l);
		addPhone(ph);
		addPassWord(ps);
		updateTotal();
	}
	
	private void updateTotal()
	{
		total++;
	}
	
	public int getTotal()
	{
		return total;
	}
	
	private void addEmail(String s)
	{
		email.add(s);
	}
	
	private void addFirstName(String s)
	{
		firstName.add(s);
	}

	private void addLastName(String s)
	{
		lastName.add(s);
	}
	
	private void addPhone(String s)
	{
		phone.add(s);
	}
	
	private void addPassWord(String s)
	{
		passWord.add(s);
	}
	
	public List<String> getEmail()
	{
		return email;
	}
	
	public List<String> getFirstName()
	{
		return firstName;
	}

	public List<String> getLastName()
	{
		return lastName;
	}
	
	public List<String> getPhone()
	{
		return phone;
	}
	
	public List<String> getPassWord()
	{
		return passWord;
	}
}
