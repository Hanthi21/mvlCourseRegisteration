package view;

import java.awt.Component;
import java.awt.LayoutManager;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Model.MLecture;
import control.CLecture;

public class VLectureTable extends JScrollPane {
	
	private VLectureTable vlectureTable;
	private static final long serialVersionUID = 1L;
	JTable table = new JTable();
	DefaultTableModel model;
	private VPreRegister preRegisterTable;
	
	
	
	
	public VLectureTable() {
		
		this.table = new JTable();
		this.setViewportView(this.table);
		
		String header[] = {	"ID", "Name","Professor","Credit","Time" };
		this.model = new DefaultTableModel(null, header) {
			public boolean isCellEditable(int rowIndex,int columnIndex) {
				return false;
			}
		};
		this.table.setModel(this.model);
		
		this.preRegisterTable = new VPreRegister();
		
		
	}
	
	
	public void show(String fileName) {
		
		//Clear existing rows before adding new data
		
		clearTable();
		
		CLecture cLecture = new CLecture();
		Vector<MLecture> msLectureList = cLecture.getList(fileName);
		
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
	
	private void clearTable() {
		this.model.setRowCount(0);
	}
	public void initialize() {
		
	
	
	
	}
	public VPreRegister getPreRegisterTable() {
		return this.preRegisterTable;
	}
	public MLecture getSelectedLecture() {
		int selectedRow = this.table.getSelectedRow();
		if(selectedRow != -1) {
			int code = Integer.parseInt((String)this.model.getValueAt(selectedRow, 0));
			String name = (String) this.model.getValueAt(selectedRow, 1);
			String professor = (String)this.model.getValueAt(selectedRow,2 );
			int credit = Integer.parseInt((String)this.model.getValueAt(selectedRow,3));
			String time = (String) this.model.getValueAt(selectedRow, 4);
			return new MLecture(code,name,professor,credit,time);
		}
		return null;
	}

}
