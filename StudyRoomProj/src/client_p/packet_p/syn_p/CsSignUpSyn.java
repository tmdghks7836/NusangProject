package client_p.packet_p.syn_p;

import packetBase_p.PacketBase;

public class CsSignUpSyn extends PacketBase {

	public String name; // �̸�
	public String id; // ���̵�
	public String pw; // ���
	public String phone; // ��
	public String birth; // ����
	public String cType; // �α��� Ÿ�� (�Ϲ�,������(�����ͺ��̽��� �ִ� Ű���� ������ ��))

	public CsSignUpSyn(String name, String id, String pw, String phone, String birth, String cType) {
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.phone = phone;
		this.birth = birth;
		this.cType = cType;
	}

}
