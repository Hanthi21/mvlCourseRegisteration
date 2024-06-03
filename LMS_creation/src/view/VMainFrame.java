package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import constants.Constant.MainFrame;


public class VMainFrame extends JFrame {
	
	
	private static final long serialVersionUID = MainFrame.VersionID;
	
	
		//attributes
	
	
		//components
	
	
	private VCourseRegistration vCourseRegistration;
	
	
	
	public VMainFrame() {
		
		
		
		//attributes
		this.setLocation(MainFrame.X, MainFrame.Y);
		this.setSize(MainFrame.Width,MainFrame.Height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
		//components
		this.vCourseRegistration = new VCourseRegistration();
		this.add(vCourseRegistration);
		
	}
//methods 



	public void initialize() {
		this.vCourseRegistration.initialize();
	}
}
