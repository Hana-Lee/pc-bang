package kr.co.leehana.view;

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

		setCenterLocation();

		JPanel mainPanel = new MainPanel();
		add(mainPanel, BorderLayout.CENTER);

		setVisible(true);
	}

	private void setCenterLocation() {
		Dimension frameSize = this.getSize();
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2);
	}

	class MainPanel extends JPanel {
		private Image image;

		public MainPanel() {
			image = Toolkit.getDefaultToolkit().createImage(ManageView.class.getResource("/img/mainHud_back.png"));
		}

		@Override
		public void paint(Graphics g) {
			g.drawImage(image, 0, 0, this);
		}

		@Override
		public void update(Graphics g) {
			super.update(g);
		}
	}

	public static void main(String[] args) {
		new ManageView();
	}
}
