package view;
import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Model.MLecture;
import control.CIndex;

public class VCourseRegistration extends JPanel {
	//attributes
	private static final long serialVersionUID = 1L;
	
	//components
	private VSelectionPanel vSelectionPanel;
	private VControlPanel vControlPanel1;
	private VPreRegister vPreRegister;
	private VControlPanel vControlPanel2;
	private VLectureTable vRegister;
	
	
	
	
	//methods
	public VCourseRegistration() {
		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(layoutManager);
		
		
		//components
		
		this.vSelectionPanel = new  VSelectionPanel();
		this.add(vSelectionPanel);
		
		this.vControlPanel1 = new VControlPanel(new DeleteFromPreRegister(), new AddToPreRegister());
		this.add(vControlPanel1);
		
		this.vPreRegister = new VPreRegister();
		this.add(vPreRegister);
		
		this.vControlPanel2 = new VControlPanel(new DeleteFromRegister(), new AddToRegister());
		this.add(vControlPanel2);
		
		
		this.vRegister = new VLectureTable();
		this.add(vRegister);
		
		
		
		
		
		
	
	
	}
	
	
	
	
	
public void initialize() {
	this.vSelectionPanel.initialize();
	
	this.vPreRegister.initialize();

	this.vRegister.initialize();
}

private class DeleteFromPreRegister implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		vPreRegister.deleteSelectedLecture();
		
	}
	
}

private class AddToPreRegister implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		MLecture selectedLecture = vSelectionPanel.getVLectureTable().getSelectedLecture();
		if(selectedLecture != null) {
			vPreRegister.addLecture(selectedLecture);
			
		}
		
	}
	
}

private class DeleteFromRegister implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		vPreRegister.deleteSelectedLecture();
	}
	
}
private class AddToRegister implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		MLecture selectedLecture = vPreRegister.getSelectedLecture();
		if(selectedLecture != null) {
			//vRegister.addLecture(selectedLecture);
		}
	}
	
}
public void finish() {
	
}
public void run() {
	
}
}
