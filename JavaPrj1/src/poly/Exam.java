package poly;

public class Exam {
	private int kor;
	private int eng;
	private int math;
	private Printable printable;
	private Banner banner;

	public Exam() {

	}

	public Exam(int kor, int eng, int math) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public int total() {
		return kor + eng + math;
	}

	public double avg() {
		return this.total() / 3.0;
	}

	public void print() {
		if(banner != null)
			banner.print();
		else {
			System.out.println("┌───────────────────────┐");
			System.out.println("│      	  성적 출력        │");
			System.out.println("└───────────────────────┘");			
		}
		System.out.printf("kor:%d\n", kor);
		System.out.printf("eng:%d\n", eng);
		System.out.printf("math:%d\n", math);
		if(printable != null)
			printable.onPrint();
		System.out.printf("total:%d\n", total());
		System.out.printf("avg:%f\n", avg());
	}

	public void onPrint() {

	}

	public void setBanner(Banner banner) {
		this.banner = banner;
		
	}

	public void setPrintable(Printable p) {
		this.printable = p;
		
	}

}
