package packet_p.model.syn_p;

import packet_p.model.PacketBase;

public class CsSignUpSyn extends PacketBase {

	public String name;
	public String id;
	public String pw;
	public String phone;
	public String birth;

	public CsSignUpSyn(String name, String id, String pw, String phone, String birth) {
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.phone = phone;
		this.birth = birth;
	}

}
