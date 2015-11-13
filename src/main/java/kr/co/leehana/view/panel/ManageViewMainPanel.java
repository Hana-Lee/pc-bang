package kr.co.leehana.view.panel;

import kr.co.leehana.Utils.ResourceUtils;
import kr.co.leehana.view.ManageView;

import javax.swing.*;
import java.awt.*;

/**
 * @author Hana Lee
 * @since 2015-11-14 00-36
 */
public class ManageViewMainPanel extends JPanel {
	private final Image image = ResourceUtils.getImage("mainHud_back.png");

	public ManageViewMainPanel() {
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
