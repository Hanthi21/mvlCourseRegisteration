package control;

import java.util.Vector;

import Model.DAODepartment;
import Model.MIndex;



public class CDepartment {
	
	private DAODepartment daoDepartment;
	
	public Vector<MIndex> getList(String fileName){
	
		this.daoDepartment = new DAODepartment();
	
		Vector<MIndex> mDepartmentList = this.daoDepartment.getList(fileName);
	
		return mDepartmentList;
}
}
