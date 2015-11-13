package kr.co.leehana.view.panel;

import kr.co.leehana.Utils.ResourceUtils;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

/**
 * @author Hana Lee
 * @since 2015-11-14 00-34
 */
public class ClockBorderPanel extends JPanel implements Runnable, ConstraintPanel {

	private static final long serialVersionUID = 2666786218386642548L;

	private final Image clockBorderImage1 = ResourceUtils.getImage("cl1.png");
	private final Image clockBorderImage2 = ResourceUtils.getImage("cl2.png");
	private final Image clockBorderImage3 = ResourceUtils.getImage("cl3.png");

	private Image[] images = {clockBorderImage1, clockBorderImage2, clockBorderImage3};
	private int imageIndex = 0;

	@Getter
	private Object constrains;

	public ClockBorderPanel(Object constrains) {
		this.constrains = constrains;
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(images[imageIndex], 0, 0, this);
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
				if (imageIndex == 2) {
					imageIndex = 0;
				} else {
					imageIndex++;
				}
				repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
