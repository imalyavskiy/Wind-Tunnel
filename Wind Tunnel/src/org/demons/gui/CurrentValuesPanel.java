package org.demons.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.xml.internal.bind.v2.runtime.Coordinator;

class CurrentValuesPanel extends JPanel {
	private static final long serialVersionUID = -2739228960818599179L;
	private Font titleFont, bodyFont;
	private Color lilac;
	private JPanel mainPanel;
	private JLabel title, speed, lift, drag;
	private final int PADDING = 10;
	
	private OperationFrame parent;
	
	public CurrentValuesPanel(int width, int height,  OperationFrame parent) {
		super();
		
		this.parent = parent;
		
		setLayout(null);
		setSize(width, height);		
		
		titleFont = new Font("Century", Font.BOLD, 16);
		bodyFont = new Font("Arial", Font.PLAIN, 30);
		
		title = new JLabel("CURRENT VALUES", JLabel.CENTER);
		title.setFont(titleFont);
		title.setBounds(PADDING+5, PADDING+10, width-2*PADDING, 16);
		title.setForeground(new Color(115, 51, 115));
		
		mainPanel = new JPanel(new GridLayout(3, 1));
		
		speed = new JLabel("Speed: 0 m/s");
		lift = new JLabel("Lift: 0 N");
		drag = new JLabel("Drag: 0 N");
		
		speed.setForeground(Color.DARK_GRAY);
		lift.setForeground(Color.DARK_GRAY);
		drag.setForeground(Color.DARK_GRAY);
		
		speed.setFont(bodyFont);
		lift.setFont(bodyFont);
		drag.setFont(bodyFont);
		
		speed.setHorizontalAlignment(JLabel.CENTER);
		lift.setHorizontalAlignment(JLabel.CENTER);
		drag.setHorizontalAlignment(JLabel.CENTER);
		
		mainPanel.add(speed);
		mainPanel.add(lift);
		mainPanel.add(drag);
		
		mainPanel.setBounds(PADDING, 3*PADDING+title.getHeight(), width-2*PADDING, height-4*PADDING-title.getHeight());
		
		add(title);
		add(mainPanel);
			
		repaint();
	}
	
	public void updateCurrentValues()
	{
		speed.setText("Speed: "+ parent.getAss().getInfo(false,10)+" m/s");
		lift.setText("Lift: "+ parent.getAss().getInfo(false,11)+" N");
		drag.setText("Drag: "+ parent.getAss().getInfo(false,12)+" N");
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		lilac = new Color(200, 163, 220);
		g.setColor(lilac);
		g.fillRect(0, 0, getWidth(), getHeight());
	}
}
