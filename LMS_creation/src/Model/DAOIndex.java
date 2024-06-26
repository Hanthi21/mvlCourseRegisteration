package Model;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;
import java.io.File;

public class DAOIndex {
			//getter and setter

	public DAOIndex() {
			}
	public Vector<MIndex> getList(String fileName)  {
		Vector<MIndex> campusList = new Vector<MIndex>();
		try {
			File file = new File("data/"+fileName);	
			Scanner scanner= new Scanner(file);
			String line=null;
			while(scanner.hasNext()) {
				line = scanner.nextLine();
				
				MIndex mCampus =  new MIndex();
				String[] wordList = line.split(" ");
				
				mCampus.setId(Integer.parseInt(wordList[0]));//converting ascii code to integer
				mCampus.setName(wordList[1]);
				mCampus.setFileName(wordList[2]);
				campusList.add(mCampus);
			}
			
			scanner.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			return campusList;
	    }
		
	}


