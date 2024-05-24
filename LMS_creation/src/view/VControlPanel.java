package view;

import java.awt.LayoutManager;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class VControlPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JButton deleteButton;
	private JButton addButton;
	

	
	public VControlPanel(ActionListener deleteAction, ActionListener addAction) {
		//add color , try grid layout

		JPanel yGap = new JPanel();
		yGap.setSize(5,5);
		this.add(yGap);
		
		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layoutManager);
		
		
		this.deleteButton = new JButton("<<");
		this.add(deleteButton);
		this.deleteButton.addActionListener(deleteAction);
		
	
	
		yGap = new JPanel();
		yGap.setSize(5,5);
		this.add(yGap);
		
		this.addButton = new JButton(">>");
		this.add(addButton);
		this.addButton.addActionListener(addAction);
		
		

		yGap = new JPanel();
		yGap.setSize(5,5);
		this.add(yGap);
	}

	public void initialize() {
		// TODO Auto-generated method stub
		
	}
	
}
