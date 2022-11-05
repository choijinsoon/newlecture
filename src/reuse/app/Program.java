package reuse.app;

public class Program {

	public static void main(String[] args) {
		NewlecExam exam = new NewlecExam(1, 2, 3, 4);
		System.out.println(exam.total());
		exam.print();

	}

}
