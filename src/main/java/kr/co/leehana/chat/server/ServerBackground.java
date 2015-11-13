package kr.co.leehana.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Hana Lee
 * @since 2015-11-13 15-52
 */
public class ServerBackground {

	private ServerSocket serverSocket;
	private Socket socket;
	private ServerGui serverGui;
	private String clientMsg;
	private Map<String, DataOutputStream> clientsMap = new HashMap<>();

	public ServerBackground(ServerGui serverGui) {
		this.serverGui = serverGui;
	}

	public void setting() {
		try {
			Collections.synchronizedMap(clientsMap);
			serverSocket = new ServerSocket(7777);

			while (true) {
				System.out.println("서버 대기중...");
				socket = serverSocket.accept();
				System.out.println(socket.getInetAddress() + " 에서 접속 하였습니다.");

				Receiver receiver = new Receiver(socket);
				receiver.start();
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
		for (String nickName : clientsMap.keySet()) {
			try {
				clientsMap.get(nickName).writeUTF(nickName + " : " + msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	class Receiver extends Thread {

		private DataInputStream dataInputStream;
		private DataOutputStream dataOutputStream;
		private String nickName;

		public Receiver(Socket socket) {
			try {
				dataOutputStream = new DataOutputStream(socket.getOutputStream());
				dataInputStream = new DataInputStream(socket.getInputStream());

				nickName = dataInputStream.readUTF();
				addClient(nickName, dataOutputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {

			while (dataInputStream != null) {
				try {
					clientMsg = dataInputStream.readUTF();
					sendMessage(clientMsg);
					serverGui.appendMessage(clientMsg);
				} catch (IOException e) {
					e.printStackTrace();
					removeClient(nickName);
				}
			}
		}
	}

	private void addClient(String nickName, DataOutputStream dataOutputStream) {
		clientsMap.put(nickName, dataOutputStream);
	}

	private void removeClient(String nickName) {
		clientsMap.remove(nickName);
	}
}
