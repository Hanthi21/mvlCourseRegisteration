package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;


public class VMainFrame extends JFrame {
	
	
	private static final long serialVersionUID = 1L;
	
	
		//attributes
	
	
		//components
	
	
	private VCourseRegistration vCourseRegistration;
	
	
	
	public VMainFrame() {
		
		
		
		//attributes
		
		this.setSize(1000,700);
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
