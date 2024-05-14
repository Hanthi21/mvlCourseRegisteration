package control;

import java.util.Vector;

import Model.DAOCampus;
import Model.MIndex;



public class CIndex {
private DAOCampus daoCampus;
	public Vector<MIndex> getList(String fileName){
	this.daoCampus = new DAOCampus();
	Vector<MIndex> mCampusList = this.daoCampus.getList(fileName);
	return mCampusList;
	
	
	
	}

	

}
