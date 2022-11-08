package jdbc.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import jdbc.entity.Member;

public class MemberService {
	private Member member;
	private List<Member> list;
	private String url;
	private String DBUser;
	private String DBPwd;
	
	public MemberService(){
		list = new ArrayList();
		url = "jdbc:oracle:thin:@oracle.newlecture.com:1521/xepdb1";
		DBUser = "NEWLEC";
		DBPwd = "rland";
	}

	public List<Member> getList() throws Exception {
		String sql = "SELECT * FROM (SELECT ROWNUM NUM, MEMBER.* FROM MEMBER) WHERE NUM BETWEEN 1 AND 5";
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, DBUser, DBPwd); 
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			int id = rs.getInt("ID");
			String pwd = rs.getString("PWD");
			String nickName = rs.getString("NICKNAME"); //DB 결과 집합의 column 이름
			member = new Member(id, pwd, nickName);
			list.add(member);
			
		}
		
		rs.close();
		st.close();
		con.close();
		
		return list; //List로 반환
	}

	public List<Member> getMember(int getId) throws Exception {
		String sql = "SELECT * FROM MEMBER WHERE ID = :1";
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, DBUser, DBPwd); 
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, getId);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("ID");
			String pwd = rs.getString("PWD");
			String nickName = rs.getString("NICKNAME"); //DB 결과 집합의 column 이름
			member = new Member(id, pwd, nickName);
			list.add(member);
			
		}
		
		rs.close();
		st.close();
		con.close();
		
		return list;
	}

	public List<Member> setMember(int setId, String setPwd, String setNickName) throws Exception {
		String sql = "INSERT INTO MEMBER(ID,PWD,NICKNAME) VALUES(:1,:2,:3)";
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, DBUser, DBPwd); 
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, setId);
		st.setString(2, setPwd);
		st.setString(3, setNickName);
		ResultSet rs = st.executeQuery();
		
		rs.close();
		st.close();
		con.close();
		
		return list;
	}

	public List<Member> chageMember(int id, int setId, String setPwd, String setNickName) throws Exception {
		String sql = "UPDATE MEMBER SET ID = :1, PWD = :2, NICKNAME = :3 WHERE ID = :4";
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, DBUser, DBPwd); 
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, setId);
		st.setString(2, setPwd);
		st.setString(3, setNickName);
		st.setInt(4, id);
		ResultSet rs = st.executeQuery();
		
		rs.close();
		st.close();
		con.close();
		
		return list;
	}

	public List<Member> deleteMember(int id) throws Exception {
		String sql = "DELETE MEMBER WHERE ID = :1";
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, DBUser, DBPwd); 
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		
		rs.close();
		st.close();
		con.close();
		
		return list;
	}

}
