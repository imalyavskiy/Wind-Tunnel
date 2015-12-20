package org.demons.gui;

import java.awt.Toolkit;
import javax.swing.*;

public class OperationFrame extends JFrame {
	private static final long serialVersionUID = -3754531649923171524L;
	
	private JPanel content;
	private JPanel left, center, right;
	
	private JSeparator divL, divR;
	
	public OperationFrame() {
		super("Maxwell's Demons");
		
		setExtendedState(MAXIMIZED_BOTH);
		setUndecorated(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		initContent();
		
		setVisible(true);
	}
	
	private void initContent() {
		int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int div1 = width / 5;
		int div2 = width / 5 * 4;
		
		content = new JPanel();
		content.setLayout(null);
		content.setBounds(0, 0, width, height);
		
		left = new JPanel();
		center = new JPanel();
		right = new JPanel();
		
		divL = new JSeparator(JSeparator.VERTICAL);
		divR = new JSeparator(JSeparator.VERTICAL);		
		
		left.setBounds(0, 0, div1-1, height);
		center.setBounds(div1+1, 0, div2-div1-1, height);
		right.setBounds(div2+1, 0, width-div2-1, height);
				
		divL.setBounds(div1, 0, div1, height);
		divR.setBounds(div2, 0, div2, height);
				
		content.add(left);
		content.add(center);
		content.add(right);
		
		content.add(divL);
		content.add(divR);
		
		setContentPane(content);
		pack();
	}
}