package org.demons.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

class SettingsPanel extends JPanel {
	private static final long serialVersionUID = -2739228960818599179L;
	private Font airfoilFont;
	private JButton airfoil1, airfoil2, airfoil3, airfoil4, exit, setWindspeed, setAngle;
	private SpinnerNumberModel windspeed, angle;
	
	private WindTunnelGraphicsDisplay wtgd = null;
	
	public SettingsPanel(int width, int height) {
		super();
		
		setLayout(new FlowLayout());
		setSize(width, height);
		
		airfoilFont = new Font("Century Gothic", Font.PLAIN, 20);
		
		exit = new JButton("EXIT");
		exit.setFont(new Font("Courier New", Font.BOLD, 25));
		exit.setBackground(new Color(128, 0, 64));
		exit.setForeground(Color.WHITE);
		
		airfoil1 = new JButton("Airfoil 1");
		airfoil2 = new JButton("Airfoil 2");
		airfoil3 = new JButton("Airfoil 3");
		airfoil4 = new JButton("Airfoil 4");

		airfoil1.setFont(airfoilFont);
		airfoil2.setFont(airfoilFont);
		airfoil3.setFont(airfoilFont);
		airfoil4.setFont(airfoilFont);
		
		airfoil1.setBackground(new Color(0, 83, 83));
		airfoil2.setBackground(new Color(0, 83, 83));
		airfoil3.setBackground(new Color(0, 83, 83));
		airfoil4.setBackground(new Color(0, 83, 83));
		
		airfoil1.setForeground(Color.WHITE);
		airfoil2.setForeground(Color.WHITE);
		airfoil3.setForeground(Color.WHITE);
		airfoil4.setForeground(Color.WHITE);
		
		setWindspeed = new JButton("Set Windspeed");
		setAngle = new JButton("Set Angle of Attack");
		
		setWindspeed.setFont(new Font("Arial", Font.PLAIN, 20));
		setAngle.setFont(new Font("Arial", Font.PLAIN, 20));
		
		setWindspeed.setBackground(new Color(0, 64, 0));
		setAngle.setBackground(new Color(0, 64, 0));
		
		setWindspeed.setForeground(Color.WHITE);
		setAngle.setForeground(Color.WHITE);
		
		windspeed = new SpinnerNumberModel(0, 0, 255, 1);
		angle = new SpinnerNumberModel(0, -90, 90, 1);
		
		add(exit);
		add(airfoil1);
		add(airfoil2);
		add(airfoil3);
		add(airfoil4);
		add(setWindspeed);
		add(new JSpinner (windspeed));
		add(setAngle);
		add(new JSpinner(angle));
		
		repaint();
	}
	
	public void setGraphicsDisplay(WindTunnelGraphicsDisplay wTunnelGraphicsDisplay) {
		wtgd = wTunnelGraphicsDisplay;
		
		airfoil1.setActionCommand("A1");
		airfoil1.addActionListener(wtgd);
		
		airfoil2.setActionCommand("A2");
		airfoil2.addActionListener(wtgd);
		
		airfoil3.setActionCommand("A3");
		airfoil3.addActionListener(wtgd);
		
		airfoil4.setActionCommand("A4");
		airfoil4.addActionListener(wtgd);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, getWidth(), getHeight());
	}
}
