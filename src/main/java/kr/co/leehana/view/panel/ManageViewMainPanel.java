package kr.co.leehana.view.panel;

import kr.co.leehana.Utils.ResourceUtils;
import kr.co.leehana.view.ManageView;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

/**
 * @author Hana Lee
 * @since 2015-11-14 00-36
 */
public class ManageViewMainPanel extends JPanel implements ConstraintPanel {

	private static final long serialVersionUID = -1986740914182244609L;

	private final Image image = ResourceUtils.getImage("mainHud_back.png");

	@Getter
	private Object constrains;

	public ManageViewMainPanel(Object constrains) {
		this.constrains = constrains;
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
