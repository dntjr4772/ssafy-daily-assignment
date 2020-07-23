package com.ssafy.algo;

import java.util.Scanner;

public class DigitTest1 {
	
	public static void main(String[] args) {
		int[] arr=new int[10];
		Scanner sc=new Scanner(System.in);
		int num;
loop:	while(true) {
			num=sc.nextInt();
			if(num==0)
				break loop;
			arr[num/10]++;
		}
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]!=0)
				System.out.println(i + " : "+arr[i]+ "°³");
		}

	}

}
