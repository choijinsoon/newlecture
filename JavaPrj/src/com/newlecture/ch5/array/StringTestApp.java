package com.newlecture.ch5.array;

public class StringTestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x = 30;
		String x_ = String.valueOf(x);
		System.out.printf("%s\n", x_);
		x = Integer.parseInt(x_);
		
		String name1 = "아이유";
		String name2 = "아이유";
		
		System.out.println(name1 == name2);
		System.out.println(name1.equals(name2));		
		System.out.println(name1=="아이유");
		
		name2 = new String("아이유");
		
		System.out.println(name1 == name2);
		System.out.println(name1.equals(name2));		
		System.out.println(name2=="아이유");

		String fileName = "/menu/photo.jpg";
		int index1 = fileName.indexOf('/',1);
		System.out.printf("index1 : %d\n", index1);
		int index2 = fileName.indexOf('.');
		System.out.printf("index2 : %d\n", index2);
		
		String sub = fileName.substring(index1+1, index2);
		System.out.printf("%s\n", sub);
		
		int index3 = fileName.indexOf('.');
		System.out.printf("index3 : %d\n", index3);
		String sub1 = fileName.substring(index3+1);
		System.out.printf("%s\n", sub1);
		
		
		
	}

}
