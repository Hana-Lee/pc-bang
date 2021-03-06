package kr.co.leehana.view;

import kr.co.leehana.Utils.ResourceUtils;

import javax.swing.*;
import java.awt.*;

/**
 * @author Hana Lee
 * @since 2015-11-13 20-15
 */
public class SeatViewTest extends JFrame {

	private static final long serialVersionUID = 38268215464758554L;

	public SeatViewTest() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("좌석 뷰");
		setSize(400, 400);

		JPanel mainPanel = new MainPanel();
		add(mainPanel, BorderLayout.CENTER);

		setVisible(true);
	}

	class MainPanel extends JPanel {
		private final Image image = ResourceUtils.getImage("gameOff.png");

		public MainPanel() {
		}

		@Override
		public void paint(Graphics g) {
			g.drawImage(image, 99, 99, this);
		}
	}

	public static void main(String[] args) {
		new SeatViewTest();
	}
}
