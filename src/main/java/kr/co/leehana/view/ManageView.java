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
		setupPanel(mainPanel, new Rectangle(0, -30, width, height));

		ClockBorderPanel clockPanel = new ClockBorderPanel();
		setupPanel(clockPanel, new Rectangle(15, 20, 179, 149));
		new Thread(clockPanel).start();

		ClockMessage clockMessage = new ClockMessage();
		setupPanel(clockMessage, new Rectangle(80, 53, 100, 100));
		new Thread(clockMessage).start();

		LightningPanel lightningPanel = new LightningPanel();
		setupPanel(lightningPanel, new Rectangle(0, -30, width, height));
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

	private void setupPanel(JPanel panel, Rectangle rectangle) {
		panel.setLayout(null);
		panel.setOpaque(false);
		panel.setBounds(rectangle);
	}

	public static void main(String[] args) {
		new ManageView();
	}
}
