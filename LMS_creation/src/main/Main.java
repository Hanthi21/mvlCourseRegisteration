package main;

import view.VMainFrame;

//import javax.swing.JFrame;

public class Main {
		//components
		private VMainFrame vMainFrame;
		
		
		//constructors
		public Main() {
			//attributes
			
			//components
			this.vMainFrame = new VMainFrame();
			this.vMainFrame.setVisible(true);
			
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

}
