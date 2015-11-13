package kr.co.leehana.view;

import kr.co.leehana.Utils.ResourceUtils;
import kr.co.leehana.controller.LoginController;
import kr.co.leehana.controller.MainController;
import kr.co.leehana.service.MemberServiceImpl;

import javax.swing.*;
import java.awt.*;

/**
 * @author Hana Lee
 * @since 2015-11-13 15-12
 */
public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 5698722518547635432L;

	private final Image loginMainImg = ResourceUtils.getImage("login.png");
	private static final int width = 1600;
	private static final int height = 900;
	private MainController mainController;
	private LoginController loginController;

	public static void main(String[] args) {
		new LoginFrame(null, new LoginController(new MemberServiceImpl()));
	}

	public LoginFrame(MainController mainController, LoginController loginController) {
		this.mainController = mainController;
		this.loginController = loginController;
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
		loginBtn.addActionListener((e) -> {
			final String userId = userIdField.getText();
			final char[] password = passwordField.getPassword();

			if (userId.isEmpty() || password.length == 0) {
				JOptionPane.showMessageDialog(this, "아이디 또는 비밀번호를 입력해주세요", "경고", JOptionPane.WARNING_MESSAGE);
			} else {
				boolean loginCheck = false;
				try {
					loginCheck = loginController.loginCheck(userId, new String(password));
				} catch (Exception ex) {
					ex.printStackTrace();
				}

				if (loginCheck) {
					JOptionPane.showMessageDialog(this, "로그인 성공", "정보", JOptionPane.INFORMATION_MESSAGE);
					mainController.showManageView();
				} else {
					JOptionPane.showMessageDialog(this, "로그인 실패", "오류", JOptionPane.ERROR_MESSAGE);
				}
			}

		});

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
