import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class hw_algo1030_서울_4반_한우석 {
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T=Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int[] dp=new int[16];
			int[] prices=new int[4];
			int[] plan=new int[13];
			
			st=new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) 
				prices[i]=Integer.parseInt(st.nextToken());
			
			st=new StringTokenizer(br.readLine());
			for (int i = 1; i <= 12; i++) 
				plan[i]=Integer.parseInt(st.nextToken());
			
			int result=prices[3];	//1년치로 계산
			
			for (int i = 1; i <= 12; i++) {
				dp[i]=dp[i-1]+plan[i]*prices[0];	//1일
				int tmp;
				tmp=dp[i-1]+prices[1];			//1달
				if(tmp<dp[i])
					dp[i]=tmp;
				if(i>=3) {
					tmp=dp[i-3]+prices[2];				//3달
					if(tmp<dp[i])
						dp[i]=tmp;
				}
			}
			result=Integer.min(result, dp[12]);
			StringBuilder sb=new StringBuilder();
			sb.append("#").append(t).append(" ").append(result);
			System.out.println(sb);
		}	//end of tc
	}
}
