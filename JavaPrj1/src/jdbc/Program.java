package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Program {

	public static void main(String[] args) throws Exception {
//		String url = "jdbc:oracle:thin:@oracle.newlecture.com:1521:orcl"; //SID
		String sql = "SELECT * FROM MEMBER WHERE NICKNAME = '김명진'";
		String url = "jdbc:oracle:thin:@oracle.newlecture.com:1521/xepdb1"; //서비스 이름
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); //DB DRIVER
		Connection con = DriverManager.getConnection(url, "NEWLEC", "rland"); //JDBC DRIVER
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		//FETCH->.next()
		while(rs.next()) {
			int id = rs.getInt("ID");
			String nickName = rs.getString("NICKNAME"); //DB 결과 집합의 column 이름
			String pwd = rs.getString("PWD");
						
			System.out.printf("ID : %5d \tPWD : %10s \tNICNAME : %s\n", id, pwd, nickName);
			
		}
		
		rs.close();
		st.close();
		con.close();
	}

}
