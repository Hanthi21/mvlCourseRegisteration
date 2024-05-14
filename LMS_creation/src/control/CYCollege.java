package control;

import java.util.Vector;

import Model.DAOYCollege;
import Model.MYCollege;





public class CYCollege {
	private DAOYCollege daoyCollege;
	public Vector<MYCollege> getList2(String fileName){
	this.daoyCollege = new DAOYCollege();
	Vector<MYCollege> myCollegeList = this.daoyCollege.getList2(fileName);
	return myCollegeList;
}
}
