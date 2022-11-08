package jdbc;

import java.sql.*;
import java.util.*;

import jdbc.entity.Member;
import jdbc.service.MemberService;

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
		
		MemberService service = new MemberService();
		List<Member> list = service.getMember(id);		
		
		System.out.println("\tID \tPWD \tNICKNAME");
		for(Member member : list) 
			System.out.printf("%10d %10s %10s\n", member.getId(), member.getPwd(), member.getNickName());
		

		System.out.println("회원 검색 완료");
	}

	private static void removeMember() throws Exception {
		Scanner scan = new Scanner(System.in);

		System.out.println("┌─────────────────────┐");
		System.out.println("│       회원 삭제        │");
		System.out.println("└─────────────────────┘");
		
		System.out.print("아이디 : ");
		int id = scan.nextInt();
		
		MemberService service = new MemberService();
		List<Member> list = service.deleteMember(id);
		
		System.out.println("회원 삭제 완료");
		
	}

	private static void updateMember() throws Exception {
		Scanner scan = new Scanner(System.in);
		int setId;

		System.out.println("┌─────────────────────┐");
		System.out.println("│       회원 수정        │");
		System.out.println("└─────────────────────┘");
		
		System.out.print("수정할 ID : ");
		int id = scan.nextInt();
		System.out.print("패스워드 : ");
		String pwd = scan.next();
		if(checkPwd(id, pwd)) {
			do {
				System.out.print("변경할 ID : ");
				setId = scan.nextInt();
				if(checkId(setId))
					System.out.println("아이디가 중복됩니다!");
			}while(checkId(setId));
			System.out.print("패스워드 : ");
			String setPwd = scan.next();
			System.out.print("닉네임 : ");
			String nickName = scan.next();
			
			MemberService service = new MemberService();
			List<Member> list = service.chageMember(id, setId, setPwd ,nickName);
			
			System.out.println("회원 수정 완료");	
		}
		else {
			System.out.println("패스워드가 잘못되었습니다.");
		}
	}

	private static boolean checkPwd(int id, String pwd) throws Exception {
		boolean result = false;
		
		MemberService service = new MemberService();
		List<Member> list = service.getMember(id);
		
		for(Member member : list) {
			if(member.getPwd().equals(pwd))
				result = true;
			else
				result = false;
		}
			
		return result;
		
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
				if(checkId(id))
					System.out.println("아이디가 중복됩니다!");
			}while(checkId(id));
			
			System.out.print("패스워드 : ");
			String pwd = scan.next();
			System.out.print("닉네임 : ");
			String nickName = scan.next();
			
			MemberService service = new MemberService();
			List<Member> list = service.setMember(id, pwd, nickName);
			
			System.out.println("회원 추가 완료");
			System.out.println("계속 하시겠습니까? ( Y | N )");
			finish = scan.next();
			if(finish.equals("N"))
				break;
		}while(true);
		
	}

	private static boolean checkId(int id) throws Exception {
		boolean result = false;
		
		MemberService service = new MemberService();
		List<Member> list = service.getMember(id);
		
		for(Member member : list) {
			if(member.getId() == id)
				result = true;
			else
				result = false;
		}
			
		return result;
		
	}

	private static int inputMemberMenu() throws Exception {
		Scanner scan = new Scanner(System.in);

		System.out.println("┌─────────────────────┐");
		System.out.println("│       회원 관리        │");
		System.out.println("└─────────────────────┘");
		
		MemberService service = new MemberService();
		List<Member> list = service.getList();
		
		System.out.println("\tID \tPWD \tNICKNAME");
		for(Member member : list) 
			System.out.printf("%10d %10s %10s\n", member.getId(), member.getPwd(), member.getNickName());
		
		
		System.out.println("(0.검색 1.추가 2.수정 3.삭제 4.상위메뉴)");
		System.out.print("> ");
		int menu = scan.nextInt();
			
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
