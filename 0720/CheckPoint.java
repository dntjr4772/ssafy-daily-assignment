package com.java.first;

import java.util.Scanner;

public class CheckPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int weight, height;
		height=scan.nextInt();
		weight=scan.nextInt();
		int num=weight+100-height;
		System.out.println("�񸸼�ġ�� "+num+"�Դϴ�.");
		if(num>0)
			System.out.println("����� ���̱���");
		else
			System.out.println("����� ���� ü���̱���");
	}

}
