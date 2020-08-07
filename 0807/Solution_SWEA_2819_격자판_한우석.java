import java.io.*;
import java.util.*;

public class Solution_SWEA_2819_격자판_한우석 {
	private static int[][] map;
	private static Set<Integer> s;
	private static int[] dy = { 1, 0, -1, 0 };
	private static int[] dx = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			s = new HashSet<Integer>();
			map = new int[4][4];
			
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 4; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					DFS(i,j,1,map[i][j]);
				}
			}
				
			System.out.printf("#%d %d\n", test_case, s.size());
		}

	}

	private static void DFS(int i, int j, int cnt, int num) {
		if (cnt == 7) {
			s.add(num);
			return;
		}
		for (int k = 0; k < 4; k++) {
			int ny = i + dy[k];
			int nx = j + dx[k];
			if (ny >= 0 && nx >= 0 && ny < 4 && nx < 4)
				DFS(ny, nx, cnt + 1, num * 10 + map[ny][nx]);
		}
	}

}
