package control;

import java.util.Vector;

import Model.DAOSlecture;
import Model.MSLecture;

public class CSLecture {
	private DAOSlecture daosLecture;
	public Vector<MSLecture> getList(){
		this.daosLecture = new DAOSlecture();
		Vector<MSLecture> msLectureList = this.daosLecture.getList();
		return msLectureList;
	}
}
