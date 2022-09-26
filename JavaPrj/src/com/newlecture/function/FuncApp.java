package com.newlecture.function;

public class FuncApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] st = new String[3];
		
		//st = { "ab", "bc", "cd" }; //공간에 공간을 넣지 못한다
		st[0] = "ab";
		st[0] = "bc";
		st[0] = "cd";

		int[] in = new int[3];
		
		//in = { 1, 2, 3 };
		
		int[] ins = { 1, 2, 3 };

		prints(st);
		for (int i = 0; i < st.length; i++)
			System.out.println(st[i]);
		
		prints(in);
	}

	static void prints(int[] i) {
		i[0] = 2;
		i[1] = 3;
		i[2] = 4;
	}
	static void prints(String[] s) {
		s[0] = "ba";
		s[1] = "cb";
		s[2] = "dc";
	}
}
