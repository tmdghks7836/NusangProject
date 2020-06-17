package client_p;

import packetBase_p.EResult;
import packetBase_p.PacketBase;
import server_p.packet_p.ack_p.ScLoginAck;
import server_p.packet_p.ack_p.ScSignInUpAck;

//Ŭ���̾�Ʈ�� ó���� ��Ŷ �޼ҵ� 

public interface Receivable {

	void receive(PacketBase packet);
}

class ReceiveLoginAck implements Receivable {
	@Override
	public void receive(PacketBase packet) {

		ScLoginAck ack = (ScLoginAck) packet;
		if (ack.eResult == EResult.SUCCESS) {
			
		}
	}
}

class ReceiveSignUpAck implements Receivable {
	@Override
	public void receive(PacketBase packet) {

		ScSignInUpAck ack = (ScSignInUpAck) packet;
		
		System.out.println(ack.eResult);
		System.out.println("ȸ������ �Ϸ�!");
	}
}
