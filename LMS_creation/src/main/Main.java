package main;

import javax.swing.JOptionPane;

import view.VLoginDialog;
import view.VMainFrame;

//import javax.swing.JFrame;

public class Main {
		//components
		private VMainFrame vMainFrame;
		
		
		//constructors
		public Main() {
		VLoginDialog loginDialog = new VLoginDialog(this);//Pass 'this' to login dialog
		//loginDialog.setModal(true);//blocking the other windows until this dialog is closed
		loginDialog.setVisible(true);
		
			//attributes
			
			
			//components
			this.vMainFrame = new VMainFrame();
			this.vMainFrame.setVisible(false);//not visible initially
			
			//associations
		}
		private void initialize() {
			this.vMainFrame.initialize();
			
		}
		//methods
		private void run() {
			
		}
		public static void main(String[] args) {
			Main main = new Main();
			main.initialize();
			main.run();
		}
		public void showMainFrame() {
			this.vMainFrame.setVisible(true);
		}
}
