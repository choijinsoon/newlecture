import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class TestCoding {
	public static void main(String[] args) {
		int arr = 10; // true
		int arr2 = 13; // false
		boolean answer = true;
		int sum = 0;
		int x = arr2;

		while (arr2 > 0) {
			sum += arr2 % 10; // sum = 0, 1
			arr2 = arr2 / 10; // arr = 1, 0
		}
		
		if (x % sum ==0)
			answer = true;
		else 
			answer = false;
		
		
		System.out.println(answer);

	}
}
