package org.demons.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import org.demons.gui.ArduinoStatSummary.Listing;
import org.zu.ardulink.Link;
import org.zu.ardulink.RawDataListener;
import org.zu.ardulink.event.DigitalReadChangeEvent;
import org.zu.ardulink.event.DigitalReadChangeListener;
import org.zu.ardulink.gui.ConnectionStatus;
import org.zu.ardulink.gui.DigitalPinStatus;
import org.zu.ardulink.gui.SerialConnectionPanel;
import org.zu.ardulink.gui.SwitchController;

public class ArduinoCommunicationPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = -2739228960818599179L;
	
	private Link link = null;
	
	private final int PADDING = 25;
	private final int DOT_RADIUS = 50;
	
	private final SerialConnectionPanel serialConnectionPanel;
	private JButton btnConnect;
	private JButton btnDisconnect;
	
	private boolean isBuilt = false;
	
	public ArduinoCommunicationPanel(int width, int height) {
		super();
		
		setSize(width, height);
		setBorder(new EmptyBorder(PADDING, PADDING, PADDING, PADDING));
		setLayout(new BorderLayout(0, 0));
		
		/*
		 * GUI to select connection port
		 */
		serialConnectionPanel = new SerialConnectionPanel();
		serialConnectionPanel.setOpaque(false);
		add(serialConnectionPanel, BorderLayout.NORTH);
		
		/*
		 * Code for connect and disconnect buttons
		 */
		ConnectionStatus connectionStatus = new ConnectionStatus();
		connectionStatus.setOpaque(false);
		add(connectionStatus, BorderLayout.CENTER);
		
		JPanel connectPanel = new JPanel();
		connectPanel.setOpaque(false);
		add(connectPanel, BorderLayout.SOUTH);

		btnConnect = new JButton("Connect");
		btnConnect.addActionListener(this);
		connectPanel.add(btnConnect);
		
		btnDisconnect = new JButton("Disconnect");
		btnDisconnect.addActionListener(this);
		connectPanel.add(btnDisconnect);
		
		isBuilt = true;
		
		repaint();
	}
	
	public void setLink(Link l) {
		link = l;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(new Color(128, 255, 128));
		g.fillRect(0, 0, getWidth(), getHeight());
		
		if(link != null && link.isConnected()) {
			g.setColor(Color.GREEN);
		} else {
			g.setColor(Color.RED);
		}
		g.fillOval(getWidth()/2-DOT_RADIUS, getHeight()/2, 2*DOT_RADIUS, 2*DOT_RADIUS);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnConnect) {
			String comPort = serialConnectionPanel.getConnectionPort();
			String baudRateS = serialConnectionPanel.getBaudRate();
					
			try {
				int baudRate = Integer.parseInt(baudRateS);
									
				link.connect(comPort, baudRate);
			} catch(Exception ex) {
				ex.printStackTrace();
				String message = ex.getMessage();
				if(message == null || message.trim().equals("")) {
					message = "Generic Error on connection";
				}
				JOptionPane.showMessageDialog(btnConnect, message, "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else if(e.getSource() == btnDisconnect) {
			link.disconnect();
		}
		repaint();
	}
}
