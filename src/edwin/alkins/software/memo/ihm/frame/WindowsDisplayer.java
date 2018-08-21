package edwin.alkins.software.memo.ihm.frame;

import javax.swing.JFrame;

public class WindowsDisplayer {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public WindowsDisplayer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setVisible(boolean b) {
		this.frame.setVisible(b);
	}
}
