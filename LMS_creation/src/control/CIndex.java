package control;

import java.util.Vector;

import Model.DAOIndex;
import Model.MIndex;



public class CIndex {
private DAOIndex daoIndex;

	public Vector<MIndex> getList(String fileName){
	this.daoIndex = new DAOIndex();
	Vector<MIndex> mIndexList = this.daoIndex.getList(fileName);
	return mIndexList;
	
		}

	

}
