package client_p;

import packetBase_p.EResult;
import packetBase_p.PacketBase;
import server_p.packet_p.ack_p.ScLoginAck;
import server_p.packet_p.ack_p.ScSignInUpAck;

//클라이언트가 처리할 패킷 메소드 

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
		System.out.println("회원가입 완료!");
	}
}
