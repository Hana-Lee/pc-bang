package kr.co.leehana.view;

import kr.co.leehana.controller.PCServerBackground;

import javax.swing.*;
import java.awt.*;

/**
 * @author Hana Lee
 * @since 2015-11-13 19-59
 */
public class MainFrameViewTest extends JFrame {

	private static final long serialVersionUID = -260113814008161018L;

	private JPanel[] panel = new JPanel[2];

	public MainFrameViewTest() {
		setLayout(new GridLayout(1, 2));

		panel[0] = new JPanel();
		panel[1] = new JPanel();

		panel[0].setBackground(Color.BLACK);
		panel[1].setBackground(Color.RED);

		add(panel[0], BorderLayout.EAST);
		add(panel[1], BorderLayout.WEST);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(200, 200, 1600, 900);
		setVisible(true);
	}

	public static void main(String[] args) {
		MainFrameViewTest mainFrameViewTest = new MainFrameViewTest();
		PCServerBackground pcServerBackground = new PCServerBackground(mainFrameViewTest);
		pcServerBackground.setting();
	}

	public void connectClient() {
		panel[1].setBackground(Color.BLUE);
	}
}
