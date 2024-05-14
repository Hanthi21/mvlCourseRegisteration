package control;

import java.util.Vector;


import Model.DAOYDepartment;

import Model.MYDepartment;

public class CYDepartment {
	private DAOYDepartment daoyDepartment;
	
	public Vector<MYDepartment> getList1(String fileName){
	
		this.daoyDepartment = new DAOYDepartment();
	
		Vector<MYDepartment> myDepartmentList = this.daoyDepartment.getList1(fileName);
	
		return myDepartmentList;
}
}
