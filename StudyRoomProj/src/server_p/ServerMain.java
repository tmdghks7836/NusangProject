package server_p;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;
import packet_p.model.*;

public class ServerMain {

	public static void main(String[] args) {
		MyServer.getInstance().startThread();
	}
}

class MyServer {

	// myserver �� �̱���
	private static MyServer instance;

	public static MyServer getInstance() {

		if (instance == null) {
			instance = new MyServer();
		}
		return instance;
	}

	// Ŭ���̾�Ʈ ����Ʈ

	ArrayList<PacketClient> clientList = new ArrayList<PacketClient>();

	// Ŭ���̾�Ʈ ����Ʈ ������ ��Ŷ �޾Ƽ� ó���ϴ� Ŭ����
	// Ŭ���̾�Ʈ ���� ���� �޴� Ŭ����
	SocketListener listener = new SocketListener();

	void startThread() {
		listener.start();
		Collections.synchronizedList(clientList);
	}

	class SocketListener extends Thread {
		ServerSocket server = null;

		@Override
		public void run() {
			try {
				server = new ServerSocket(7777);

				while (true) {

					System.out.println("Ŭ���̾�Ʈ ���� ���");

					Socket client = server.accept(); // Ŭ���̾�Ʈ ����

					System.out.println(client.getInetAddress() + "����");

					PacketClient pClient = new PacketClient(client, UUID.randomUUID());

					pClient.start();
					clientList.add(pClient);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

class PacketClient extends Thread {

	UUID uuid;
	PacketMap pMap = new PacketMap();
	InputStream is;
	ObjectInputStream dis;
	OutputStream os;
	ObjectOutputStream dos;
	Socket socket;

	PacketClient(Socket socket, UUID uuid) {

		this.uuid = uuid;
		this.socket = socket;
		try {
			is = socket.getInputStream();
			dis = new ObjectInputStream(is);
			os = socket.getOutputStream();
			dos = new ObjectOutputStream(os);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Ŭ���̾�Ʈ ����Ʈ ������ �Լ� ����
	public void run() {

		while (true) {

			try {
				sleep(1000);
				//System.out.println(is.available());
				if (is.available() > 0) {
					System.out.println("������ ����");
					pMap.receivePacket(this, (PacketBase) dis.readObject());
				}
			} catch (Exception e) {
				System.out.println("�������� ��Ŷ �޴� ���� ���� " + e);
			} finally {
			}
		}
	}

	void sendPacket(PacketBase packet) {
		try {
//			System.out.println(socket.isConnected());
//			System.out.println(socket.isClosed());
			System.out.println("SERVER SEND: " + packet.getClass());
			dos.writeObject(packet);
			dos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}
}
