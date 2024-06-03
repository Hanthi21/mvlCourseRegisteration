package view;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Model.MIndex;
import Model.MLecture;
import constants.Constant.MainFrame;
import constants.Constant.indexTable;
import constants.Constant.indexTable.EColumnTitle;
import control.CIndex;

public class VIndexTable extends JScrollPane implements IIndex {
	//attributes
	
	private static final long serialVersionUID = MainFrame.VersionID;
	
	
	//Components
	
	private JTable table;
	private DefaultTableModel model;
	private List<MIndex> mIndexList;
	private IndexType indexType;

	
	
	//association
	private IIndex next;
	public void setNext(IIndex next) {this.next = next;}
	
	//methods
	public VIndexTable(IndexType indexType) {
		this.indexType = indexType;
		//generate table as a component
		this.table = new JTable();
		this.setViewportView(this.table);
		
	
		MouseHandler mouseHandler = new MouseHandler();
		this.table.addMouseListener(mouseHandler);
		this.newModel();
		this.mIndexList = new ArrayList<>();
		
		//List selection listener to the table
		/*this.table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int selectedRow = table.getSelectedRow();
					if(selectedRow != -1) {
						showNext(selectedRow);
						updateLectureTable(selectedRow);
					}
					
				
			}
		}
		});*/
	
		
			
			
	
	}
	private void newModel() {
		//associate the table with a model
		String header[] = {	"ID", getIndexColumnTitle() };
		this.model = new DefaultTableModel(null, header) {
			//making cells not editable by the user
			public boolean isCellEditable(int rowIndex,int columnIndex) {
				return false;
				
		}
		};
		this.table.setModel(this.model);
		
	}
	
	private String getIndexColumnTitle() {
		switch(indexType) {
		case CAMPUS:
			return EColumnTitle.eCampus.getTitle();
		case COLLEGE:
			return EColumnTitle.eCollege.getTitle();
		case DEPARTMENT:
			return EColumnTitle.eDepartment.getTitle();
		default:
			return "";
		}
	}
	  

		public void show(String fileName) {
			//get data from CIndex
		CIndex cIndex = new CIndex();
		 this.mIndexList = cIndex.getList(fileName+".txt");
		 //set data to model
		this.model.setRowCount(0);
		
		
		
		for (MIndex mIndex: this.mIndexList) {
			String[] row = new String[2];
			row[0] = String.valueOf(mIndex.getId());
			row[1] = mIndex.getName();
			this.model.addRow(row);
		
	}
		this.table.setRowSelectionInterval(0,0);
	this.updateUI();
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

		public enum IndexType{
			CAMPUS,
			COLLEGE,
			DEPARTMENT
		}

		public void addSelectedLectureList(List<MLecture> selectedLectureList, String department) {
			// TODO Auto-generated method stub
			for(MLecture mLecture : selectedLectureList) {
				
				
				String row[] = new String[2];
				row[0] = String.valueOf(mLecture.getCode());
				row[1] = mLecture.getlName();
				this.model.addRow(row);
			}
			this.updateUI();
		}

	}

