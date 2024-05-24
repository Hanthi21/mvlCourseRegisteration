package view;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Model.MLecture;

public class VSelectionPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	//components
	private VIndexPanel vIndexPanel;
	private VLectureTable vLectureTable;
	private VPreRegister vPreRegisterTable;
	
	
	public VSelectionPanel() {
		
		LayoutManager layoutManager = new BoxLayout(this,BoxLayout.Y_AXIS);
		this.setLayout(layoutManager);
		
		
		this.vLectureTable = new VLectureTable();
		this.vIndexPanel = new VIndexPanel(vLectureTable);
		
		
		this.vPreRegisterTable = new VPreRegister();
		
		
		
		
		this.add(vIndexPanel);
		this.add(vLectureTable);

	}

	public void initialize() {
		this.vIndexPanel.initialize();
		this.vLectureTable.initialize();
		
	}

	public VLectureTable getVLectureTable() {
		return vLectureTable;
	}

}
