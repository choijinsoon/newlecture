package com.newlecture.homwork;

public class Seat {

	public static void main(String[] args) {
		String teac1,teac2,teac3;
		String g1M1,g1M2,g1M3,g1M4,g1M5,g2M1,g2M2,g2M3,g2M4,g2M5,g2M6,g3M1,g3M2,g3M3,g3M4,g3M5,g4M1,g4M2,g4M3,g4M4,g4M5,g5M1,g5M2,g5M3,g5M4,g5M5;
		String vacant;
		
		
		//(조/번호)=학생이름
		g1M1 = "이진희";
		g1M2 = "김유민";
		g1M3 = "최미지";
		g1M4 = "전재민";
		g1M5 = "김경환";
		g2M1 = "양호정";
		g2M2 = "이상민";
		g2M3 = "은진님";
		g2M4 = "이지현";
		g2M5 = "한상우";
		g2M6 = "박준영";
		g3M1 = "이민혜";
		g3M2 = "최진순";
		g3M3 = "주성균";
		g3M4 = "임형미";
		g3M5 = "임우빈";
		g4M1 = "장동혁";
		g4M2 = "김명진";
		g4M3 = "김정현";
		g4M4 = "권주승";
		g4M5 = "이정우";
		g5M1 = "정대로";
		g5M2 = "김찬우";
		g5M3 = "고은비";
		g5M4 = "한태희";
		g5M5 = "이준현";
		
		//공석
		vacant = "빈자리";
		
		//선생님들 성함
		teac1 = "박용우 ";
		teac2 = "정용우";
		teac3 = "전영현";
		
		//조 편성
		System.out.println("*********조 편성 결과*********");
		System.out.println("(자리 표는 아래 \"4강의실 자리표\" 참고)");
		System.out.println();
		System.out.printf("1조: %s,%s,%s,%s,%s\n",g1M1,g1M2,g1M3,g1M4,g1M5);
		System.out.printf("2조: %s,%s,%s,%s,%s,%s\n",g2M1,g2M2,g2M3,g2M4,g2M5,g2M6);
		System.out.printf("3조: %s,%s,%s,%s,%s\n",g3M1,g3M2,g3M3,g3M4,g3M5);
		System.out.printf("4조: %s,%s,%s,%s,%s\n",g4M1,g4M2,g4M3,g4M4,g4M5);
		System.out.printf("5조: %s,%s,%s,%s,%s\n",g5M1,g5M2,g5M3,g5M4,g5M5);
		System.out.println();
		
		//선생님들 이름
		System.out.printf("※선생님: %s\n",teac1);
		System.out.printf("※멘토1: %s, 멘토2: %s",teac2,teac3);
		System.out.println();
		System.out.println();
		
		//자리배치표
		System.out.print    ("=====================================================================\n");
		System.out.print    ("                            4강의실 자리표                               \n");
		System.out.print    ("=====================================================================\n");
		System.out.println();
		System.out.print    ("┌───────┐ ┌──────────────────────────────────────────────────────────┐\n");
		System.out.print    ("│  Door │ │                       Whiteboard                         │\n");
		System.out.print    ("└───────┘ └──────────────────────────────────────────────────────────┘\n");
		//선생님 자리
		System.out.print    ("                                                            ┌────────┐\n");
		System.out.printf   ("                                                            │  %s │ \n",teac1);
		System.out.print    ("                                                            └────────┘\n");
		//자리
		System.out.println  ("┌─────────────Group1──────────────┬───────────Group4──────────────────┐ ");
		System.out.println  ("│┌────────┐ ┌────────┐ ┌────────┐ │   ┌────────┐ ┌────────┐ ┌────────┐│");
		System.out.printf   ("││  %s  │ │  %s  │ │  %s  │ │   │  %s  │ │  %s  │ │  %s  ││\n",g1M1,g1M2,g1M3,g4M1,g4M2,g4M3);
		System.out.println  ("│└────────┘ └────────┘ └────────┘ │   └────────┘ └────────┘ └────────┘│");
		System.out.println  ("├──────────┐                      │                        ┌──────────┘");
		System.out.println  ("│┌────────┐│┌────────┐ ┌────────┐ │   ┌────────┐ ┌────────┐│┌────────┐");
		System.out.printf   ("││  %s  │││  %s  │ │  %s  │ │   │  %s  │ │  %s  │││  %s  │\n",g2M1,g1M5,g1M4,g4M3,g4M4,vacant);
		System.out.println  ("│└────────┘│└────────┘ └────────┘ │   └────────┘ └────────┘│└────────┘");
		System.out.println  ("│          └───Group2─────────────┼───────────Group5───────┴──────────┐");
		System.out.println  ("│┌────────┐ ┌────────┐ ┌────────┐ │   ┌────────┐ ┌────────┐ ┌────────┐│");
		System.out.printf   ("││  %s  │ │  %s  │ │  %s  │ │   │  %s  │ │  %s  │ │  %s  ││\n",g2M4,g2M3,g2M2,g5M1,g5M2,g5M3);
		System.out.println  ("│└────────┘ └────────┘ └────────┘ │   └────────┘ └────────┘ └────────┘│");
		System.out.println  ("│                     ┌──Group3───┤                        ┌──────────┘");
		System.out.println  ("│┌────────┐ ┌────────┐│┌────────┐ │   ┌────────┐ ┌────────┐│┌────────┐");
		System.out.printf   ("││  %s  │ │  %s  │││  %s  │ │   │  %s  │ │  %s  │││  %s  │\n",g2M6,g2M5,g3M1,g5M4,g5M5,vacant);
		System.out.println  ("│└────────┘ └────────┘│└────────┘ │   └────────┘ └────────┘│└────────┘");
		System.out.println  ("├─────────────────────┘           └─────────────┬──────────┴──────────┐");
		System.out.println  ("│┌────────┐ ┌────────┐ ┌────────┐     ┌────────┐│┌────────┐ ┌────────┐│");
		System.out.printf   ("││  %s  │ │  %s  │ │  %s  │     │  %s  │││  %s  │ │  %s  ││\n",g3M4,g3M3,g3M2,g3M5,teac2,teac3);
		System.out.println  ("│└────────┘ └────────┘ └────────┘     └────────┘│└────────┘ └────────┘│");
		System.out.println  ("└───────────────────────────────────────────────┴───────Mentor────────┘ ");                    
		
		
	}

}
