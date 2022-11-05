package jdbc;

import java.sql.*;
import java.util.*;

public class App {
	public static void main(String[] args) throws Exception {
		
		EXIT:
		while(true) {	
			
			switch(inputMenu()) {
			case 1: //회원 관리
				listMember();
				break;
			case 2: //게시글 관리
				break;
			case 3:
				System.out.println("종료");
				break EXIT;
			}			
		}
	}

	private static void listMember() throws Exception {
		EXIT:
		while(true) {
			//목록 출력
			
			//서브 메뉴
			switch(inputMemberMenu()) {  
			case 0:
				serachMember();
				break;
			case 1:
				addMember();
				break;
				
			case 2:
				updateMember();
				break;
				
			case 3:
				removeMember();
				break;
				
			case 4:
				break EXIT;
				
				
			}
			
		}
		
	}

	private static void serachMember() throws Exception {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("┌─────────────────────┐");
		System.out.println("│       회원 검색        │");
		System.out.println("└─────────────────────┘");
		System.out.println("검색 ID : ");
		int id = scan.nextInt();
		
		//목록 출력
		String sql = "SELECT * FROM MEMBER WHERE ID = :1";
		
		String url = "jdbc:oracle:thin:@oracle.newlecture.com:1521/xepdb1"; //서비스 이름
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); //DB DRIVER
		Connection con = DriverManager.getConnection(url, "NEWLEC", "rland"); //JDBC DRIVER
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);
		
		ResultSet rs = st.executeQuery();
		
		
		System.out.println("\tID \tPWD \tNICKNAME");
		while(rs.next()) {
			int gid = rs.getInt("ID");
			String nickName = rs.getString("NICKNAME"); //DB 결과 집합의 column 이름
			String pwd = rs.getString("PWD");
			
			System.out.printf("%10d %10s %10s\n", id, pwd, nickName);
			
		}
		
		rs.close();
		st.close();
		con.close();
		
	}

	private static void removeMember() throws Exception {
		Scanner scan = new Scanner(System.in);

		System.out.println("┌─────────────────────┐");
		System.out.println("│       회원 삭제        │");
		System.out.println("└─────────────────────┘");
		
		System.out.print("아이디 : ");
		int id = scan.nextInt();
		
		//sql 입력
		String sql = "DELETE MEMBER WHERE ID = :1";
		

		String url = "jdbc:oracle:thin:@oracle.newlecture.com:1521/xepdb1"; //서비스 이름
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); //DB DRIVER
		Connection con = DriverManager.getConnection(url, "NEWLEC", "rland"); //JDBC DRIVER
		PreparedStatement st = con.prepareStatement(sql);
		
		//sql 만들기
		st.setInt(1, id);
		
		//sql 실행
		st.executeUpdate();
		
		
		st.close();
		con.close();
		
		System.out.println("회원 삭제 완료");
		
	}

	private static void updateMember() throws Exception {
		Scanner scan = new Scanner(System.in);

		System.out.println("┌─────────────────────┐");
		System.out.println("│       회원 수정        │");
		System.out.println("└─────────────────────┘");
		
		System.out.print("수정할 ID : ");
		int id = scan.nextInt();
		System.out.print("아이디 : ");
		int setId = scan.nextInt();
		System.out.print("패스워드 : ");
		String pwd = scan.next();
		System.out.print("닉네임 : ");
		String nickName = scan.next();
		
		//sql 입력
		String sql = "UPDATE MEMBER SET ID = :1, PWD = :2, NICKNAME = :3 WHERE ID = :4";
		

		String url = "jdbc:oracle:thin:@oracle.newlecture.com:1521/xepdb1";
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, "NEWLEC", "rland"); 
		PreparedStatement st = con.prepareStatement(sql);
		
		//sql 만들기
		st.setInt(1, setId);
		st.setString(2, pwd);
		st.setString(3, nickName);
		st.setInt(4, id);
		
		//sql 실행
		st.executeUpdate();
		
		st.close();
		con.close();
		
		System.out.println("회원 수정 완료");
		
	}

	private static void addMember() throws Exception {
		Scanner scan = new Scanner(System.in);
		String finish;
		int id;
		do {	
			System.out.println("┌─────────────────────┐");
			System.out.println("│       회원 추가        │");
			System.out.println("└─────────────────────┘");
			
			do {
				System.out.print("아이디 : ");
				id = scan.nextInt();
			}while(checkId(id));
			
			System.out.print("패스워드 : ");
			String pwd = scan.next();
			System.out.print("닉네임 : ");
			String nickName = scan.next();
			
			
			
			//sql 입력
			String sql = "INSERT INTO MEMBER(ID,PWD,NICKNAME) VALUES(:1,:2,:3)";
			
			
			String url = "jdbc:oracle:thin:@oracle.newlecture.com:1521/xepdb1"; //서비스 이름
			
			Class.forName("oracle.jdbc.driver.OracleDriver"); //DB DRIVER
			Connection con = DriverManager.getConnection(url, "NEWLEC", "rland"); //JDBC DRIVER
			PreparedStatement st = con.prepareStatement(sql);
			//sql 만들기
			st.setInt(1, id);
			st.setString(2, pwd);
			st.setString(3, nickName);
			
			//sql 실행
			st.executeUpdate();
			
			
			st.close();
			con.close();
			
			System.out.println("회원 추가 완료");
			System.out.println("계속 하시겠습니까? ( Y | N )");
			finish = scan.next();
			if(finish.equals("N"))
				break;
		}while(true);
		
	}

	private static boolean checkId(int id) throws Exception {
		String sql = "SELECT * FROM MEMBER WHERE ID = "+id;
		
		String url = "jdbc:oracle:thin:@oracle.newlecture.com:1521/xepdb1"; //서비스 이름
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); //DB DRIVER
		Connection con = DriverManager.getConnection(url, "NEWLEC", "rland"); //JDBC DRIVER
		Statement st = con.createStatement();		
		ResultSet rs = st.executeQuery(sql);
		
		boolean result = rs.next();
		rs.close();
		st.close();
		con.close();
		
		return result;
		
	}

	private static int inputMemberMenu() throws Exception {
		Scanner scan = new Scanner(System.in);

		int menu;
		int page = 1;
		do {
			System.out.println("┌─────────────────────┐");
			System.out.println("│       회원 관리        │");
			System.out.println("└─────────────────────┘");
			
			//목록 출력
			String sql = "SELECT * FROM (SELECT ROWNUM NUM, MEMBER.* FROM MEMBER) WHERE NUM BETWEEN "+page+" AND "+(page+4);
			
			String url = "jdbc:oracle:thin:@oracle.newlecture.com:1521/xepdb1"; //서비스 이름
			
			Class.forName("oracle.jdbc.driver.OracleDriver"); //DB DRIVER
			Connection con = DriverManager.getConnection(url, "NEWLEC", "rland"); //JDBC DRIVER
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			System.out.println("\tID \tPWD \tNICKNAME");
			while(rs.next()) {
				int id = rs.getInt("ID");
				String nickName = rs.getString("NICKNAME"); //DB 결과 집합의 column 이름
				String pwd = rs.getString("PWD");
				
				System.out.printf("%10d %10s %10s\n", id, pwd, nickName);
				
			}
			
			rs.close();
			st.close();
			con.close();
			
			System.out.println("(0.검색 1.추가 2.수정 3.삭제 4.상위메뉴 5.이전 6.다음)");
			System.out.print("> ");
			menu = scan.nextInt();
			if(menu < 5)
				break;
			else if(menu == 5)
				page -= 5;
			else if(menu == 6)
				page += 5;
		} while(true);
		return menu;
		
	}

	private static int inputMenu() {
		Scanner scan = new Scanner(System.in);

		System.out.println("┌─────────────────────┐");
		System.out.println("│        메인 메뉴       │");
		System.out.println("└─────────────────────┘");
		System.out.println("1. 회원 관리");
		System.out.println("2. 게시판 관리");
		System.out.println("3. 종료");
		System.out.print("> ");
		int menu = scan.nextInt();		
		return menu;
	}
	
	
}
