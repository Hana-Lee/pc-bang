package kr.co.leehana.view.panel;

import javax.swing.*;

/**
 * @author Hana Lee
 * @since 2015-11-16 19:48
 */
public class SeatRootPanel extends JPanel implements ConstraintPanel {

	private static final long serialVersionUID = 4272624341890565579L;

	private int constrains;

	public SeatRootPanel() {
	}

	public SeatRootPanel(int constrains) {
		this.constrains = constrains;
	}

	@Override
	public Object getConstrains() {
		return constrains;
	}
}
