package client_p;

import packetBase_p.EResult;
import packetBase_p.PacketBase;
import server_p.packet_p.ack_p.ScLoginAck;
import server_p.packet_p.ack_p.ScSignInUpAck;

//Ŭ���̾�Ʈ�� ó���� ��Ŷ �޼ҵ� 

public interface ClientPacketMethod {

	void action(PacketBase packet);
}

class MethLoginAck implements ClientPacketMethod {
	@Override
	public void action(PacketBase packet) {

		ScLoginAck ack = (ScLoginAck) packet;
		if (ack.eResult == EResult.SUCCESS) {
		}
	}
}

class MethSignUpAck implements ClientPacketMethod {
	@Override
	public void action(PacketBase packet) {

		ScSignInUpAck ack = (ScSignInUpAck) packet;
		
		System.out.println(ack.eResult);
		System.out.println("ȸ������ �Ϸ�!");
	}
}
