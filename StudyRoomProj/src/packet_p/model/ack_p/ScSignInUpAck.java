package packet_p.model.ack_p;

import java.util.UUID;

import packet_p.EResult;
import packet_p.SPacketBase;

public class ScSignInUpAck extends SPacketBase {

	public ScSignInUpAck(UUID clientUUID, EResult eResult) {
		super(clientUUID, eResult);
	}

	
	
}
