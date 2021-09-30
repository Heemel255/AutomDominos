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
	
	public void add(String e, String f, String l, String ph, String ps)
	{
		addEmail(e);
		addFirstName(f);
		addLastName(l);
		addPhone(ph);
		addPassWord(ps);
		updateTotal();
	}
	
	public void updateTotal()
	{
		total++;
	}
	
	public int getTotal()
	{
		return total;
	}
	
	public void addEmail(String s)
	{
		email.add(s);
	}
	
	public void addFirstName(String s)
	{
		firstName.add(s);
	}

	public void addLastName(String s)
	{
		lastName.add(s);
	}
	
	public void addPhone(String s)
	{
		phone.add(s);
	}
	
	public void addPassWord(String s)
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
