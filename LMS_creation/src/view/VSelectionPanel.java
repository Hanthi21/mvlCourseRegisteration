package view;

import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Model.MLecture;
import constants.Constant.MainFrame;

public class VSelectionPanel extends JPanel {
	private static final long serialVersionUID = MainFrame.VersionID;
	
	//components
	private VIndexPanel vIndexPanel;
	private VLectureTable vLectureTable;
	
	
	
	public VSelectionPanel() {
		
		
		LayoutManager layoutManager = new BoxLayout(this,BoxLayout.X_AXIS);
		this.setLayout(layoutManager);
		
		this.vIndexPanel = new VIndexPanel();
		 this.vIndexPanel.setPreferredSize(new Dimension(700,400)); 
		this.add(vIndexPanel);
		
		this.vLectureTable = new VLectureTable();
		 
		this.add(vLectureTable);
		
		//association
		this.vIndexPanel.associate(this.vLectureTable);
	

	}

	public void initialize() {
		this.vIndexPanel.initialize();
		this.vLectureTable.initialize();
		
	}

	public VLectureTable getLectureTable() {
				return this.vLectureTable;
	}

	


}
