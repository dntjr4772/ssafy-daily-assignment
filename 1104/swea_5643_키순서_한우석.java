import java.io.*;
import java.util.*;

public class swea_5643_키순서_한우석 {
	static int N,M,result;
	static boolean[][] graph;
	static Queue<Integer> Q=new LinkedList<Integer>();
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuilder sb;
		int T=Integer.parseInt(st.nextToken());
		int a,b;
		String input;
		for (int t = 1; t <= T; t++) {
			result=0;
			input=br.readLine();
			N=Integer.parseInt(input);
			input=br.readLine();
			M=Integer.parseInt(input);
			graph=new boolean[N+1][N+1];
			visited=new boolean[N+1];
			for (int i = 0; i < M; i++) {
				st=new StringTokenizer(br.readLine());
				a=Integer.parseInt(st.nextToken());
				b=Integer.parseInt(st.nextToken());
				graph[a][b]=true;
			}
			
			for (int i = 1; i <= N; i++) {
				//bfs
				int cnt=1;
				Q.add(i);
				visited[i]=true;
				while(!Q.isEmpty()) {
					int cur=Q.poll();
					for (int j = 1; j <= N; j++) {
						if(graph[cur][j]&&!visited[j]) {
							Q.add(j);
							visited[j]=true;
							cnt++;
						}
					}
				}	//end of Q while
				Q.add(i);
				visited[i]=true;
				while(!Q.isEmpty()) {
					int cur=Q.poll();
					for (int j = 1; j <= N; j++) {
						if(graph[j][cur]&&!visited[j]) {
							Q.add(j);
							visited[j]=true;
							cnt++;
						}
					}
				}	//end of Q while
				Arrays.fill(visited, false);
				if(cnt==N)
					result++;
			}
			sb=new StringBuilder();
			sb.append("#").append(t).append(" ").append(result);
			System.out.println(sb);
		}	//end of tc
	}
}
