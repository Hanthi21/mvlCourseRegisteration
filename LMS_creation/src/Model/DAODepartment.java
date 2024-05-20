package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class DAODepartment {
	public DAODepartment() {
		
	}
	public Vector<MIndex> getList(String fileName)  {
		Vector<MIndex> mDepartmentList = new Vector<MIndex>();
		try {
			File file = new File("data/"+fileName);	
			
			Scanner scanner= new Scanner(file);
			
			
			String line=null;
			while(scanner.hasNext()) {
				line = scanner.nextLine();
				
				MIndex mDepartment =  new MIndex();
				String[] wordList1 = line.split(" ");
				
				mDepartment.setId(Integer.parseInt(wordList1[0]));
				mDepartment.setName(wordList1[1]);
				mDepartment.setFileName(wordList1[2]);
				mDepartmentList.add(mDepartment);
			}
			
			scanner.close();
			
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
			return mDepartmentList;
	
	}
}
