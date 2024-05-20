package control;

import java.util.Vector;

import Model.DAOlecture;
import Model.MLecture;

public class CLecture {
	private DAOlecture daoLecture;
	public Vector<MLecture> getList(String fileName){
		this.daoLecture = new DAOlecture();
		Vector<MLecture> mLectureList = this.daoLecture.getList(fileName);
		return mLectureList;
	}
}
