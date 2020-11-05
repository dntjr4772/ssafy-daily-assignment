import java.io.*;
import java.util.*;

public class hw_algo1105_서울_4반_한우석 {
	static boolean flag=false;
	static int N,result;
	static char[][] map;
	static boolean[][] popped;
	static int[] dr= {1,1,1,0,0,-1,-1,-1};
	static int[] dc= {-1,0,1,-1,1,-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int T=Integer.parseInt(st.nextToken());
		String input;
		for (int t = 1; t <= T; t++) {
			result=0;
			st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			map=new char[N][N];
			popped=new boolean[N][N];
			for (int i = 0; i < N; i++) {
				input=br.readLine();
				map[i]=input.toCharArray();
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]=='.') {
						isZero(i,j);
						flag=false;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]=='9' && !popped[i][j])	//혼자 찍힌 것
						result++;
				}
			}
			
			StringBuilder sb=new StringBuilder();
			sb.append("#").append(t).append(" ").append(result);
			System.out.println(sb);
		}
	}
	private static void isZero(int r, int c) {
		int nr,nc;
		for (int k = 0; k < 8; k++) {
			nr=r+dr[k];
			nc=c+dc[k];
			if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
			if(map[nr][nc]=='*') {
				map[r][c]='9';	//주변에 지뢰가 존재
				return;
			}
		}
		map[r][c]='0';
		if(!flag) {
			flag=true;
			result++;
		}
		popping(r,c);
	}
	private static void popping(int r, int c) {
		int nr,nc;
		for (int k = 0; k < 8; k++) {
			nr=r+dr[k];
			nc=c+dc[k];
			if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
			if(map[nr][nc]=='*') continue;
			if(map[nr][nc]=='.') {
				isZero(nr,nc);
			}
			popped[nr][nc]=true;	//0주변으로 찍힌값
		}
		
	}
	
}
