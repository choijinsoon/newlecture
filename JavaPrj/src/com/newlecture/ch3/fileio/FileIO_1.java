package com.newlecture.ch3.fileio;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIO_1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fin = new FileInputStream("D:\\WorkSpace\\Java3thPrj\\res\\Source.java");
		FileOutputStream fout = new FileOutputStream("D:\\WorkSpace\\Java3thPrj\\res\\Source_copy.java");

		// ---------------------------------------
	
		while (true) {
			int x = fin.read();

			fout.write(x);
			if(x == 'n') {
				fout.write('N');
			}
			if(x==-1)
				break;

		}

		// ---------------------------------------
		fout.flush();
		fout.close();
		fin.close();

		System.out.printf("완료");

	}

}
