package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class DAOYDepartment {
	
public DAOYDepartment() {
	
}
	public Vector<MYDepartment> getList1(String fileName)  {
		Vector<MYDepartment> yDepartmentList = new Vector<MYDepartment>();
		try {
			File file1 = new File("data/"+fileName);	
			File file2 = new File("data/"+fileName);
			File file3 = new File("data/"+fileName);
			File file4 = new File("data/"+fileName);
			File file5 = new File("data/"+fileName);
			
			
			Scanner scanner= new Scanner(file1);
			Scanner s2 = new Scanner(file2);
			Scanner s3 = new Scanner(file3);
			Scanner s4 = new Scanner(file4);
			Scanner s5 = new Scanner(file5);
			
			String line=null;
			while(scanner.hasNext()) {
				line = scanner.nextLine();
				
				MYDepartment yGeneral =  new MYDepartment();
				String[] wordList1 = line.split(" ");
				
				yGeneral.setId(Integer.parseInt(wordList1[0]));
				yGeneral.setName(wordList1[1]);
				yGeneral.setFileName(wordList1[2]);
				yDepartmentList.add(yGeneral);
			}
			
			scanner.close();
			System.lineSeparator();
			while(s2.hasNext()) {
				line = s2.nextLine();
				
				MYDepartment yEngineering =  new MYDepartment();
				String[] wordList2 = line.split(" ");
				
				yEngineering.setId(Integer.parseInt(wordList2[0]));
				yEngineering.setName(wordList2[1]);
				yEngineering.setFileName(wordList2[2]);
				yDepartmentList.add(yEngineering);
			}
			
			s2.close();
			while(s3.hasNext()) {
				line = s3.nextLine();
				
				MYDepartment yScience =  new MYDepartment();
				String[] wordList3 = line.split(" ");
				
				yScience.setId(Integer.parseInt(wordList3[0]));
				yScience.setName(wordList3[1]);
				yScience.setFileName(wordList3[2]);
				yDepartmentList.add(yScience);
			}
			
			s3.close();
			
			while(s4.hasNext()) {
				line = s4.nextLine();
				
				MYDepartment yArt =  new MYDepartment();
				String[] wordList4 = line.split(" ");
				
				yArt.setId(Integer.parseInt(wordList4[0]));
				yArt.setName(wordList4[1]);
				yArt.setFileName(wordList4[2]);
				yDepartmentList.add(yArt);
			}
			
			s4.close();
			
			while(s5.hasNext()) {
				line = s5.nextLine();
				
				MYDepartment yArchi =  new MYDepartment();
				String[] wordList5 = line.split(" ");
				
				yArchi.setId(Integer.parseInt(wordList5[0]));
				yArchi.setName(wordList5[1]);
				yArchi.setFileName(wordList5[2]);
				yDepartmentList.add(yArchi);
			}
			
			s5.close();
			
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
			return yDepartmentList;
	}
}
