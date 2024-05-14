package view;
import java.awt.Color;
import java.awt.LayoutManager;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import control.CIndex;

public class VCourseRegistration extends JPanel {
	//attributes
	private static final long serialVersionUID = 1L;
	
	//components
	private VSelectionPanel vSelectionPanel;
	private VControlPanel vControlPanel1;
	private VLectureTable vPreRegister;
	private VControlPanel vControlPanel2;
	private VLectureTable vRegister;
	
	
	
	
	//methods
	public VCourseRegistration() {
		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(layoutManager);
		
		
		//components
		
		this.vSelectionPanel = new  VSelectionPanel();
		this.add(vSelectionPanel);
		
		this.vControlPanel1 = new VControlPanel();
		this.add(vControlPanel1);
		
		this.vPreRegister = new VLectureTable();
		this.add(vPreRegister);
		
		this.vControlPanel2 = new VControlPanel();
		this.add(vControlPanel2);
		
		
		this.vRegister = new VLectureTable();
		this.add(vRegister);
		
		
		
		
		
		
	
	
	}
	
	
	
	
	
public void initialize() {
	this.vSelectionPanel.initialize();
	this.vControlPanel1.initialize();
	this.vPreRegister.initialize();
	this.vControlPanel2.initialize();
	this.vRegister.initialize();
}
public void finish() {
	
}
public void run() {
	
}
}
