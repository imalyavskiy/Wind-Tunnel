package org.demons.test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import org.zu.ardulink.Link;
import org.zu.ardulink.event.DigitalReadChangeEvent;
import org.zu.ardulink.event.DigitalReadChangeListener;
import org.zu.ardulink.gui.SwitchController;

public class DigitalPinStatus extends JPanel implements ActionListener {
	private static final long serialVersionUID = -7773514191770737230L;

	private Link link = Link.getDefaultInstance();
	
	private static final String HIGH = "High";
	private static final String LOW = "Low";
	
	private DigitalReadChangeListener drcl;

	/**
	 * Create the panel.
	 */
	public DigitalPinStatus() {
		link.connect("COM6");
		drcl = new DigitalReadChangeListener() {
			@Override
			public void stateChanged(DigitalReadChangeEvent e) {
				int value = e.getValue();
				if(value == DigitalReadChangeEvent.POWER_HIGH) {
					System.out.println(HIGH);
				} else if(value == DigitalReadChangeEvent.POWER_LOW) {
					System.out.println(LOW);
				}
				repaint();
			}
			
			@Override
			public int getPinListening() {
				return 52;
			}
		};
		
		JButton b = new JButton("ON");
		b.addActionListener(this);
		add(b);
		
		SwitchController switchController = new SwitchController();
		add(switchController);
		switchController.setPin(53);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		link.addDigitalReadChangeListener(drcl);
		getParent().setEnabled(false);
	}
}
