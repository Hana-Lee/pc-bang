package kr.co.leehana.chat.client;

import kr.co.leehana.chat.server.ServerGui;

import javax.swing.*;
import java.awt.*;

/**
 * @author Hana Lee
 * @since 2015-11-13 16-01
 */
public class ClientGui extends JFrame {

	public ClientGui() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(800, 100, 400, 600);
		setTitle("클라이언트 부분");

		final JTextArea msgArea = new JTextArea(40, 25);
		final JTextField msgField = new JTextField(25);

		msgField.addActionListener((e) -> {
			String msg = msgField.getText() + "\n";
			msgArea.append(msg);
			msgField.setText("");
		});

		add(msgArea, BorderLayout.CENTER);
		add(msgField, BorderLayout.SOUTH);

		setVisible(true);
	}

	public static void main(String[] args) {
		new ClientGui();
	}
}
