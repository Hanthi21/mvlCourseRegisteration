package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import Model.MLecture;
import constants.Constant.MainFrame;
import control.CIndex;
import main.Main;

public class VCourseRegistration extends JPanel {
	//attributes
	private static final long serialVersionUID = MainFrame.VersionID;
	
	//components
	private VSelectionPanel vSelectionPanel;
	private VControlPanel vControlPanel1;
	private VLectureTable vPreRegister;
	private VControlPanel vControlPanel2;
	private VLectureTable vRegister;
	private JButton logoutButton;
	private JButton profileButton;

	
	
	
	//methods
	public VCourseRegistration() {
		
		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layoutManager);
		
		
		//components
		this.vSelectionPanel = new VSelectionPanel();
		this.add(vSelectionPanel);
		
		this.vControlPanel1 = new VControlPanel();
		this.add(vControlPanel1);
		
		this.vPreRegister = new VLectureTable();
		this.add(vPreRegister);
		
		this.vControlPanel2 = new VControlPanel();
		this.add(vControlPanel2);
		
		this.vRegister = new VLectureTable();
		this.add(vRegister);
		
		
		//logout button 
		logoutButton = new JButton("Logout");
		logoutButton.setFont(new Font("Tahoma",Font.PLAIN,14));
		logoutButton.setAlignmentX(CENTER_ALIGNMENT);
		logoutButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = (JFrame)SwingUtilities.getWindowAncestor(VCourseRegistration.this);
				frame.dispose();
				
				
			}
			
		});
		add(logoutButton);
		
		

		
	//association
		this.vControlPanel1.associate(this.vSelectionPanel.getLectureTable(),this.vPreRegister);
		this.vControlPanel2.associate(this.vPreRegister,this.vRegister);	
	
	
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
