package org.demons.gui;

import javax.swing.*;

public class OperationFrame extends JFrame {
	private static final long serialVersionUID = -3754531649923171524L;

	public OperationFrame() {
		super("Maxwell's Demons");
		
		setExtendedState(MAXIMIZED_BOTH);
		setUndecorated(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setVisible(true);
	}
}
