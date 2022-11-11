package jdbc.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.entity.Member;
import jdbc.util.JDBCTemplate;

public class MemberService {
	private String url;
	private String DBUser;
	private String DBPwd;
	private JDBCTemplate template;
	
	public MemberService(){
		template = new JDBCTemplate();
		url = "jdbc:oracle:thin:@oracle.newlecture.com:1521/xepdb1";
		DBUser = "NEWLEC";
		DBPwd = "rland";
	}

	public List<Member> getList() throws Exception {
		List<Member> list = new ArrayList();
		
		String sql = "SELECT * FROM (SELECT ROWNUM NUM, MEMBER.* FROM MEMBER) WHERE NUM BETWEEN 1 AND 5";
		
		template.print(sql, list);
		
		return list; //List로 반환
	}

	public List<Member> getMember(int getId) throws Exception {
		List<Member> list = new ArrayList();
		String sql = "SELECT * FROM MEMBER WHERE ID = :1";
		
		template.search(sql, list, getId);
		
		return list;
	}

	public List<Member> setMember(int setId, String setPwd, String setNickName) throws Exception {
		List<Member> list = new ArrayList();
		String sql = "INSERT INTO MEMBER(ID,PWD,NICKNAME) VALUES(:1,:2,:3)";
		
		template.add(sql, setId, setPwd, setNickName);
		
		return list;
	}

	public List<Member> changeMember(int id, int setId, String setPwd, String setNickName) {
		List<Member> list = new ArrayList();
		String sql = "UPDATE MEMBER SET ID = :1, PWD = :2, NICKNAME = :3 WHERE ID = :4";
		
		template.update(sql, id, setId, setPwd, setNickName);
		
		return list;
	}

	public List<Member> deleteMember(int id) throws Exception {
		List<Member> list = new ArrayList();
		String sql = "DELETE MEMBER WHERE ID = :1";
		
		template.delete(sql, id);
		
		return list;
	}

}
