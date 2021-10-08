package helper;

import java.io.*;


public class TxtHelper {
	
	private String loc;
	
	public TxtHelper(String loc)
	{
		this.loc = loc;
	}
	
	public int getTxt()
	{
		
		File f = new File(loc);
		
		if(f.isFile()) {
			try {
				FileReader fr = new FileReader(f);
				
				String s = "";
				int i;
				while((i=fr.read()) != -1)
					s = s + (char)i;
				
				fr.close();
				
				return Integer.parseInt(s);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return 0;
	}
	
	public void writeTxt(int num)
	{
		
		File f = new File(loc);
		
		if(f.isFile()) {
			try {
				FileWriter fw = new FileWriter(f);
				
				fw.write("");
				fw.write(String.valueOf(num));
				
				fw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
