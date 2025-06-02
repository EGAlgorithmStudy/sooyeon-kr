import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class boj_128865_평범한_배낭_250603 {	
	static int N, K;
	static int[] weight;
	static int[] values;
	static int[] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		input(br);
		
		for (int n = 0; n < N; ++n) {
            for (int k = K; k >= weight[n]; --k) {
                dp[k] = Math.max(dp[k], dp[k - weight[n]] + values[n]);
            }
        }

		sb.append(dp[K]);
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static void input(BufferedReader br) throws Exception{
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		weight = new int[N];
		values = new int[N];
		dp = new int[K+1];
		for(int n=0; n<N; ++n) {
			st = new StringTokenizer(br.readLine());
			weight[n] = Integer.parseInt(st.nextToken());
			values[n] = Integer.parseInt(st.nextToken());
		}
	}

}
