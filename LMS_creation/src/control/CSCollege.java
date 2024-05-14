package control;

import java.util.Vector;

import Model.DAOSCollege;

import Model.MSCollege;


public class CSCollege {

	
		private DAOSCollege daosCollege;
		public Vector<MSCollege> getList1(String fileName){
		this.daosCollege = new DAOSCollege();
		Vector<MSCollege> msCollegeList = this.daosCollege.getList1(fileName);
		return msCollegeList;
		
	}

}
