import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class App {
	public static void main(String[] args) throws IOException {
//		long x = 300L;
//		double y = 3.4;
//		char c = 'a';
//		boolean b = true;
//		int i = 100;
//
//		int kor1, kor2, kor3;
//		int total;
//		float avg;
//
//		kor1 = 50;
//		kor2 = 60;
//		kor3 = 80;
//
//		total = kor1 + kor2 + kor3;
//		avg = total / 3;
//
//		System.out.printf("total is %d\n", total);
//		System.out.printf("avg is %f\n", avg);
//
//		System.out.write(3);
//		System.out.write('3' + 1);
//		System.out.flush();
//		System.out.println(3.45);
//		System.out.println();
//
//		// 성적 출력
//		int kor1, kor2, kor3;
//		int total;
//		float avg;
//
//		Scanner scan = new Scanner(System.in);
//
//		while (true) {
//			System.out.print("┌────────────────────────────┐\n");
//			System.out.print("│           성적 입력          │\n");
//			System.out.print("└────────────────────────────┘\n");
//			System.out.print("국어1:");
//			kor1 = scan.nextInt();
//			System.out.print("국어2:");
//			kor2 = scan.nextInt();
//			System.out.print("국어3:");
//			kor3 = scan.nextInt();
//
//			total = kor1 + kor2 + kor3;
//			avg = total / 3.0f;
//
//			System.out.print("┌────────────────────────────┐\n");
//			System.out.print("│           성적 출력          │\n");
//			System.out.print("└────────────────────────────┘\n");
//			System.out.printf("국어1:%d\n", kor1);
//			System.out.printf("국어2:%d\n", kor2);
//			System.out.printf("국어3:%d\n", kor3);
//			System.out.printf("총점:%d\n", total);
//			System.out.printf("평균:%f\n", avg);
//		}
//
//		int num;
//		Random rand = new Random();
//		num = rand.nextInt(100) + 1;
//		boolean b = num % 2 == 1;
//		System.out.printf("홀수 : %d : %b\n", num, b);
//
//		boolean b2 = num % 3 == 0;
//		System.out.printf("3의 배수 : %d : %b\n", num, b2);
//
//		boolean b3 = num % 3 == 1;
//		System.out.printf("숙제 : %d : %b\n", num, b3);
//
//		Random rand = new Random();
//		int num = rand.nextInt(100) + 1;
//
//		String result = num % 2 == 1 ? "홀수" : "짝수";
//		System.out.printf("숫자 : %d, 결과 : %s\n", num, result);
//
//		System.out.printf("%5.2f\n", 100.123456);
//
//		// 문자열 객체 생성
//		String s1 = new String("Hello");
//		// type 쇠돌이(객체명=참조변수) 실체화 도구(type) 값
//		// 도구화 된 것 = 참조 (내 이름)
//
//		{
//			int code = System.in.read();
//			// read함수는 1 byte만 읽고 바이너리 코드 변환 -> 53 ( 5의 바이너리 출력은 53 )
//			System.out.println(code);
//			// 53을 문자 출력
//			System.out.write(code);
//			// 53을 바이너리 출력
//			System.out.flush();
//			System.out.println();
//		}
//
//		{
//			int code = System.in.read();
//			// read함수는 1 byte만 읽고 바이너리 코드 변환 -> 53 ( 5의 바이너리 출력은 53 )
//			System.out.println(code);
//			// 53을 문자 출력
//			System.out.write(code);
//			// 53을 바이너리 출력
//			System.out.flush();
//			System.out.println();
//		}
//
//		{
//			int code = System.in.read();
//			// read함수는 1 byte만 읽고 바이너리 코드 변환 -> 53 ( 5의 바이너리 출력은 53 )
//			System.out.println(code);
//			// 53을 문자 출력 -> 53
//			System.out.write(code);
//			// 53을 바이너리 출력 -> 3
//			System.out.flush();
//			System.out.println();
//		}
//
//		// 문자 랜덤
//		Random rand1 = new Random();
//
//		System.out.print("UpperCase : ");
//		System.out.write(rand1.nextInt(26) + 65);
//		System.out.flush();
//		System.out.println();
//
//		System.out.print("LowerCase : ");
//		System.out.write(rand1.nextInt(26) + 97);
//		System.out.flush();
//		System.out.println();
//
//		Random rand1 = new Random();
//		int max = 10;
//		int total1 = 0;
//		int total2 = 0;
//		for (int i = 0; i < max; i++) {
//			int num = rand1.nextInt(2) + 1;
//			if (num == 1) {
//				total1++;
//			} else if (num == 2) {
//				total2++;
//			}
//		}
//		System.out.println(total1);
//		System.out.println(total2);
//		System.out.println(max);
//
//		double percent1 = total1*100.0/max;
//		double percent2 = total2*100.0/max;
//
//		System.out.println(percent1);
//		System.out.println(percent2);
//
		//랜덤 함수 맞추기
		Random rand1 = new Random();
		int answer = rand1.nextInt(50) + 1;
		int chance = 5;
		int i = 0;

		Scanner scan = new Scanner(System.in);

		while(i<chance) {
			System.out.print("숫자 입력: ");
			int num = scan.nextInt();
			if (num == answer) {
				System.out.printf("%d 정답입니다.\n", num);
				break;
			} else {
				System.out.printf("%d 오답입니다.\n", num);
			}

			if (num >= answer) {
				System.out.printf("%d 보다 낮습니다.\n", num);
			} else if (num <= answer) {
				System.out.printf("%d 보다 높습니다.\n", num);
			}
			i++;
		}

		System.out.printf("정답은 %d 입니다.", answer);
		//
		// a0은 기본 패, a1은 히든 패
//		int[] a0 = {"a0b1", "a0b2", "a0b3", "a0b4", "a0b5", "a0b6", "a0b7", "a0b8", "a0b9", "a0b10"};
//		int[] a1 = {"a1b1", "a1b2", "a1b3", "a1b4", "a1b5", "a1b6", "a1b7", "a1b8", "a1b9", "a1b10"};
		
		
		
		
		
		
		

	}
}
