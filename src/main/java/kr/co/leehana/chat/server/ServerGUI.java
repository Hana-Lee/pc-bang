package kr.co.leehana.chat.server;

import javax.swing.*;
import java.awt.*;

/**
 * @author Hana Lee
 * @since 2015-11-13 16-01
 */
public class ServerGui extends JFrame {

	private static final long serialVersionUID = 477016551457497985L;

	public ServerGui() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(400, 100, 400, 600);
		setTitle("서버 부분");

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
		new ServerGui();
	}
}
