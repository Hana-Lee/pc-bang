package kr.co.leehana.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Hana Lee
 * @since 2015-11-13 15-52
 */
public class ServerBackground {
	private ServerSocket serverSocket;
	private Socket socket;
	private DataInputStream dataInputStream;
	private DataOutputStream dataOutputStream;
	private ServerGui serverGui;
	private String clientMsg;

	public ServerBackground(ServerGui serverGui) {
		this.serverGui = serverGui;
	}

	public void setting() {
		try {
			serverSocket = new ServerSocket(7777);

			System.out.println("서버 대기중...");
			socket = serverSocket.accept();
			System.out.println(socket.getInetAddress() + " 에서 접속 하였습니다.");

			dataOutputStream = new DataOutputStream(socket.getOutputStream());
			dataInputStream = new DataInputStream(socket.getInputStream());

			while (dataInputStream != null) {
				clientMsg = dataInputStream.readUTF();
				serverGui.appendMessage(clientMsg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ServerBackground serverBackground = new ServerBackground(null);
		serverBackground.setting();
	}

	public void sendMessage(String msg) {
		try {
			dataOutputStream.writeUTF(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
