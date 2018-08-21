package edwin.alkins.software.memo.launcher;

import java.awt.EventQueue;

import edwin.alkins.software.memo.core.initialize.InitializeDirectory;
import edwin.alkins.software.memo.ihm.frame.WindowsDisplayer;

public class Main {

	public static void main(String[] args) {
		InitializeDirectory.getInstance().initialize();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowsDisplayer window = new WindowsDisplayer();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
