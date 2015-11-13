package kr.co.leehana.view;

import kr.co.leehana.view.panel.ClockBorderPanel;
import kr.co.leehana.view.panel.ClockMessage;
import kr.co.leehana.view.panel.LightningPanel;
import kr.co.leehana.view.panel.ManageViewMainPanel;

import javax.swing.*;
import java.awt.*;

/**
 * @author Hana Lee
 * @since 2015-11-13 20-06
 */
public class ManageView extends JFrame {

	private static final long serialVersionUID = -7777187062556506831L;
	private static final int width = 1600;
	private static final int height = 900;

	public ManageView() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(width, height);
		setTitle("관리 화면");
		setLayout(null);

		setCenterLocation();

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, width, height);
		layeredPane.setLayout(null);

		JPanel mainPanel = new ManageViewMainPanel();
		mainPanel.setLayout(null);
		mainPanel.setBounds(0, -30, width, height);

		ClockBorderPanel clockPanel = new ClockBorderPanel();
//		clockPanel.setLayout(null);
		clockPanel.setBounds(15, 20, 179, 149);
		clockPanel.setOpaque(false);
		new Thread(clockPanel).start();

		ClockMessage clockMessage = new ClockMessage();
		clockMessage.setBounds(80, 53, 100, 100);
		clockMessage.setOpaque(false);
		new Thread(clockMessage).start();

		LightningPanel lightningPanel = new LightningPanel();
//		lightningPanel.setLayout(null);
		lightningPanel.setBounds(0, -30, width, height);
		lightningPanel.setOpaque(false);
		new Thread(lightningPanel).start();

		layeredPane.add(mainPanel, new Integer(0));
		layeredPane.add(clockPanel, new Integer(3));
		layeredPane.add(clockMessage, new Integer(4));
		layeredPane.add(lightningPanel, new Integer(1));

		add(layeredPane);

		setVisible(true);
	}

	private void setCenterLocation() {
		Dimension frameSize = this.getSize();
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2);
	}


	public static void main(String[] args) {
		new ManageView();
	}
}
