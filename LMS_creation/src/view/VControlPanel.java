package view;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import Model.MLecture;
import constants.Constant.MainFrame;

public class VControlPanel extends JPanel {
	//attribute
	private static final long serialVersionUID = MainFrame.VersionID;
	//component
	private JButton leftButton;
	private JButton rightButton;
	
	//associate
	private VLectureTable vLectureTable1;
	private VLectureTable vLectureTable2;
	
	
	public VControlPanel() {
		
		//add color , try grid layout
		JPanel yGap = new JPanel();
		yGap.setSize(0,2);
		this.add(yGap);
		
		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(layoutManager);
		
		ActionListener actionHandler = new ActionHandler();
	
		
		this.rightButton = new JButton("Add");
		this.rightButton.addActionListener(actionHandler);
		this.add(rightButton);
		
		yGap = new JPanel();
		yGap.setSize(0,2);
		this.add(yGap);
		
		this.leftButton = new JButton("Remove");
		this.leftButton.addActionListener(actionHandler);
		this.add(leftButton);
		
		yGap = new JPanel();
		yGap.setSize(0,2);
		this.add(yGap);
		
		
		
	
	}

	public void initialize() {
	
	}
	

	public void associate(VLectureTable vLectureTable1, VLectureTable vLectureTable2) {
		this.vLectureTable1 = vLectureTable1;
		this.vLectureTable2 = vLectureTable2;
	}
	
	private void moveRight() {
		Vector<MLecture> selectedLectureList = vLectureTable1.getSelectedLectureList();
		this.vLectureTable1.removeSelectedLectures(selectedLectureList); 
		this.vLectureTable2.addSelectedLectureList(selectedLectureList,"LectureTable2");
		
	
	}
	
	private void moveLeft() {
		Vector<MLecture> selectedLectureList = this.vLectureTable2.getSelectedLectureList();
		this.vLectureTable2.removeSelectedLectures(selectedLectureList);
		this.vLectureTable1.addSelectedLectureList(selectedLectureList, vLectureTable2.getClass().getSimpleName());
		
		
	}
	

	private class ActionHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		if(e.getSource() == rightButton) {
			moveRight();
			
		}else if(e.getSource() == leftButton) {
			moveLeft();
		}
			
		}
		
	}
}
