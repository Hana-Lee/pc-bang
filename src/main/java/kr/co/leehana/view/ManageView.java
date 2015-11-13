package kr.co.leehana.view;

import kr.co.leehana.view.panel.ClockBorderPanel;
import kr.co.leehana.view.panel.ClockMessage;
import kr.co.leehana.view.panel.ConstraintPanel;
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
		layeredPane.setLayout(null);
		layeredPane.setBounds(new Rectangle(0, 0, width, height));

		ConstraintPanel mainPanel = new ManageViewMainPanel(0);
		setupPanel(mainPanel, new Rectangle(0, -30, width, height));

		ConstraintPanel clockPanel = new ClockBorderPanel(3);
		setupPanel(clockPanel, new Rectangle(15, 20, 179, 149));

		ConstraintPanel clockMessage = new ClockMessage(4);
		setupPanel(clockMessage, new Rectangle(80, 53, 100, 100));

		ConstraintPanel lightningPanel = new LightningPanel(1);
		setupPanel(lightningPanel, new Rectangle(0, -30, width, height));

		startThread(clockPanel, clockMessage, lightningPanel);

		addToLayeredPanel(layeredPane, mainPanel, clockPanel, clockMessage, lightningPanel);

		add(layeredPane);

		setVisible(true);
	}

	private void setCenterLocation() {
		Dimension frameSize = this.getSize();
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2);
	}

	private void setupPanel(ConstraintPanel panel, Rectangle rectangle) {
		((JComponent) panel).setLayout(null);
		((JComponent) panel).setOpaque(false);
		((JComponent) panel).setBounds(rectangle);
	}

	private void startThread(ConstraintPanel... panels) {
		for (ConstraintPanel panel : panels) {
			new Thread((Runnable) panel).start();
		}
	}

	private void addToLayeredPanel(JLayeredPane layeredPane, ConstraintPanel... panels) {
		for (ConstraintPanel panel : panels) {
			layeredPane.add((Component) panel, panel.getConstrains());
		}

	}

	public static void main(String[] args) {
		new ManageView();
	}
}
