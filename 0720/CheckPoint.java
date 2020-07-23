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
		System.out.println("비만수치는 "+num+"입니다.");
		if(num>0)
			System.out.println("당신은 비만이군요");
		else
			System.out.println("당신은 정상 체중이군요");
	}

}
