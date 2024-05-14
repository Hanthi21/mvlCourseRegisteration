package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class DAOSCollege {
//seoul campus college list 
	public DAOSCollege() {
		
	}
	public Vector<MSCollege> getList1(String fileName)  {
		Vector<MSCollege> sCollegeList = new Vector<MSCollege>();
		try {
			File file1 = new File("data/"+fileName);	
			Scanner scanner= new Scanner(file1);
			String line=null;
			while(scanner.hasNext()) {
				line = scanner.nextLine();
				
				MSCollege seoulCollege =  new MSCollege();
				String[] wordList1 = line.split(" ");
				
				seoulCollege.setdID(Integer.parseInt(wordList1[0]));
				seoulCollege.setDname(wordList1[1]);
				seoulCollege.setDfileName(wordList1[2]);
				sCollegeList.add(seoulCollege);
			}
			
			scanner.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			return sCollegeList;
	
	}
}
