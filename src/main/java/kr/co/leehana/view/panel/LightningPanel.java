package kr.co.leehana.view.panel;

import kr.co.leehana.Utils.ResourceUtils;
import kr.co.leehana.view.ManageView;

import javax.swing.*;
import java.awt.*;

/**
 * @author Hana Lee
 * @since 2015-11-14 00-31
 */
public class LightningPanel extends JPanel implements Runnable {

	private final Image lightImage = ResourceUtils.getImage("starDdong.png");
	private int sx = 77;
	private int sy = 0;

	public LightningPanel() {
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(lightImage, sx, sy, this);
	}

	@Override
	public void run() {
		int turnFlag = 1;

		// turnFlag 가 아래의 숫자값일때 광원이 이동
		do {
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			switch (turnFlag) {
				case 1:
					// 1이면 위에서 아래로
					sy += 2;
					if (sy > 791) turnFlag = 2;
					break;
				case 2:
					// 2이면 왼쪽에서 오른쪽
					sx += 2;
					if (sx > 1507) turnFlag = 3;
					break;
				case 3:
					// 3이면 아래에서 위로
					sy -= 2;
					if (sy < 53) turnFlag = 4;
					break;
				case 4:
					// 4이면 오른쪽에서 왼쪽으로 이동
					sx -= 2;
					if (sx < 77) turnFlag = 1;
					break;
			}
			repaint();
		} while (true);
	}
}
