package server_p;

import java.util.HashMap;

import packet_p.*;
import packet_p.model.syn_p.*;

public class PacketMap {

	HashMap<Class, ServerPacketMethod> map = new HashMap<Class, ServerPacketMethod>();

	PacketClient client;

	PacketMap() {
		map.put(CsLoginSyn.class, new MethLoginSyn());
		map.put(CsSignUpSyn.class, new MethSignUpSyn());
	}

	void receivePacket(PacketClient pClient, PacketBase packet) {

		System.out.println("SERVER RECEIVE :" + packet.getClass());
		map.get(packet.getClass()).action(pClient, packet);
	}

}
