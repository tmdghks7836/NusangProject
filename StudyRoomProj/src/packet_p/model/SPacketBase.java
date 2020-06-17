package packet_p.model;

import java.util.UUID;

public class SPacketBase extends PacketBase {

	public EResult eResult;

	public SPacketBase(UUID clientUUID, EResult eResult) {
		super();
		this.clientUUID = clientUUID;
		this.eResult = eResult;
		
	}
}