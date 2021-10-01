package helper;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;


public class CsvHelper {
	
	private String loc;
	
	public CsvHelper(String loc)
	{
		this.loc = loc;
	}
	
	public List<List<String>> readCsv()
	{
		File csvFile = new File(loc);
		
		if(csvFile.isFile()) {
			try {
				FileReader fr = new FileReader(loc);
				CSVParser csvParser = CSVParser.parse(fr, CSVFormat.EXCEL);
				
				List<CSVRecord> csvRec = csvParser.getRecords();
				
				List<List<String>> li = new ArrayList<List<String>>();
				
				for(int i = 0; i < csvRec.size(); i++) {
					
					li.add(csvRec.get(i).toList());
				}
				
				csvParser.close();
				fr.close();
				
				return li;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	public void initCsv(int amt, int accountNum)
	{
		deleteCsv();
		createCsv();
		writeCsv(amt, accountNum);
	}
	
	private void writeCsv(int amt, int accountNum)
	{
		
		File csvFile = new File(loc);
		
		if(csvFile.isFile()) {
			try {
				FileWriter fw = new FileWriter(loc, true);
				CSVPrinter csvPrint = new CSVPrinter(fw, CSVFormat.EXCEL);
				
				//format is: email, firstname, lastname, phone num, password
				String[][] input = new String[amt][5];
				for(int i = 0; i < input.length; i++) {
					
					input[i][0] = "hr" + accountNum + "seltestmail" + i + "@gmail.com";
					input[i][1] = "hr" + accountNum + "seltestfn" + i;
					input[i][2] = "hr" + accountNum + "seltestln" + i;
					input[i][3] = "416-000-0000";
					input[i][4] = "hr" + accountNum + "seltestpass" + i;
					
					csvPrint.printRecord(input[i][0], input[i][1], input[i][2], input[i][3], input[i][4]);
				}
				
				csvPrint.close();
				fw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void createCsv()
	{
		File csvFile = new File(loc);
		
		if(!csvFile.isFile()) {
			
			try {
				csvFile.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void deleteCsv() 
	{
		File csvFile = new File(loc);
		
		if(csvFile.isFile()) {
			
			try {
				csvFile.delete();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
