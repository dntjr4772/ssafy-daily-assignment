package com.ssafy.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int T=scan.nextInt();
		for(int t=1;t<=T;t++) {
			int N,num;
			N=scan.nextInt();
			num=scan.nextInt();
			int[][] pond=new int[N][N];
			int[] strider_y=new int[num];	//소금쟁이 위치 행
			int[] strider_x=new int[num];	//소금쟁이 위치 열
			int[] strider_dir=new int[num];	//소금쟁이 방향
			int live=num;
			
			//시작위치, 방향 입력
			for (int i = 0; i < num; i++) {
				strider_y[i]=scan.nextInt();
				strider_x[i]=scan.nextInt();
				pond[strider_y[i]][strider_x[i]]++;
				strider_dir[i]=scan.nextInt();
			}
			//
			for (int i = 0; i < num; i++) {
jump:			for (int j = 3; j > 0; j--) {	//j만큼 점프
					boolean alive=true;
					if(pond[strider_y[i]][strider_x[i]]>1) {	//시작위치에 이미 다른 소금쟁이가 있다면 죽는다
						live--;
						alive=false;
						pond[strider_y[i]][strider_x[i]]-=1;
						break jump;
					}
					
					switch(strider_dir[i]) {
					case 1:		//상
						pond[strider_y[i]][strider_x[i]]-=1;	//처음 뛴 자리는 호수에서 false로
						strider_y[i]-=j;
						if(strider_y[i]<0 || pond[strider_y[i]][strider_x[i]]>0) {	//죽음
							live--;
							alive=false;
							break jump;
						}
						break;
					case 2:		//하
						pond[strider_y[i]][strider_x[i]]-=1;	//처음 뛴 자리는 호수에서 false로
						strider_y[i]+=j;
						if(strider_y[i]>=N || pond[strider_y[i]][strider_x[i]]>0) {	//죽음
							live--;
							alive=false;
							break jump;
						}
						break;
					case 3:		//좌
						pond[strider_y[i]][strider_x[i]]-=1;	//처음 뛴 자리는 호수에서 false로
						strider_x[i]-=j;
						if(strider_x[i]<0 || pond[strider_y[i]][strider_x[i]]>0) {	//죽음
							live--;
							alive=false;
							break jump;
						}
						break;
					case 4:		//우
						pond[strider_y[i]][strider_x[i]]-=1;	//처음 뛴 자리는 호수에서 false로
						strider_x[i]+=j;
						if(strider_x[i]>=N || pond[strider_y[i]][strider_x[i]]>0) {	//죽음
							live--;
							alive=false;
							break jump;
						}
						break;
					}
					if(alive)
						pond[strider_y[i]][strider_x[i]]+=1;
				}
			}
			System.out.println("#"+t+" "+live);
		}	//end of test
	}	//end of main

}


