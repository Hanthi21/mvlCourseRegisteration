package view;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VLectureTable extends JScrollPane {
	private static final long serialVersionUID = 1L;
	JTable table = new JTable();
	public VLectureTable() {
		this.table = new JTable();
		this.setViewportView(this.table);
		
	}
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

}
