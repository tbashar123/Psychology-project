package Gui;

public class Show_Project1 {

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				ProjectJFrame newGUI = new ProjectJFrame();
			}
		});
	}
}


