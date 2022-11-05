package com.newlecture.ch3.fileio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class FileInputOutputApp {

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Random rand1 = new Random();

		FileOutputStream fout = new FileOutputStream("D:\\WorkSpace\\Java3thPrj\\res\\data.txt");
		FileInputStream fin = new FileInputStream("D:\\WorkSpace\\Java3thPrj\\res\\data.txt");
		FileOutputStream fout1 = new FileOutputStream("D:\\WorkSpace\\Java3thPrj\\res\\data_copy.txt");

		while (true) {
			int num = rand1.nextInt(26) + 65;
			if (num == 90)
				break;
			fout.write(num);
			fout.flush();
		}

		fout.close();
		System.out.println("파일 저장이 완료되었습니다.");

		while (true) {
			int x = fin.read();

			if (x == -1)
				break;

			fout1.write(x);
		}

		fout1.close();
		fin.close();

		System.out.println("파일 복사가 완료되었습니다.");

	}

}
