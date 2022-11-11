package jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import jdbc.entity.Member;

public class JDBCTemplate {
	private String url;
	private String DBUser;
	private String DBPwd;

	public JDBCTemplate() {
		url = "jdbc:oracle:thin:@oracle.newlecture.com:1521/xepdb1";
		DBUser = "NEWLEC";
		DBPwd = "rland";
	}
	
	public List<Member> query(String sql){
		
		return null;
	}
	
	public void update(String sql, int id, int setId, String setPwd, String setNickName) {
		try(
//				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url, DBUser, "DBPwd"); 
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();
			) {
			st.setInt(1, setId);
			st.setString(2, setPwd);
			st.setString(3, setNickName);
			st.setInt(4, id);
			
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			throw new JDBCTemlateException(e.getMessage());
		} 
	}
	
	/*
	public void update(String sql, int id, int setId, String setPwd, String setNickName) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, DBUser, DBPwd); 
			st = con.prepareStatement(sql);
			st.setInt(1, setId);
			st.setString(2, setPwd);
			st.setString(3, setNickName);
			st.setInt(4, id);
			rs = st.executeQuery();
			
		} catch (ClassNotFoundException e) {
			throw new JDBCTemlateException();
		} catch (Exception e) {
			throw new JDBCTemlateException();
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(st != null)
					st.close();
				if(con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	*/

	public void delete(String sql, int id) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, DBUser, DBPwd); 
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		
		rs.close();
		st.close();
		con.close();
		
	}

	public void add(String sql, int setId, String setPwd, String setNickName) throws Exception {Class.forName("oracle.jdbc.driver.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, DBUser, DBPwd); 
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, setId);
		st.setString(2, setPwd);
		st.setString(3, setNickName);
		ResultSet rs = st.executeQuery();
		
		rs.close();
		st.close();
		con.close();
		
	}

	public void search(String sql, List<Member> list, int getId) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, DBUser, DBPwd); 
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, getId);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("ID");
			String pwd = rs.getString("PWD");
			String nickName = rs.getString("NICKNAME"); //DB 결과 집합의 column 이름
			Member member = new Member(id, pwd, nickName);
			list.add(member);
			
		}
		
		rs.close();
		st.close();
		con.close();
		
	}

	public void print(String sql, List<Member> list) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, DBUser, DBPwd); 
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			int id = rs.getInt("ID");
			String pwd = rs.getString("PWD");
			String nickName = rs.getString("NICKNAME"); //DB 결과 집합의 column 이름
			Member member = new Member(id, pwd, nickName);
			list.add(member);
			
		}
		
		rs.close();
		st.close();
		con.close();
		
	}


}
