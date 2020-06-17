package db_p;

public enum ETable {
	PRODUCT("product"), ACCOUNT("account");

	String name;

	ETable(String name) {
		this.name = name;
	}
}