package kr.co.leehana.view.panel;

import kr.co.leehana.view.ManageView;

import javax.swing.*;
import java.awt.*;

/**
 * @author Hana Lee
 * @since 2015-11-14 00-34
 */
public class ClockBorderPanel extends JPanel implements Runnable {

	private Image[] images = new Image[4];
	private int i = 1;

	public ClockBorderPanel() {
		images[1] = Toolkit.getDefaultToolkit().createImage(ManageView.class.getResource("/img/cl1.png"));
		images[2] = Toolkit.getDefaultToolkit().createImage(ManageView.class.getResource("/img/cl2.png"));
		images[3] = Toolkit.getDefaultToolkit().createImage(ManageView.class.getResource("/img/cl3.png"));

		images[0] = images[1];
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(images[0], 0, 0, this);
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(10000);

				switch (i) {
					case 1:
						images[0] = images[i];
						i++;
						repaint();
						break;
					case 2:
						images[0] = images[i];
						i++;
						repaint();
						break;
					case 3:
						images[0] = images[i];
						i = 1;
						repaint();
						break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
