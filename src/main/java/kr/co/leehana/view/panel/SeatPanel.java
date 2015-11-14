package kr.co.leehana.view.panel;

import kr.co.leehana.Utils.ResourceUtils;

import javax.swing.*;
import java.awt.*;

/**
 * @author Hana Lee
 * @since 2015-11-14 21:35
 */
public class SeatPanel extends JPanel {

	private static final long serialVersionUID = 1378528343405434514L;

	private Image seatOnImage = ResourceUtils.getImage("gameOn.png");
	private int number;
	private JLabel[] labels = new JLabel[4];

	public SeatPanel(int number) {
		this.number = number;

		init();
	}

	private void init() {
		setLayout(null);

		JPanel innerPanel = new InnerPanel();
		innerPanel.setBounds(0, 0, 99, 99);
		innerPanel.setOpaque(false);

		add(innerPanel);


		//상태정보 패널
		JPanel panContent = new JPanel();
		panContent.setLayout(null);
		panContent.setBounds(0, 0, 99, 99);
		int posLabel = 15;
		for (int i = 0; i < 4; i++) {
			if (i == 0) labels[i] = new JLabel((number + 1) + ". 빈자리");
			else labels[i] = new JLabel("");

			labels[i].setBounds(20, posLabel, 80, 15);
			posLabel += 16;
			labels[i].setForeground(new Color(36, 205, 198));
			labels[i].setFont(new Font("배달의민족 한나", 1, 12));
			panContent.add(labels[i]);
		}
		panContent.setOpaque(false);


		//제이레이어패널
		JLayeredPane panLayered = new JLayeredPane();
		panLayered.setBounds(0, 0, 1600, 900);
		panLayered.setLayout(null);
		panLayered.setOpaque(false);
		panLayered.add(innerPanel, new Integer(0), 0);
		panLayered.add(panContent, new Integer(1), 0);
		add(panLayered);

		setOpaque(false);
		setFocusable(true);

		setVisible(true);
	}

	class InnerPanel extends JPanel {

		private static final long serialVersionUID = 2991952005280469203L;

		@Override
		public void paint(Graphics g) {
			g.drawImage(seatOnImage, 0, 0, this);
		}
	}

	public static void main(String[] args) {
		JFrame testFrame = new JFrame();

		testFrame.setTitle("자리 패널");
		testFrame.add(new SeatPanel(1));
		testFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		testFrame.setSize(99, 144);

		testFrame.setVisible(true);
	}
}
