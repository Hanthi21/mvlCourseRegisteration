package view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
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
	
	//methods
	public VIndexTable() {
		//generate table as a component
		this.table = new JTable();
		this.setViewportView(this.table);
		MouseHandler mouseHandler = new MouseHandler();
		this.table.addMouseListener(mouseHandler);
		
		
		
		//associate table with a model
		String header[] = {	"ID", "Campus" };
			this.model = new DefaultTableModel(null, header);
			this.table.setModel(this.model);
			
		
	
			
		
	
	
	}
	
	//working variables
	private int selectedRow;
	public void show(String fileName) {
		CIndex cIndex = new CIndex();
		Vector<MIndex> mIndexList = cIndex.getList(fileName);
		
		//get data from campus
		String[] row = new String[2];
		for (MIndex mIndex: mIndexList) {
			
			row[0] = String.valueOf(mIndex.getId());
			row[1] = mIndex.getName();
			this.model.addRow(row);
			this.next.show(fileName);
		
	}
		this.updateUI();
		if (this.next != null) {
			this.next.show(mIndexList.get(0).getFileName());
		}
	}
	
/*	private void showNext(int selectedIndex) {
		if (this.next != null) {
			this.next.show(mIndexList.get(0).getFileName());
		}
	}*/
	private class MouseHandler implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			//showNext(table.get)
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
			
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
