package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class DAOlecture {
	public DAOlecture() {
		
	}
	public Vector<MLecture> getList(String fileName){
		Vector<MLecture> mLectureList = new Vector<MLecture>();
		try {
			File file = new File("data/"+fileName+".txt");
			
			
			Scanner s1 = new Scanner(file);
			
			
			String line =null;
			while(s1.hasNext()) {
				line = s1.nextLine();
				
				MLecture lectureName = new MLecture();
				String[] wordlist1 = line.split(" ");
				
				lectureName.setCode(Integer.parseInt(wordlist1[0]));
				lectureName.setlName(wordlist1[1]);
				lectureName.setProfessor(wordlist1[2]);
				lectureName.setCredit(Integer.parseInt(wordlist1[3]));
				lectureName.setTime(wordlist1[4]);
				mLectureList.add(lectureName);
			}
			s1.close();
			
		
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
	return mLectureList;	
	}
}
