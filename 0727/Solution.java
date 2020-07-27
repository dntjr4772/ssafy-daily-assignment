package swea1289;

import java.util.Scanner;
import java.io.FileInputStream;


class Solution{
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++){
			String tmp=sc.next();
			int len=tmp.length();
			int[] num=new int[len];
			int[] reset=new int[len];
			int result=0;
			for(int i=0;i<len;i++) 
				num[i]=tmp.charAt(i)-'0';
			
			for(int i=0;i<len;i++) {
				if(reset[i]!=num[i]) {
					for (int j = i; j < len; j++) 
						reset[j]^=1;	//XOR로 토글
					result++;
				}
			}
			System.out.printf("#%d %d\n",test_case,result);
		}	//end of testcase
	}	//end of main
}