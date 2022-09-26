package com.newlecture.ch3.fileio;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStringCount {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fin = new FileInputStream("D:\\WorkSpace\\Java3thPrj\\res\\Source.java");

		// ---------------------------------------
	
		int count = 0;
		while (true) {
			int x = fin.read();

			if(x==-1)
				break;

			if(x == '\n')
				count++;
		}

		// ---------------------------------------
		fin.close();

		System.out.printf("라인 개수 : %d", count);

	}

}
