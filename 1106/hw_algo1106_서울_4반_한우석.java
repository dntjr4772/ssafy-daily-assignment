import java.io.*;
import java.util.*;

public class hw_algo1106_서울_4반_한우석 {
	static int num,x,y,d,g;;
	static boolean[][] map=new boolean[101][101];
	static List<Integer> list=new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			x=Integer.parseInt(st.nextToken());
			y=Integer.parseInt(st.nextToken());
			d=Integer.parseInt(st.nextToken());
			g=Integer.parseInt(st.nextToken());
			map[y][x]=true;
			list.add(d);
			getDir(g);
			draw();
			list.clear();
		}
		System.out.println(squareNum());
	}
	private static int squareNum() {
		int result=0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(map[i][j]&&map[i+1][j]&&map[i][j+1]&&map[i+1][j+1])
					result++;
			}
		}
		return result;
	}
	private static void draw() {
		for (int dir : list) {
			switch (dir) {
			case 0:
				x++;
				break;
			case 1:
				y--;
				break;
			case 2:
				x--;
				break;
			case 3:
				y++;
				break;
			default:
				break;
			}
			map[y][x]=true;
		}	
	}
	private static void getDir(int g) {
		for (int i = 0; i < g; i++) {
			for (int j = list.size()-1; j >=0 ; j--) {
				num=(list.get(j)+1)%4;
				list.add(num);
			}
		}
	}
}