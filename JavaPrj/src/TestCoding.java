import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class TestCoding {
	public static void main(String[] args) {

		Student s = new Student();

		s.sg = new StudentGroup[3];
		
		s.sg[0].group = "1";
		
		System.out.println(s.sg[0].group);
		

	}
}
