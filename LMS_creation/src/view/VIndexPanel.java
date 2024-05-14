package view;

import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class VIndexPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	
	private VIndexTable vCampus;
	private VIndexTable vCollege;
	private VIndexTable vDepartment;
	private VLectureTable vLectureTable;

	public VIndexPanel() {
		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(layoutManager);
		
		this.vCampus = new VIndexTable();
		this.add(vCampus);
		
		this.vCollege = new VIndexTable();
		this.add(vCollege);
		
		this.vDepartment = new VIndexTable();
		this.add(vDepartment);
		
		this. vLectureTable = new VLectureTable();
		this.add(vLectureTable);
		
		this.vCampus.setNext(this.vCollege);
		this.vCollege.setNext(this.vDepartment);
	}

	public void initialize() {
		this.vCampus.show("root.txt");
		this.vCollege.show("seoul.txt");
		this.vCollege .show("yongin.txt");
		this.vDepartment.show("generalS.txt");
		this.vDepartment.show("ict.txt");
		this.vDepartment.show("business.txt");
		this.vDepartment.show("social.txt");
		this.vDepartment.show("human.txt");
		this.vDepartment.show("law.txt");
		this.vDepartment.show("generalY.txt");
		this.vDepartment.show("engineering.txt");
		this.vDepartment.show("science.txt");
		this.vDepartment.show("art.txt");
		this.vDepartment.show("architecture.txt");
		
	
	}
	
	
}
