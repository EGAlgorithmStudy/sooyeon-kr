import java.io.*;
import java.util.*;

public class boj_2056_작업_250506 {
	static int N;
	static int[] time;
	static int[] indeg;
	static int[] dp;
	static List<Integer>[] graph;

	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		input();

		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 1; i <= N; ++i) {
			if (indeg[i] == 0) dq.offer(i);
		}

		while (!dq.isEmpty()) {
			int cur = dq.poll();
			for (int nx : graph[cur]) {
				dp[nx] = Math.max(dp[nx], dp[cur] + time[nx]);
				indeg[nx]--;
				if (indeg[nx] == 0) {
					dq.offer(nx);
				}
			}
		}

		for (int i = 1; i <= N; ++i) {
			ans = Math.max(ans, dp[i]);
		}
		
		sb.append(ans).append('\n');
		bw.write(sb.toString());
		bw.close();
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		time = new int[N + 1];
		indeg = new int[N + 1];
		dp = new int[N + 1];
		graph = new ArrayList[N + 1];
		for (int i = 0; i <= N; ++i) graph[i] = new ArrayList<>();

		for (int task = 1; task <= N; ++task) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[task] = Integer.parseInt(st.nextToken());
			dp[task] = time[task]; 

			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; ++j) {
				int pre = Integer.parseInt(st.nextToken());
				graph[pre].add(task);
				indeg[task]++;
			}
		}
	}
}
