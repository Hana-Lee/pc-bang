package kr.co.leehana.view;

import kr.co.leehana.Utils.ResourceUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author Hana Lee
 * @since 2015-11-13 15-12
 */
public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 5698722518547635432L;

	private final Image loginMainImg = ResourceUtils.getImage("login.png");
	private static final int width = 1600;
	private static final int height = 900;

	public static void main(String[] args) {
		new LoginFrame();
	}

	public LoginFrame() {
		init();
	}

	private void init() {
		setTitle("로그인 테스트");
		setSize(width, height);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		setLayout(null); // null 은 절대값 레이아웃

		MainPanel mainPanel = new MainPanel();
		mainPanel.setBounds(0, 0, width, height);

		JLayeredPane mainLayeredPane = new JLayeredPane();
		mainLayeredPane.setBounds(0, 0, width, height);
		mainLayeredPane.setLayout(null);

		final JTextField userIdField = new JTextField(45);
		userIdField.setBounds(731, 399, 280, 30);
		userIdField.setOpaque(false);
		userIdField.setForeground(Color.GREEN);
		userIdField.setBorder(BorderFactory.createEmptyBorder());
		mainLayeredPane.add(userIdField);

		final JPasswordField passwordField = new JPasswordField(45);
		passwordField.setBounds(731, 529, 280, 30);
		passwordField.setOpaque(false);
		passwordField.setForeground(Color.GREEN);
		passwordField.setBorder(BorderFactory.createEmptyBorder());
		mainLayeredPane.add(passwordField);

		final JButton loginBtn = new JButton(new ImageIcon(ResourceUtils.getImage("btLogin_hud.png")));
		loginBtn.setBounds(755, 689, 104, 48);

		loginBtn.setBorderPainted(false);
		loginBtn.setFocusPainted(false);
		loginBtn.setContentAreaFilled(false);
		loginBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

		mainLayeredPane.add(loginBtn, new Integer(1));
		mainLayeredPane.add(mainPanel, new Integer(0));

		add(mainLayeredPane);

		setVisible(true);
	}

	class MainPanel extends JPanel {

		@Override
		public void paint(Graphics g) {
			g.drawImage(loginMainImg, 0, 0, this);
		}
	}
}
