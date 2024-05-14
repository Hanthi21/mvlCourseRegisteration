package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class DAOSlecture {
	public DAOSlecture() {
		
	}
	public Vector<MSLecture> getList(){
		Vector<MSLecture> sLectureList = new Vector<MSLecture>();
		try {
			File engYG = new File("data/englishYG.txt");
			File basic = new File("data/basic.txt");
			File selective = new File("data/selective.txt");
			
			Scanner s1 = new Scanner(engYG);
			Scanner s2 = new Scanner(basic);
			Scanner s3 = new Scanner(selective);
			
			
			String line =null;
			while(s1.hasNext()) {
				line = s1.nextLine();
				
				MSLecture english = new MSLecture();
				String[] wordlist1 = line.split(" ");
				
				english.setCode(Integer.parseInt(wordlist1[0]));
				english.setlName(wordlist1[1]);
				english.setProfessor(wordlist1[2]);
				english.setCredit(Integer.parseInt(wordlist1[3]));
				english.setTime(wordlist1[4]);
				sLectureList.add(english);
			}
			s1.close();
			
			while(s2.hasNext()) {
				MSLecture basic1 = new MSLecture();
				String[] wordlist2 = line.split(" ");
				
				basic1.setCode(Integer.parseInt(wordlist2[0]));
				basic1.setlName(wordlist2[1]);
				basic1.setProfessor(wordlist2[2]);
				basic1.setCredit(Integer.parseInt(wordlist2[3]));
				basic1.setTime(wordlist2[4]);
				sLectureList.add(basic1);
				
			}
			s2.close();
			

			while(s3.hasNext()) {
				MSLecture selecTive = new MSLecture();
				String[] wordlist3 = line.split(" ");
				
				selecTive.setCode(Integer.parseInt(wordlist3[0]));
				selecTive.setlName(wordlist3[1]);
				selecTive.setProfessor(wordlist3[2]);
				selecTive.setCredit(Integer.parseInt(wordlist3[3]));
				selecTive.setTime(wordlist3[4]);
				sLectureList.add(selecTive);
				
			}
			s3.close();
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
	return sLectureList;	
	}
}
