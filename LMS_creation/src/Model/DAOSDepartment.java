package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class DAOSDepartment {
	public DAOSDepartment() {
		
	}
	public Vector<MSDepartment> getList1(String fileName)  {
		Vector<MSDepartment> sDepartmentList = new Vector<MSDepartment>();
		try {
			File file1 = new File("data/"+fileName);	
			File file2 = new File("data/"+fileName);
			File file3 = new File("data/"+fileName);
			File file4 = new File("data/"+fileName);
			File file5 = new File("data/"+fileName);
			File file6 = new File("data/"+fileName);
			
			Scanner scanner= new Scanner(file1);
			Scanner s2 = new Scanner(file2);
			Scanner s3 = new Scanner(file3);
			Scanner s4 = new Scanner(file4);
			Scanner s5 = new Scanner(file5);
			Scanner s6 = new Scanner(file6);
			
			String line=null;
			while(scanner.hasNext()) {
				line = scanner.nextLine();
				
				MSDepartment sGeneral =  new MSDepartment();
				String[] wordList1 = line.split(" ");
				
				sGeneral.setId(Integer.parseInt(wordList1[0]));
				sGeneral.setName(wordList1[1]);
				sGeneral.setFileName(wordList1[2]);
				sDepartmentList.add(sGeneral);
			}
			
			scanner.close();
			System.lineSeparator();
			while(s2.hasNext()) {
				line = s2.nextLine();
				
				MSDepartment sICT =  new MSDepartment();
				String[] wordList2 = line.split(" ");
				
				sICT.setId(Integer.parseInt(wordList2[0]));
				sICT.setName(wordList2[1]);
				sICT.setFileName(wordList2[2]);
				sDepartmentList.add(sICT);
			}
			
			s2.close();
			while(s3.hasNext()) {
				line = s3.nextLine();
				
				MSDepartment sBusiness =  new MSDepartment();
				String[] wordList3 = line.split(" ");
				
				sBusiness.setId(Integer.parseInt(wordList3[0]));
				sBusiness.setName(wordList3[1]);
				sBusiness.setFileName(wordList3[2]);
				sDepartmentList.add(sBusiness);
			}
			
			s3.close();
			
			while(s4.hasNext()) {
				line = s4.nextLine();
				
				MSDepartment sSocial =  new MSDepartment();
				String[] wordList4 = line.split(" ");
				
				sSocial.setId(Integer.parseInt(wordList4[0]));
				sSocial.setName(wordList4[1]);
				sSocial.setFileName(wordList4[2]);
				sDepartmentList.add(sSocial);
			}
			
			s4.close();
			
			while(s5.hasNext()) {
				line = s5.nextLine();
				
				MSDepartment sHuman =  new MSDepartment();
				String[] wordList5 = line.split(" ");
				
				sHuman.setId(Integer.parseInt(wordList5[0]));
				sHuman.setName(wordList5[1]);
				sHuman.setFileName(wordList5[2]);
				sDepartmentList.add(sHuman);
			}
			
			s5.close();
			
			while(s6.hasNext()) {
				line = s6.nextLine();
				
				MSDepartment sLaw =  new MSDepartment();
				String[] wordList6 = line.split(" ");
				
				sLaw.setId(Integer.parseInt(wordList6[0]));
				sLaw.setName(wordList6[1]);
				sLaw.setFileName(wordList6[2]);
				sDepartmentList.add(sLaw);
			}
			
			s6.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
			return sDepartmentList;
	
	}
}
