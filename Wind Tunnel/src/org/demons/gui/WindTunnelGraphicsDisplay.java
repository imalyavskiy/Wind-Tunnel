package org.demons.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.sun.corba.se.spi.orbutil.fsm.Action;

class WindTunnelGraphicsDisplay extends JPanel implements ActionListener {
	private static final long serialVersionUID = -2739228960818599179L;

	public WindTunnelGraphicsDisplay(int width, int height) {
		super();
		
		setLayout(null);
		setSize(width, height);
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("A1")) {
			
		} else if(e.getActionCommand().equals("A2")) {
			
		} else if(e.getActionCommand().equals("A3")) {
			
		} else if(e.getActionCommand().equals("A4")) {
			
		}
	}
}
