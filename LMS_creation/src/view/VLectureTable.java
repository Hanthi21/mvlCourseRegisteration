package view;

import java.awt.Component;
import java.awt.LayoutManager;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.MLecture;
import control.CLecture;

public class VLectureTable extends JScrollPane {
	
	private VLectureTable vlectureTable;
	private static final long serialVersionUID = 1L;
	JTable table = new JTable();
	DefaultTableModel model;
	
	
	
	
	public VLectureTable() {
		
		this.table = new JTable();
		this.setViewportView(this.table);
		
		String header[] = {	"ID", "Name","Professor","Credit","Time" };
		this.model = new DefaultTableModel(null, header);
		this.table.setModel(this.model);
		
		
	}
	
	
	public void show(String fileName) {
		
		CLecture csLecture = new CLecture();
		Vector<MLecture> msLectureList = csLecture.getList(fileName);
		
		String row[] = new String[5];
		for(MLecture msLecture: msLectureList) {
			row[0] = String.valueOf(msLecture.getCode());
			row[1] = msLecture.getlName();
			row[2] = msLecture.getProfessor();
			row[3] = String.valueOf(msLecture.getCredit());
			row[4] = msLecture.getTime();
			this.model.addRow(row);
		}
		this.updateUI();
		
	}
	public void initialize() {
		
		this.show("englishYG.txt");
		this.show("basic.txt");
	
	}

}
