package kr.co.leehana.chat.client;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

/**
 * @author Hana Lee
 * @since 2015-11-13 16-01
 */
public class ClientGui extends JFrame {

	private static final long serialVersionUID = -2274895343413023374L;

	private ClientBackground clientBackground = new ClientBackground(this);
	private JTextArea msgArea;
	private static String nickName;

	public ClientGui() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(800, 100, 400, 600);
		setTitle("클라이언트 부분");

		msgArea = new JTextArea(40, 25);
		final JTextField msgField = new JTextField(25);

		msgField.addActionListener((e) -> {
			String msg = msgField.getText() + "\n";
			msgArea.append(nickName + " : " + msg);
			msgField.setText("");

			clientBackground.sendMessage(msg);
		});

		add(msgArea, BorderLayout.CENTER);
		add(msgField, BorderLayout.SOUTH);

		setVisible(true);

		clientBackground.setNickName(nickName);
		clientBackground.connect();
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("닉네임 : ");
		nickName = s.nextLine();
		s.close();

		new ClientGui();
	}

	public void appendMessage(String serverMsg) {
		msgArea.append("서버 : " + serverMsg);
	}
}
