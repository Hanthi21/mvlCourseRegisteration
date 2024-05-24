package view;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.MLecture;

public class VPreRegister extends JScrollPane {
	private  static final long serialVersionUID = 1L;
	private DefaultTableModel model;
	JTable table;
	
	public VPreRegister() {
		this.table = new JTable();
		this.setViewportView(this.table);
		String[] header = {
				"ID", "Name", "Professor", "Credit", "Time"
		};
		this.model = new DefaultTableModel(null, header) {
			public boolean isCellEditable(int rowIndex,int columnIndex) {
				return false;
				
			}
		};
		
		this.table.setModel(this.model);
		
	}
	public void addLecture(MLecture lecture) {
		if(!isLectureInTable(lecture)) {
		String row[] = new String[5];
				row[0]=String.valueOf(lecture.getCode());
				row[1]=lecture.getlName();
				row[2]=lecture.getProfessor();
				row[3]=String.valueOf(lecture.getCredit());
				row[4]=lecture.getTime();
		
		this.model.addRow(row);
		this.updateUI();
		}
	}
	
	//check if the user selected this lecture already , 
	//it is checked by lecture id,  
	//get the lecture code of the user selected lecture  from lecture table and compare it with the id of the lecture in pre-register table
	private boolean isLectureInTable(MLecture lecture) {
		for(int i = 0; i < this.model.getRowCount();i++) {
			int lectureCode = Integer.parseInt((String)this.model.getValueAt(i,0));
			if(lectureCode == lecture.getCode()) {
				return true; // means the lecture user selected in already in the table 
			}
		}
		return false; // returns when the lecture user selected is not the table
	}
	public void deleteSelectedLecture() {
		int selectedRow = this.table.getSelectedRow();
		if(selectedRow != -1) {
			this.model.removeRow(selectedRow);
		}
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
	
	public void initialize() {
		
		
		
		
	}
}
