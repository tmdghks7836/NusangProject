package client_p;

import packet_p.model.EResult;
import packet_p.model.PacketBase;
import packet_p.model.Server_p.ack_p.ScLoginAck;
import packet_p.model.Server_p.ack_p.ScSignInUpAck;

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

class MethSignUpSyn implements ClientPacketMethod {
	@Override
	public void action(PacketBase packet) {

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
