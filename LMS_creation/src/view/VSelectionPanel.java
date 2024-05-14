package view;

import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class VSelectionPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	//components
	private VIndexPanel vIndexPanel;
	private VLectureTable vLectureTbale;
	
	public VSelectionPanel() {
		
		LayoutManager layoutManager = new BoxLayout(this,BoxLayout.Y_AXIS);
		this.setLayout(layoutManager);
		
		this.vIndexPanel = new VIndexPanel();
		this.add(vIndexPanel);
		
		this.vLectureTbale = new VLectureTable();
		this.add(vLectureTbale);
	}

	public void initialize() {
		this.vIndexPanel.initialize();
		this.vLectureTbale.initialize();
		
	}


}
