package packet_p.model.syn_p;

import packet_p.PacketBase;

public class CsLoginSyn extends PacketBase {

	public String id;
	public String pw;
	public boolean isID;

	public CsLoginSyn(String id, String pw, boolean isID) {
		this.id = id;
		this.pw = pw;
		this.isID = isID;
	}

}
