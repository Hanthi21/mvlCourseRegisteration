package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class DAOCollege {

	public DAOCollege() {
		
	}
	public Vector<MIndex> getList(String fileName)  {
		Vector<MIndex> mCollegeList = new Vector<MIndex>();
		try {
			File file1 = new File("data/"+fileName);	
			Scanner scanner= new Scanner(file1);
			String line=null;
			while(scanner.hasNext()) {
				line = scanner.nextLine();
				
				MIndex mCollege =  new MIndex();
				String[] wordList1 = line.split(" ");
				
				mCollege.setId(Integer.parseInt(wordList1[0]));
				mCollege.setName(wordList1[1]);
				mCollege.setFileName(wordList1[2]);
				mCollegeList.add(mCollege);
			}
			
			scanner.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			return mCollegeList;
	
	}
}
