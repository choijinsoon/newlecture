package com.newlecture.ch3.fileio;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIO_2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fin = new FileInputStream("C:\\Users\\ict04-19\\eclipse-workspace\\JavaPrj\\src\\com\\newlecture\\ch3\\fo\\data.txt");
		FileOutputStream fout = new FileOutputStream("C:\\Users\\ict04-19\\eclipse-workspace\\JavaPrj\\src\\com\\newlecture\\ch3\\fo\\data_copy.txt");

		// ---------------------------------------
	
		
		while (true) {
			int x = fin.read();

			if(x != ' ' && x != '	') 
				fout.write(x);
				
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
