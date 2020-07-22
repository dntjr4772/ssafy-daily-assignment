package com.ssafy.algo;

import java.util.Scanner;

public class Solution13 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int T;
		int[] nx= {-1,-1,-1,0,0,1,1,1};
		int[] ny= {-1,0,1,1,-1,1,-1,0};
		Scanner scan = new Scanner(System.in);
		T=scan.nextInt();
		for(int t=1;t<=T;t++) {
			int N=scan.nextInt();
			int max=0;
			char[][] site=new char[N][N];
			boolean[][] park=new boolean[N][N];
			boolean two=false;
			
			//입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					site[i][j]=scan.next().charAt(0);
				}
			}	
			
			//인접 구획에 공원이 있다면
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < 8; k++) {	//8방향 가보기
						int dx=nx[k]+j;
						int dy=ny[k]+i;
						if(dx<0 || dx>=N || dy<0 || dy>=N) continue;
						if(site[dy][dx]=='G') { 
							park[i][j]=true;
							two=true;
							break;
						}
					}
				}
			}
			
			//인접 구획에 공원이 없다면
			for (int i = 0; i < N; i++) {		
				for (int j = 0; j < N; j++) {
					int sum=1;
					if(!park[i][j] && site[i][j]=='B') {
						for (int a = 0; a < N; a++) {
							if(a==i) continue;
							if(site[a][j]=='G') continue;
							sum++;
						}
						for (int b = 0; b < N; b++) {
							if(b==j) continue;
							if(site[i][b]=='G') continue;
							sum++;
						}
						if(max<sum) {
							max=sum;
							//System.out.println("i"+i+"j"+j+"sum"+sum);
						}
					}
				}
			}	
			
			// 2층짜리 빌딩이 있고  max가 2보다 작다면
			if(two && max<2) {	
				max=2;
			}
			
			System.out.println("#"+t+" "+max);
		}	//end of testcase
		
	}

}
