package packet_p.model.ack_p;

import java.util.UUID;

import packet_p.model.EResult;
import packet_p.model.SPacketBase;

public class ScSignInUpAck extends SPacketBase {

	public ScSignInUpAck(UUID clientUUID, EResult eResult) {
		super(clientUUID, eResult);
	}

	
	
}
