package kr.co.leehana.view;

import kr.co.leehana.view.panel.*;

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

		ConstraintPanel seatPanels = makeSeatPanel();

		addToLayeredPanel(layeredPane, mainPanel, clockPanel, clockMessage, lightningPanel, seatPanels);

		add(layeredPane);

		setVisible(true);
	}

	private ConstraintPanel makeSeatPanel() {
		JPanel seatRootPanel = new SeatRootPanel(5);
		seatRootPanel.setLayout(null);
		seatRootPanel.setOpaque(false);
		seatRootPanel.setBounds(new Rectangle(165, 109, 1368, 686));

		int seatPositionX = 0;
		int seatPositionY = 0;
		for (int seatNumber = 0; seatNumber < 50; seatNumber++) {
			SeatPanel seatPanel = new SeatPanel(seatNumber);

			if (seatNumber % 10 == 0 && seatNumber != 0) {
				seatPositionX = 0;
				seatPositionY += 140;
			}

			seatPanel.setBounds(new Rectangle(seatPositionX, seatPositionY, 99, 99));
			seatPositionX += 135;
			seatRootPanel.add(seatPanel);
		}
		return (ConstraintPanel) seatRootPanel;
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
