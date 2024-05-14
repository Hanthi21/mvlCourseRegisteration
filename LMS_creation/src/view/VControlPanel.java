package view;

import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class VControlPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JButton buttonLeft;
	private JButton buttonRight;
	
	public VControlPanel() {
		//add color , try grid layout

		JPanel yGap = new JPanel();
		yGap.setSize(5,5);
		this.add(yGap);
		
		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(layoutManager);
		
		this.buttonRight = new JButton("<<");
		this.add(buttonRight);
	
	
		yGap = new JPanel();
		yGap.setSize(5,5);
		this.add(yGap);
		
		this.buttonLeft = new JButton(">>");
		this.add(buttonLeft);
		

		yGap = new JPanel();
		yGap.setSize(5,5);
		this.add(yGap);
	}

	public void initialize() {
		// TODO Auto-generated method stub
		
	}
	
}
