package org.demons;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import org.demons.gui.*;

public class Launch {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(NimbusLookAndFeel.class.getCanonicalName());
					new OperationFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
