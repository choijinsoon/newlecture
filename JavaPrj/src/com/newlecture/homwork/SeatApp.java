package com.newlecture.homwork;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class SeatApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int pnum =0;
		String[] studentsArr = new String[1];//학생을 담을 변수 studentsArr 선언
		
		EXIT:
		while(true) {
			System.out.println("┌────────────────────────┐");
			System.out.println("│    자리배치 ₍ᐢ- ̫-ᐢ₎‧˚   │");
			System.out.println("└────────────────────────┘");
			System.out.println("\t 1. 학생 입력");
			System.out.println("\t 2. 자리 섞기");
			System.out.println("\t 3. 엑셀 출력");
			System.out.println("\t 4. 콘솔 출력");
			System.out.println("\t 5. 종료 하기");
			System.out.print("\t ₍ᐢᐢ₎·°선택:");
			int menu = sc.nextInt();
			switch(menu) {
			
			case 1:
					{
						System.out.print("학생 수를 입력하세요>>");
						pnum = sc.nextInt(); // pnum = people num, 학생수
						studentsArr = new String[pnum];
						
						for(int i =0; i<pnum; i++) {
							System.out.print((i+1)+"번째학생이름>>\n");
							String name  = sc.next();
							studentsArr[i] = name;
						 }
					}
					 break;
			case 2:
					{
						String[] randomArr = new String[pnum];
						Random rand = new Random();
						
						
						for (int i = 0; i < randomArr.length; i++) {
				            randomArr[i] = Integer.toString(rand.nextInt(pnum)+1);
				          // 2.중복 처리
				            for (int j = 0; j < i; j++) {
				                if (randomArr[i].equals(randomArr[j]))
				                {
				                    // 중복이있으면 i번째로 다시 돌아가야하므로 증가시키지 않고 i--
				                    i--;
				                    }
				            	}
						}
						
						String a = Arrays.toString(randomArr);
						System.out.println(a);
						
						String[][] Arr = new String[pnum][2];
						
						for(int i=0; i<pnum; i++) {
								Arr[i][0] = studentsArr[i];
								Arr[i][1] = randomArr[i];
								}
						System.out.println(Arrays.deepToString(Arr));	
						
		
						for (int j=0; j<Arr.length-1; j++) {
							for (int i =0; i< Arr.length-1-j; i++) {
								if(Integer.parseInt(Arr[i][1])>Integer.parseInt(Arr[i+1][1])) 
								{
									String tmp1;
									String tmp2;
									tmp1 = Arr[i][1];								
									Arr[i][1] =Arr[i+1][1];							
									Arr[i+1][1] = tmp1;
									
									tmp2 = Arr[i][0];
									Arr[i][0] = Arr[i+1][0];
									Arr[i+1][0] = tmp2;
								}
							}
							
						}
						System.out.println(Arrays.deepToString(Arr));
						
						System.out.println("1조 인원을 입력하세요 (4,6 중 하나만)");
						int gnum1 = sc.nextInt();
						
						for(int i=0; i<gnum1; i++) { // ex numOne 6  i는 0 1 2 3 4 5 (인덱스)
														
							
							String[] group1 = new String[gnum1];
							group1[i] = Arr[i][0];
							System.out.println(Arr[i][0]);
					}
						
						System.out.println("2조 인원을 입력하세요 (4,6 중 하나만)");
						
						int gnum2 = sc.nextInt();
						for(int i =gnum1; i<gnum2; i++) {
							
							String[] group2 = new String[gnum2];
							group2[i] = Arr[i][0];
							System.out.println(Arr[i][0]);
							
						}
						
						System.out.println("3조 인원을 입력하세요 (4,6 중 하나만)");
						int gnum3 = sc.nextInt();
						for(int i =gnum2; i<gnum3; i++) {
							String[] group3 = new String[gnum3];
							group3[i] = Arr[i][0];
							System.out.println(Arr[i][0]);
							
						}
						System.out.println("4조 인원을 입력하세요 (4,6 중 하나만)");
						int gnum4 = sc.nextInt();
						for(int i =gnum3; i<gnum4; i++) {
							
						}
						System.out.println("5조 인원을 입력하세요 (4,6 중 하나만)");
						int gnum5 = sc.nextInt();
						for(int i =gnum4; i<gnum5; i++) {
							
						}
						
						
						}
					     break;
					     
							case 4:
							{					
								System.out.println("자리 출력");	
								System.out.print    ("=====================================================================\n");
								System.out.print    ("                            4강의실 자리표                               \n");
								System.out.print    ("=====================================================================\n");
								System.out.println();
								System.out.print    ("┌───────┐ ┌──────────────────────────────────────────────────────────┐\n");
								System.out.print    ("│  Door │ │                       Whiteboard                         │\n");
								System.out.print    ("└───────┘ └──────────────────────────────────────────────────────────┘\n");
								

							
							}
							break;
				} // end of switch
			}// end of while
			
			
		}// end of main
		
		
	} // end of class
	

