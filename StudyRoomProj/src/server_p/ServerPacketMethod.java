package server_p;

import packet_p.model.EResult;
import packet_p.model.ack_p.*;
import packet_p.model.syn_p.*;
import db_p.DBProccess;
import db_p.*;
import packet_p.model.*;
//서버가 처리할 패킷 메소드 

public interface ServerPacketMethod {

	void action(PacketClient client, PacketBase packet);
}

//class MethLogOutSyn implements PacketMethod {
//
//	@Override
//	public void action(PacketClient client, PacketBase packet) {
//		CsLoginSyn recPacket = (CsLoginSyn) packet;
//
//		System.out.println("rcPacket");
//	}
//}

class MethLoginSyn implements ServerPacketMethod {

	public void action(PacketClient client, PacketBase packet) {
		CsLoginSyn recPacket = (CsLoginSyn) packet;

		// 데이터 베이스 체크
		ScLoginAck ack = null;
		if (true) {
			ack = new ScLoginAck(client.uuid, EResult.SUCCESS);
		} else {
			ack = new ScLoginAck(client.uuid, EResult.NOT_FOUND_DATA);
		}

		System.out.println("CsLoginSyn");
		System.out.println("id" + recPacket.id);
		System.out.println("pw" + recPacket.pw);
		System.out.println("isID" + recPacket.isID);
		client.sendPacket(ack);
		// client.sendPacket(recPacket);

	}
}

class MethSignUpSyn implements ServerPacketMethod {

	public void action(PacketClient client, PacketBase packet) {
		CsSignUpSyn recPacket = (CsSignUpSyn) packet;

		String key = "name,id,pw,birth,phone";
		String values = DBProccess.valueStr(recPacket.name, recPacket.id, recPacket.pw, recPacket.birth,
				recPacket.phone);
		DBProccess.getInstance().insertData(ETable.ACCOUNT, key, values);

		ScSignInUpAck ack = new ScSignInUpAck(client.uuid, EResult.SUCCESS);
		client.sendPacket(ack);

	}
}
