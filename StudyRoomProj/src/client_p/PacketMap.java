package client_p;

import java.util.HashMap;

import packet_p.model.PacketBase;
import packet_p.model.ack_p.*;

public class PacketMap {

	HashMap<Class, ClientPacketMethod> map = new HashMap<Class, ClientPacketMethod>();

	PacketMap() {

		map.put(ScLoginAck.class, new MethLoginAck());
		map.put(ScSignInUpAck.class, new MethSignUpAck());
	}

	void receivePacket(PacketProccess pClient, PacketBase packet) {

		System.out.println("CLIENT RECEIVE : " + packet.getClass());
		map.get(packet.getClass()).action(packet);
	}
}
