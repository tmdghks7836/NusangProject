package packet_p.model.ack_p;

import java.util.UUID;

import packet_p.EResult;
import packet_p.SPacketBase;

public class ScLoginAck extends SPacketBase {

	String name;
	
	public ScLoginAck(UUID clientUUID, EResult eResult) {
		super(clientUUID, eResult);
	}

}
