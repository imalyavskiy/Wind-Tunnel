package org.demons.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

import org.demons.gui.ArduinoStatSummary.Listing;
import org.demons.utils.MegaConstants;
import org.zu.ardulink.Link;
import org.zu.ardulink.protocol.IProtocol;

import com.sun.corba.se.impl.orbutil.threadpool.TimeoutException;

class HistoryValuesPanel extends JPanel {
	private static final long serialVersionUID = -2739228960818599179L;
	private Link link = null;
	
	private final int PADDING = 10;
	
	private Font titleFont, regularFont, tableFont;
	
	private JLabel title;
	private JPanel descBar, mainPanel;
	private JScrollPane scrollPanel;
	private JTextArea scrollArea;
	private JButton startButton;
	String textString = " ";

	public HistoryValuesPanel(int width, int height, OperationFrame parent) {
		super();
		
		setLayout(null);
		setSize(width, height);
		
		titleFont = new Font("Century", Font.BOLD, 14);
		regularFont = new Font("Dialog", Font.BOLD, 14);
		tableFont = new Font("Dialog", Font.BOLD, 12);
		
		title = new JLabel("HISTORY OF VALUES", JLabel.CENTER);
		title.setFont(titleFont);
		title.setBounds(PADDING, PADDING, width-2*PADDING, 15);
		title.setForeground(Color.BLUE);
		
		descBar = new JPanel();
		descBar.setLayout(new GridLayout(1, 4));
		JLabel time = new JLabel("Time");
		time.setFont(tableFont);
		JLabel speed = new JLabel("Speed");
		speed.setFont(tableFont);
		JLabel lift = new JLabel("Lift");
		time.setFont(tableFont);
		JLabel drag = new JLabel("Drag");
		speed.setFont(tableFont);
		descBar.add(time);
		descBar.add(new JSeparator(JSeparator.VERTICAL));
		descBar.add(speed);
		descBar.add(new JSeparator(JSeparator.VERTICAL));
		descBar.add(lift);
		descBar.add(new JSeparator(JSeparator.VERTICAL));
		descBar.add(drag);
		descBar.setBounds(PADDING, PADDING+title.getHeight(), width-2*PADDING, tableFont.getSize()+2);

		mainPanel = new JPanel();
		mainPanel.setBounds(PADDING, 2*PADDING+title.getHeight()+descBar.getHeight(), width-2*PADDING, height-3*PADDING-title.getHeight()-descBar.getHeight());
			
		startButton = new JButton("START");
		
		scrollArea = new JTextArea(10,10);
		scrollArea.setEditable(false);
		
		scrollPanel = new JScrollPane(scrollArea);		
		scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		textString += "\n"+(parent.getAss().getInfo(true,1)+parent.getAss().getInfo(true,2)+parent.getAss().getInfo(true,3));
		scrollArea.setText(textString);
		
		mainPanel.add(scrollPanel);	
		mainPanel.add(startButton);
		
		add(title);
		add(descBar);
		add(mainPanel);
		
		repaint();
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, getWidth(), getHeight());
	}
}
