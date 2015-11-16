package kr.co.leehana.view;

import kr.co.leehana.view.panel.*;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Hana Lee
 * @since 2015-11-13 20-06
 */
public class ManageView extends JFrame {

	private static final long serialVersionUID = -7777187062556506831L;
	private static final int width = 1600;
	private static final int height = 900;

	private JPanel[] seatPanels = new SeatPanel[50];
	private JPanel seatRootPanel = new SeatRootPanel(5);

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

		setupPanel((ConstraintPanel) seatRootPanel, new Rectangle(165, 109, 1368, 686));
		makeSeatPanels();
		new SeatThread().start();

		addToLayeredPanel(layeredPane, mainPanel, clockPanel, clockMessage, lightningPanel, (ConstraintPanel)
				seatRootPanel);

		add(layeredPane);

		setVisible(true);
	}

	private void makeSeatPanels() {
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
			seatPanels[seatNumber] = seatPanel;
		}
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

	class SeatThread extends Thread {
		@Override
		public void run() {
			Set<Integer> randomNumbers = new LinkedHashSet<>();

			while (randomNumbers.size() < 50) {
				int r = (int) ((Math.random() * 50));
				randomNumbers.add(r);
			}

			int tmp = 0;

			try {
				for (Integer rNumber : randomNumbers) {
					tmp++;

					if (tmp > 30) {
						Thread.sleep(5 * rNumber);
					}
					if (tmp == 50) {
						Thread.sleep(1000);
						System.out.println("50번째 좌석");
					}

					seatRootPanel.add(seatPanels[rNumber]);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new ManageView();
	}
}
