package com.newlecture.homwork;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Program33 {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		// pnum = 학생수
		int pnum = 0;
		// 메뉴 2. : 자동입력 부분에서 배열의 크기를 늘리기위함
		int max = 1;
		// 메뉴 2. : 자동입력을 실행했다면 auto를 true로 변경
		boolean auto = false;
		// 학생을 담을 변수 studentsArr 선언
		String[] studentsArr = new String[1];

		String[] group1 = new String[1]; // 메뉴 1. : 1조 구성원을 담을 배열 group1
		String[] group2 = new String[1];
		String[] group3 = new String[1];
		String[] group4 = new String[1];
		String[] group5 = new String[1];

		String[] studentAuto = new String[max]; // 메뉴 2. 자동입력에서 메모장에 있는 학생명단을 받아올 배열

		EXIT: while (true) {

			System.out.println("");
			System.out.println("  ┏━━━━* " + "자리배치" + "━━━━┓");
			System.out.println("  ┃                  *");
			System.out.println("  ┃   1. 학생 입력   ┃");
			System.out.println("  ┃   2. 자동 입력   ┃");
			System.out.println("  ┃   3. 자리 섞기   ┃");
			System.out.println("  ┃   4. 파일 저장   ┃");
			System.out.println("  ┃   5. 콘솔 출력   ┃");
			System.out.println("  ┃   6. 종료 하기   ┃");
			System.out.print("  ┗    ₍ᐢᐢ₎·°선택 >");
			int menu = sc.nextInt();

			switch (menu) {

			// ================================================1.
			// 학생입력=======================================================
			case 1: {
				System.out.print("학생 수를 입력하세요>>");
				pnum = sc.nextInt();
				studentsArr = new String[pnum];

				for (int i = 0; i < pnum; i++) {
					System.out.print((i + 1) + "번째학생이름>>\n");
					String name = sc.next();
					studentsArr[i] = name;
				}
			}
				break;
			// ================================================2.
			// 자동입력===========================================================
			case 2: {
				FileInputStream fis = new FileInputStream("res/list.csv");
				Scanner fscan = new Scanner(fis);
				// 맨 첫줄 "학생목록" 은 건너뛰게한다.
				System.out.println(fscan.nextLine());

				// index는 배열에 담긴 값의 갯수이다. 만약 index가 배열크기를 초과한다면, 임의적으로 배열을 늘려줄 것.
				int index = 0;

				while (fscan.hasNext()) {
					if (index >= max) {
						String[] sTemp = new String[max + 1];
						for (int i = 0; i < index; i++)
							sTemp[i] = studentAuto[i];

						studentAuto = sTemp;
						max = max + 1;
					} // end of if

					studentAuto[index] = fscan.nextLine();
					index++;
					auto = true; // 자동입력이 실행되었다면 auto 를 true로 변경
				} // end of while

				System.out.println("자동입력으로 받아온 학생명단" + Arrays.toString(studentAuto));

			} // end of case2
				break;

			// ================================================3.
			// 자리섞기===========================================================
			case 3: {
				System.out.println("자동입력했나요?" + auto);

				if (auto == true) {
					// 학생이름을 직접 입력한 것이 아니라, 자동으로 받아왔다면
					// studentsArr이 studentAuto이름표를 가지도록 변경
					studentsArr = studentAuto;
					// pnum을 입력 받지 않았기때문에 , studentsArr배열의 크기에 pnum 라벨을 붙인다.
					pnum = studentsArr.length;
				}

				// 랜덤한 숫자를 받을 1차원 randomArr - String으로 선언한 이유는 아래 2차원배열에 이름과 숫자를 함께담기위함
				String[] randomArr = new String[pnum];
				Random rand = new Random();

				// 랜덤 배열에서 중복숫자 제거
				for (int i = 0; i < randomArr.length; i++) {
					randomArr[i] = Integer.toString(rand.nextInt(pnum) + 1);
					for (int j = 0; j < i; j++) {
						if (randomArr[i].equals(randomArr[j]))
							i--;
					}
				}

				System.out.println("랜덤 숫자 배열입니다." + Arrays.toString(randomArr));
				System.out.println("학생 이름 배열입니다." + Arrays.toString(studentsArr));
				System.out.println();

				// 학생의 이름을 저장한 studentArr과 randomArr의 인덱스를 매칭시켜서 2차원 배열에 담아준다.
				String[][] matchArr = new String[pnum][2];
				for (int i = 0; i < pnum; i++) {
					matchArr[i][0] = studentsArr[i];
					matchArr[i][1] = randomArr[i];
				}

				System.out.println("매칭 시킨 배열입니다." + Arrays.deepToString(matchArr));
				System.out.println();

				// 랜덤으로 저장되어있는 숫자를 이름과 함께 1번부터 순서대로 정렬해준다.
				// String numTemp = 숫자를 저장할 임시공간
				// String nameTemp = 이름을 저장할 임시공간
				// 2개씩 비교하기때문에 총 길이보다 -1
				int sort = matchArr.length - 1;
				for (int j = 0; j < sort; j++)
					for (int i = 0; i < sort - j; i++) {
						// 오름차순 정렬
						if (Integer.parseInt(matchArr[i][1]) > Integer.parseInt(matchArr[i + 1][1])) {
							String numTemp;
							String nameTemp;
							numTemp = matchArr[i][1];
							matchArr[i][1] = matchArr[i + 1][1];
							matchArr[i + 1][1] = numTemp;

							nameTemp = matchArr[i][0];
							matchArr[i][0] = matchArr[i + 1][0];
							matchArr[i + 1][0] = nameTemp;
						}
					}

				System.out.println("정렬후 배열입니다." + Arrays.deepToString(matchArr));
				System.out.println();

				System.out.println("1,4,5조는 6명 / 2,3조는 4명으로 고정!");

				final int GNUM1 = 6;
				final int GNUM4 = 6;
				final int GNUM5 = 6;
				final int GNUM2 = 4;
				final int GNUM3 = 4;

				group1 = new String[GNUM1];
				group2 = new String[GNUM2];
				group3 = new String[GNUM3];
				group4 = new String[GNUM4];
				group5 = new String[GNUM5];

				int count = 0; // 배열의 크기, 0~학생수만큼 증가하면서 저장된 이름값을 순서대로 받아올 수 있도록

				for (int i = 0; i < GNUM1; i++) {
					group1[i] = matchArr[count][0];
					count++;
				}

				for (int i = 0; i < GNUM2; i++) {
					group2[i] = matchArr[count][0];
					count++;
				}

				for (int i = 0; i < GNUM3; i++) {
					group3[i] = matchArr[count][0];
					count++;
				}

				for (int i = 0; i < GNUM4; i++) {
					group4[i] = matchArr[count][0];
					count++;
				}

				for (int i = 0; i < GNUM5; i++) {
					group5[i] = matchArr[count][0];
					count++;
				}

				System.out.println("1조입니다: " + Arrays.toString(group1));
				System.out.println("2조입니다: " + Arrays.toString(group2));
				System.out.println("3조입니다: " + Arrays.toString(group3));
				System.out.println("4조입니다: " + Arrays.toString(group4));
				System.out.println("5조입니다: " + Arrays.toString(group5));

			}
				break;

			// ================================================4.
			// 파일저장===========================================================
			case 4: {

				FileOutputStream fos = new FileOutputStream("res/seat.csv");
				PrintStream ps = new PrintStream(fos);

				ps.print("1조: ");
				for (int i = 0; i < group1.length; i++) {
					ps.print(group1[i]);
					ps.print(" ");
				}
				ps.println();
				ps.print("2조: ");
				for (int i = 0; i < group2.length; i++) {
					ps.print(group2[i]);
					ps.print(" ");
				}
				ps.println();
				ps.print("3조: ");
				for (int i = 0; i < group3.length; i++) {
					ps.print(group3[i]);
					ps.print(" ");
				}
				ps.println();
				ps.print("4조: ");
				for (int i = 0; i < group4.length; i++) {
					ps.print(group4[i]);
					ps.print(" ");
				}
				ps.println();
				ps.print("5조: ");
				for (int i = 0; i < group5.length; i++) {

					ps.print(group5[i]);
					ps.print(" ");
				}
				ps.println();

				System.out.println("엑셀파일저장");

				fos.close();
				ps.close();
			}
				break;
			// ================================================5.
			// 콘솔출력===========================================================
			case 5: {

				String emptySeat = "   X  ";
				String upperBound = new String("┌─────────────────┐");
				String middleLeftBound = new String("│    ");
				String middleRightBound = new String("     │");
				String middleCrossBound = new String("├─────────────────┤");
				String lowerBound = new String("└─────────────────┘");

//	                           두번째 섹션에서, 같은 줄에 있는 자리들의 간격      
				String seatSpace = new String(" ");

//	                           첫번째 섹션에서, 각 조별 인원들을 출력하는 왼쪽 간격
				String section1_leftSpace = new String("               ");

//	                           두번째 섹션에서, 강의실 전체 자리 배치를 출력하는 왼쪽 간격
				String section2_leftSpace = new String("     ");

				System.out.println();
				System.out.println(
						"┌─┐───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┌─┐");
				System.out.println(
						"│─┼───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┼─│");
				System.out.println(
						"│ │                                                                                                                                               │ │");
				System.out.println(
						"│ │                                  * 자리배치 (자바개발자 - C / 오전 09:30 ~ / 한국ICT인재개발원 - B1 4강의실) *                                │ │");
				System.out.println(
						"│ │                                                                                                                                               │ │");
				System.out.println(
						"│─┼───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┼─│");
				System.out.println(
						"└─┘───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────└─┘");
				System.out.println();

				System.out.println(
						"------------------------------------------------------------- 변경된 조는 다음과 같습니다 ----------------------------------------------------------");
				System.out.println();

				System.out.printf("%3$s %1$s %2$s %1$s %2$s %1$s %2$s %1$s %2$s %1$s\n", upperBound, seatSpace,
						section1_leftSpace);
				System.out.printf(
						"%9$s %1$s %4$s%2$s %3$s %1$s %5$s%2$s %3$s %1$s %6$s%2$s %3$s %1$s %7$s%2$s %3$s %1$s %8$s%2$s %3$s\n",
						middleLeftBound, middleRightBound, seatSpace, "- 1조 -", "- 2조 -", "- 3조 -", "- 4조 -", "- 5조 -",
						section1_leftSpace);
				System.out.printf("%3$s %1$s %2$s %1$s %2$s %1$s %2$s %1$s %2$s %1$s\n", middleCrossBound, seatSpace,
						section1_leftSpace);
				System.out.printf(
						"%9$s %1$s %4$s %2$s %3$s %1$s %5$s %2$s %3$s %1$s %6$s %2$s %3$s %1$s %7$s %2$s %3$s %1$s %8$s %2$s %3$s\n",
						middleLeftBound, middleRightBound, seatSpace, group1[0], group2[0], group3[0], group4[0],
						group5[0], section1_leftSpace);
				System.out.printf("%3$s %1$s %2$s %1$s %2$s %1$s %2$s %1$s %2$s %1$s\n", middleCrossBound, seatSpace,
						section1_leftSpace);
				System.out.printf(
						"%9$s %1$s %4$s %2$s %3$s %1$s %5$s %2$s %3$s %1$s %6$s %2$s %3$s %1$s %7$s %2$s %3$s %1$s %8$s %2$s %3$s\n",
						middleLeftBound, middleRightBound, seatSpace, group1[1], group2[1], group3[1], group4[1],
						group5[1], section1_leftSpace);
				System.out.printf("%3$s %1$s %2$s %1$s %2$s %1$s %2$s %1$s %2$s %1$s\n", middleCrossBound, seatSpace,
						section1_leftSpace);
				System.out.printf(
						"%9$s %1$s %4$s %2$s %3$s %1$s %5$s %2$s %3$s %1$s %6$s %2$s %3$s %1$s %7$s %2$s %3$s %1$s %8$s %2$s %3$s\n",
						middleLeftBound, middleRightBound, seatSpace, group1[2], group2[2], group3[2], group4[2],
						group5[2], section1_leftSpace);
				System.out.printf("%3$s %1$s %2$s %1$s %2$s %1$s %2$s %1$s %2$s %1$s\n", middleCrossBound, seatSpace,
						section1_leftSpace);
				System.out.printf(
						"%9$s %1$s %4$s %2$s %3$s %1$s %5$s %2$s %3$s %1$s %6$s %2$s %3$s %1$s %7$s %2$s %3$s %1$s %8$s %2$s %3$s\n",
						middleLeftBound, middleRightBound, seatSpace, group1[3], group2[3], group3[3], group4[3],
						group5[3], section1_leftSpace);
				System.out.printf("%3$s %1$s %2$s %1$s %2$s %1$s %2$s %1$s %2$s %1$s\n", middleCrossBound, seatSpace,
						section1_leftSpace);
				System.out.printf(
						"%9$s %1$s %4$s %2$s %3$s %1$s %5$s %2$s %3$s %1$s %6$s %2$s %3$s %1$s %7$s %2$s %3$s %1$s %8$s %2$s %3$s\n",
						middleLeftBound, middleRightBound, seatSpace, group1[4], emptySeat, emptySeat, group4[4],
						group5[4], section1_leftSpace);
				System.out.printf("%3$s %1$s %2$s %1$s %2$s %1$s %2$s %1$s %2$s %1$s\n", middleCrossBound, seatSpace,
						section1_leftSpace);
				System.out.printf(
						"%9$s %1$s %4$s %2$s %3$s %1$s %5$s %2$s %3$s %1$s %6$s %2$s %3$s %1$s %7$s %2$s %3$s %1$s %8$s %2$s %3$s\n",
						middleLeftBound, middleRightBound, seatSpace, group1[5], emptySeat, emptySeat, group4[5],
						group5[5], section1_leftSpace);
				System.out.printf("%3$s %1$s %2$s %1$s %2$s %1$s %2$s %1$s %2$s %1$s\n", lowerBound, seatSpace,
						section1_leftSpace);

				System.out.println();
				System.out.println();

				System.out.println(
						"---------------------------------------------------------- 변경 후 좌석 배치는 다음과 같습니다 -----------------------------------------------------");

				System.out.println();
				System.out.println();

				System.out.printf(
						"%s │                    │                               │                                                   │           │                │ \n",
						section2_leftSpace);
				System.out.printf(
						"%s │      출입문        │                               │                   스크린                          │           │      교탁      │ \n",
						section2_leftSpace);
				System.out.printf(
						"%s │                    │                               │                                                   │           │                │ \n",
						section2_leftSpace);

				System.out.println();
				System.out.println();

				System.out.printf("%3$s %1$s %2$s %1$s %2$s %1$s %2$s %2$s %2$s %2$s %1$s %2$s %1$s %2$s %1$s \n",
						upperBound, seatSpace, section2_leftSpace);
				System.out.printf(
						"%10$s %1$s %4$s %2$s %3$s %1$s %5$s %2$s %3$s %1$s %6$s %2$s %3$s %3$s %3$s %3$s %1$s %7$s %2$s %3$s %1$s %8$s %2$s %3$s %1$s %9$s %2$s \n",
						middleLeftBound, middleRightBound, seatSpace, group1[0], group1[1], group1[2], group4[0],
						group4[1], group4[2], section2_leftSpace);
				System.out.printf("%3$s %1$s %2$s %1$s %2$s %1$s %2$s %2$s %2$s %2$s %1$s %2$s %1$s %2$s %1$s \n",
						lowerBound, seatSpace, section2_leftSpace);

				System.out.printf("%3$s %1$s %2$s %1$s %2$s %1$s %2$s %2$s %2$s %2$s %1$s %2$s %1$s %2$s %1$s \n",
						upperBound, seatSpace, section2_leftSpace);
				System.out.printf(
						"%10$s %1$s %4$s %2$s %3$s %1$s %5$s %2$s %3$s %1$s %6$s %2$s %3$s %3$s %3$s %3$s %1$s %7$s %2$s %3$s %1$s %8$s %2$s %3$s %1$s %9$s %2$s \n",
						middleLeftBound, middleRightBound, seatSpace, group1[3], group1[4], group1[5], group4[3],
						group4[4], group4[5], section2_leftSpace);
				System.out.printf("%3$s %1$s %2$s %1$s %2$s %1$s %2$s %2$s %2$s %2$s %1$s %2$s %1$s %2$s %1$s \n",
						lowerBound, seatSpace, section2_leftSpace);

				System.out.printf("%3$s %1$s %2$s %1$s %2$s %1$s %2$s %2$s %2$s %2$s %1$s %2$s %1$s %2$s %1$s \n",
						upperBound, seatSpace, section2_leftSpace);
				System.out.printf(
						"%10$s %1$s %4$s %2$s %3$s %1$s %5$s %2$s %3$s %1$s %6$s %2$s %3$s %3$s %3$s %3$s %1$s %7$s %2$s %3$s %1$s %8$s %2$s %3$s %1$s %9$s %2$s \n",
						middleLeftBound, middleRightBound, seatSpace, group2[0], group2[1], group2[2], group5[0],
						group5[1], group5[2], section2_leftSpace);
				System.out.printf("%3$s %1$s %2$s %1$s %2$s %1$s %2$s %2$s %2$s %2$s %1$s %2$s %1$s %2$s %1$s \n",
						lowerBound, seatSpace, section2_leftSpace);

				System.out.printf("%3$s %1$s %2$s %1$s %2$s %1$s %2$s %2$s %2$s %2$s %1$s %2$s %1$s %2$s %1$s \n",
						upperBound, seatSpace, section2_leftSpace);
				System.out.printf(
						"%10$s %1$s %4$s %2$s %3$s %1$s %5$s %2$s %3$s %1$s %6$s %2$s %3$s %3$s %3$s %3$s %1$s %7$s %2$s %3$s %1$s %8$s %2$s %3$s %1$s %9$s %2$s \n",
						middleLeftBound, middleRightBound, seatSpace, group3[0], group3[1], group2[3], group5[3],
						group5[4], group5[5], section2_leftSpace);
				System.out.printf("%3$s %1$s %2$s %1$s %2$s %1$s %2$s %2$s %2$s %2$s %1$s %2$s %1$s %2$s %1$s \n",
						lowerBound, seatSpace, section2_leftSpace);

				System.out.printf("%3$s %1$s %2$s %1$s %2$s %1$s %2$s %2$s %2$s %2$s %1$s %2$s %1$s %2$s %1$s \n",
						upperBound, seatSpace, section2_leftSpace);
				System.out.printf(
						"%10$s %1$s %4$s %2$s %3$s %1$s %5$s %2$s %3$s %1$s %6$s %2$s %3$s %3$s %3$s %3$s %1$s %7$s %2$s %3$s %1$s %8$s %2$s %3$s %1$s %9$s %2$s \n",
						middleLeftBound, middleRightBound, seatSpace, emptySeat, group3[2], group3[3], "멘토쌤", "멘토쌤",
						emptySeat, section2_leftSpace);
				System.out.printf("%3$s %1$s %2$s %1$s %2$s %1$s %2$s %2$s %2$s %2$s %1$s %2$s %1$s %2$s %1$s \n",
						lowerBound, seatSpace, section2_leftSpace);

			}
				break;
			// ================================================6.
			// 종료하기==========================================================

			case 6:
				System.out.println("프로그램 종료");
				break EXIT;

			default:
				System.out.println("1~7사이 값만 입력하세요");
				break;
			} // end of switch
		} // end of while

	}// end of main

} // end of class