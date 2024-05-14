package control;

import java.util.Vector;

import Model.DAOSDepartment;
import Model.MSDepartment;



public class CSDepartment {
	
	private DAOSDepartment daosDepartment;
	
	public Vector<MSDepartment> getList1(String fileName){
	
		this.daosDepartment = new DAOSDepartment();
	
		Vector<MSDepartment> msDepartmentList = this.daosDepartment.getList1(fileName);
	
		return msDepartmentList;
}
}
