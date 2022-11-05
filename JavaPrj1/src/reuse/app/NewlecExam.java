package reuse.app;

import reuse.Exam;

public class NewlecExam extends Exam {
	private int com;

	public NewlecExam() {
		super();
	}

	public NewlecExam(int kor, int eng, int math, int com) {
		super(kor, eng, math);
		this.com = com;
	}

	@Override
	public int total() {
		return super.total() + com;
	}

	@Override
	public double avg() {
		return this.total() / 4.0;
	}

	@Override
	public void onPrint() {
		System.out.printf("com:%d\n", com);
	}

	

}
