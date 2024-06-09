package view;

import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Model.MLecture;
import constants.Constant.MainFrame;
import control.CLecture;

public class VLectureTable extends JScrollPane implements IIndex{
	private static final long serialVersionUID = MainFrame.VersionID;
	
	//components
	private JTable table;
	private DefaultTableModel model;
	private Vector<MLecture> mLectureList;
	private Map<MLecture, String> lectureDepartments;
	
	
	
	
	//association
	private VLectureTable vLectureTable1;
	private VLectureTable vLectureTable2;
	
	//getters and setters

	 public Vector<MLecture> getSelectedLectureList(){
		 int[] selectedIndexs = this.table.getSelectedRows();
		 
		 Vector<MLecture> vSelectedLectureList = new Vector<>();
		 for(int index : selectedIndexs) {
			vSelectedLectureList.add(this.mLectureList.get(index));
		 }
		 return vSelectedLectureList;
	 	
	 }
	 

		public void addSelectedLectureList(Vector<MLecture> selectedLectureList,String department) {
			for(MLecture mLecture: selectedLectureList) {
				this.mLectureList.add(mLecture);
				this.lectureDepartments.put(mLecture, department);
				
				String row[] = new String[5];
				row[0] = String.valueOf(mLecture.getCode());
				row[1] = mLecture.getlName();
				row[2] = mLecture.getProfessor();
				row[3] = String.valueOf(mLecture.getCredit());
				row[4] = mLecture.getTime();
				this.model.addRow(row);
				
				
				
				
			}
			this.updateUI();
		}
		

	
	
	
	public VLectureTable() {
		
		
		this.table = new JTable();
		this.setViewportView(this.table);
		
	
		MouseHandler mouseHandler = new MouseHandler();
		this.table.addMouseListener(mouseHandler);
		this.newModel();
		
		this.mLectureList = new Vector<>();
		this.lectureDepartments = new HashMap<>();
		 this.table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
	}
	
	
	private void newModel() {
		//associate table with a model
		String header[] = {"ID","Lecture Name","Professor","Credit","Time"};
		this.model = new DefaultTableModel(null,header){
			public boolean isCellEditable(int rowIndex,int columnIndex) {
				return false;
			}
		};
		this.table.setModel(this.model);
		
	}


	public void show(String fileName) {
		
		//Clear existing rows before adding new data
		
		//clearTable();
		//get data from CCampus
		CLecture cLecture = new CLecture();
		this.mLectureList = cLecture.getList(fileName);
		//set data to model
		clearTable();
		
		for(MLecture mLecture: this.mLectureList) {
			String row[] = new String[5];
			row[0] = String.valueOf(mLecture.getCode());
			row[1] = mLecture.getlName();
			row[2] = mLecture.getProfessor();
			row[3] = String.valueOf(mLecture.getCredit());
			row[4] = mLecture.getTime();
			this.model.addRow(row);
			
		}
		this.updateUI();
		showNext(0);
		
	}
	public void showNext(int selectedIndex) {
		
	}
	
	private void clearTable() {
		this.model.setRowCount(0);
	}
	public void initialize() {
		
	
	
	
	}
	
	private class MouseHandler implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			int row = table.getSelectedRow();
			showNext(row);
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

	public void removeSelectedLectures(Vector<MLecture> selectedLectureList) {
		for(MLecture lecture : selectedLectureList) {
			String originalDepartment = this.lectureDepartments.get(lecture);
			int rowIndex = this.mLectureList.indexOf(lecture);
			if(rowIndex != -1) {
				this.model.removeRow(rowIndex);
				this.mLectureList.remove(lecture);
			}
			this.lectureDepartments.remove(lecture);
		}
	}
	
private int getRowIndex(MLecture lecture) {
	for(int i=0;i<model.getRowCount();i++) {
		if(model.getValueAt(i, 0).equals(String.valueOf(lecture.getCode()))) {
			return i;
		}
	}
	return -1;
}
	
}
