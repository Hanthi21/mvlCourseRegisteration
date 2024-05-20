package view;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Model.MIndex;

import control.CIndex;

public class VIndexTable extends JScrollPane {
	//attributes
	
	private static final long serialVersionUID = 1L;
	
	
	//Components
	
	private JTable table;
	private DefaultTableModel model;
	
	//association
	private VIndexTable next;
	public void setNext(VIndexTable next) {this.next = next;}
	private Vector<MIndex> mIndexList;
	

	
	//methods
	public VIndexTable() {
		//generate table as a component
		this.table = new JTable();
		this.setViewportView(this.table);
	
		
	
		
			
			
	
	}
	private void newModel() {
		//associate the table with a model
		String header[] = {	"ID", "Campus" };
		this.model = new DefaultTableModel(null, header);
		this.table.setModel(this.model);
		
	}
	
	  

		public void show(String fileName) {
			//get data from CIndex
		CIndex cIndex = new CIndex();
		 this.mIndexList = cIndex.getList(fileName+".txt");
		 //set data to model
		this.newModel();
		
		
		
		for (MIndex mIndex: this.mIndexList) {
			String[] row = new String[2];
			row[0] = String.valueOf(mIndex.getId());
			row[1] = mIndex.getName();
			this.model.addRow(row);
		
	}
		this.updateUI();
		//default
		showNext(0);
		}
		
	
		
private void showNext(int selectedIndex) {
	if(this.next != null) {
		this.next.show(this.mIndexList.get(selectedIndex).getFileName());
	}
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
		
		
		
		
	}

