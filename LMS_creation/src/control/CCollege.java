package control;

import java.util.Vector;

import Model.DAOCollege;


import Model.MIndex;


public class CCollege {

	
		private DAOCollege daoCollege;
		public Vector<MIndex> getList(String fileName){
		this.daoCollege = new DAOCollege();
		Vector<MIndex> mCollegeList = this.daoCollege.getList(fileName);
		return mCollegeList;
		
	}

}
