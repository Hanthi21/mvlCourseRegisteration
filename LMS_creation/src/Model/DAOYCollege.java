package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class DAOYCollege{
	public DAOYCollege() {
		
	}
	public Vector<MYCollege> getList2(String fileName)  {
		Vector<MYCollege> yCollegeList = new Vector<MYCollege>();
		try {
			File file2 = new File("data/"+fileName);	
			Scanner scanner= new Scanner(file2);
			String line=null;
			while(scanner.hasNext()) {
				line = scanner.nextLine();
				
				MYCollege yonginCollege =  new MYCollege();
				String[] wordList2 = line.split(" ");
				
				yonginCollege.setId(Integer.parseInt(wordList2[0]));
				yonginCollege.setName(wordList2[1]);
				yonginCollege.setFileName(wordList2[2]);
				yCollegeList.add(yonginCollege);
			}
			
			scanner.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			return yCollegeList;
	
	}
}
