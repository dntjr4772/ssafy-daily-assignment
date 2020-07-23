package com.java.first;

import java.util.Scanner;

public class Compute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int a,b;
		System.out.println("두 수를 입력");
		a=scan.nextInt();
		b=scan.nextInt();
		System.out.println(a*b);
		System.out.println(a/b);
	}

}
