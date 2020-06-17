package db_p;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBProccess {

	private static DBProccess instance;

	public static DBProccess getInstance() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (instance == null) {
			instance = new DBProccess();
		}
		return instance;
	}

	Connection con;
	Statement stmt;

	DBProccess() {

	}

	public ResultSet findData(ETable table, String data) {

		try {
			reset();
			ResultSet rs = stmt.executeQuery("select " + data + " from " + table.name);
			close();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("findTableData is null");
		return null;
	}

	public void insertData(ETable table, String key, String values) {
		try {
			reset();
			String data = "insert into " + table.name + "(" + key + ") values " + "(" + values + ")";
			System.out.println(data);
			ResultSet rs = stmt.executeQuery(data);
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	public static String keyStr(String... keyArr) {
//		String keyStr = "";
//		for (String string : keyArr) {
//			keyStr += string + ",";
//		}
//
//		return keyStr;
//	}

	public static String valueStr(Object... valueArr) {
		String valueStr = "";

		for (int i = 0; i < valueArr.length; i++) {

			//if (Integer.parseInt(valueArr[i])) {
				valueStr += "'" + valueArr[i].toString() + "'";
			//} else {
			//	valueStr += valueArr[i].toString();
			//}
			
			if (i < valueArr.length - 1) {
				valueStr += ",";
			}
		}
		return valueStr;
	}

	void reset() throws SQLException {
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		stmt = con.createStatement();
	}

	void close() throws SQLException {
		stmt.close();
		con.close();
	}

}

//// 쿠리 실행 데이터
//while (rs.next()) {
//	System.out.print(rs.getString("id"));
//	System.out.print(rs.getString("name"));
//	System.out.print(rs.getString("kor"));
//	System.out.print(rs.getString("eng"));
//	System.out.print(rs.getString("mat"));
//	System.out.println();
//	Timestamp time = rs.getTimestamp("reg");
//	Stud st = new Stud(rs.getString("name"), rs.getString("id"), rs.getInt("kor"));
//}
