import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class boj_15654_N과_M_(5)_250525 {	
	static int N, M;
	static int[] selected;
	static boolean[] visited;
	static int[] nums;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		input(br);
		
		dfs(0, sb);
		bw.write(sb.toString());
		bw.close();

	}

	private static void dfs(int cnt, StringBuilder sb) {
		if(cnt == M) {
			for(int num : selected) {
				sb.append(num).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int idx = 0; idx<N; ++idx) {
			if(visited[idx]) continue;
			visited[idx] = true;
			int curNum = nums[idx];
			selected[cnt] = curNum;
			dfs(cnt + 1, sb);
			visited[idx] = false;
		}
	}

	private static void input(BufferedReader br) throws Exception{
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(nums);
		
		visited = new boolean[N];
		selected = new int[M];
		
	}

}
