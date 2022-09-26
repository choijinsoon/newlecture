package com.newlecture.ch3.fileio;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyApp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fin = new FileInputStream("D:\\WorkSpace\\Java3thPrj\\res\\Source.java");
		FileOutputStream fout = new FileOutputStream("D:\\WorkSpace\\Java3thPrj\\res\\Source_copy.java");

		// ---------------------------------------
		while (true) {
			int x = fin.read();

			if(x==-1)
				break;
			
			if(x!='\n' && x!='\r')
				fout.write(x);
		}

		// ---------------------------------------
		fout.flush();
		fout.close();
		fin.close();

		System.out.println("파일 복사가 완료되었습니다.");

	}

}
