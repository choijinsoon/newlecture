package poly.app;

import poly.Banner;
import poly.Exam;
import poly.Printable;

public class Program {

	public static void main(String[] args) {
//		class AAA implements Printable {
//			public void onPrint() {
//				System.out.println("hello");
//			}
//		}
		
//		Printable p = new Printable() {
//			public void onPrint() {
//				System.out.println("hello");
//			
//			}
//		};
		
		Exam exam = new Exam(1, 2, 3);
//		Printable p = new AAA();
		exam.setPrintable(() ->{
				System.out.println("익명 클래스");
		});
		
		Banner banner = new FunBanner();
		exam.setBanner(banner);
		
		exam.print();
		
		/**
		 * 1.Banner 인터페이스 정의하기
		 * 2.Banner 인터페이스를 구현하는 BBB 클래스 구현하기
		 * 3.BBB 객체를 주입하기 위한 setBanner() 메소드 추가하기
		 * 4.BBB 객체를 주입하기 위한 속성 this.banner 추가하기
		 * 
		 */
	}

}
