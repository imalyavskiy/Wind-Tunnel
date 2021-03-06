package org.demons.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import org.demons.gui.ArduinoStatSummary.Listing;
import org.demons.utils.MegaConstants;
import org.zu.ardulink.Link;
import org.zu.ardulink.protocol.IProtocol;

import com.sun.corba.se.impl.orbutil.threadpool.TimeoutException;

class HistoryValuesPanel extends JPanel {
	private static final long serialVersionUID = -2739228960818599179L;
	private Link link = null;
	
	private OperationFrame parent;
	
	private final int PADDING = 10;
	
	private Font titleFont, regularFont, tableFont;
	
	private JLabel title;
	private JPanel descBar1, descBar2, mainPanel1, mainPanel2;
	private JScrollPane scrollPanel1, scrollPanel2;
	private JTextArea scrollArea1, scrollArea2;
	private String textString1 = " ";
	private String textString2 = " ";
	private double time = 0;
	private JTabbedPane tabbedpane;

	public HistoryValuesPanel(int width, int height, OperationFrame parent) {
		super();
		
		setLayout(null);
		setSize(width, height);
		
		titleFont = new Font("Century", Font.BOLD, 16);
		regularFont = new Font("Dialog", Font.BOLD, 16);
		tableFont = new Font("Dialog", Font.BOLD, 14);
		
		title = new JLabel("HISTORY OF VALUES", JLabel.CENTER);
		title.setFont(titleFont);
		title.setBounds(PADDING+5, PADDING+10, width-2*PADDING, 16);
		title.setForeground(Color.BLACK);
		
		descBar1 = new JPanel();
		JLabel desc1 = new JLabel("Time                Speed              Lift              Drag");
		desc1.setFont(tableFont);
		descBar1.add(desc1);
		descBar1.setBounds(0, 0, width,12);
		
		descBar2 = new JPanel();
		JLabel desc2 = new JLabel("Time                Speed              Lift              Drag");
		desc2.setFont(tableFont);
		descBar2.add(desc2);
		descBar2.setBounds(0, 0, width,12);
		
		mainPanel1 = new JPanel();
		
		scrollArea1 = new JTextArea(30,30);
		scrollArea1.setEditable(false);
		
		scrollPanel1 = new JScrollPane(scrollArea1);		
		scrollPanel1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		mainPanel1.add(descBar1);
		mainPanel1.add(scrollPanel1);	
		
		mainPanel2 = new JPanel();
		
		scrollArea2 = new JTextArea(30,30);
		scrollArea2.setEditable(false);
		
		scrollPanel2 = new JScrollPane(scrollArea2);		
		scrollPanel2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		mainPanel2.add(descBar2);
		mainPanel2.add(scrollPanel2);	
		
		tabbedpane = new JTabbedPane();	
		tabbedpane.add("True", mainPanel1);
		tabbedpane.add("Equivalent", mainPanel2);
		tabbedpane.setBounds(PADDING, 2*PADDING+title.getHeight()+descBar1.getHeight(), width-2*PADDING, height-3*PADDING-title.getHeight()-descBar1.getHeight());
		
		add(title);
		add(tabbedpane);
		
		this.parent = parent;
		
		repaint();
	}
	
	public void runHistory() {
		DecimalFormat df = new DecimalFormat("#.#####");
		
		textString1 += "\n        "+(df.format(time) + "\t       "+ parent.getAss().getInfo(false,10)+ "\t       " + parent.getAss().getInfo(false,11)+ "\t       " + parent.getAss().getInfo(false, 12));
		scrollArea1.setText(textString1);
		
		textString2 += "\n        "+(time + "\t       "+ parent.getAss().getInfo(false,9)+ "\t       " + parent.getAss().getInfo(false,10)+ "\t       " + parent.getAss().getInfo(false, 11));
		scrollArea2.setText(textString2);
		
		time += parent.REFRESH_RATE/1000.0;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, getWidth(), getHeight());
	}
	
}
