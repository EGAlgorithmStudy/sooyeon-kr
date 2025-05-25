import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class boj_15654_N과_M_(6)_250525 {
	static int N, M;
	static int[] nums;
	static int[] selected;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		input(br);
		
		dfs(0, 0, sb);
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static void dfs(int idx, int cnt, StringBuilder sb) {
		
		if(cnt == M) {
			for(int s : selected) {
				sb.append(s).append(' ');
			}
			sb.append('\n');
			return;
		}
		for(int i=idx; i<N; i++) {
			selected[cnt] = nums[i];
			dfs(i+1, cnt+1, sb);
		}
		
	}

	private static void input(BufferedReader br) throws Exception{
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(nums);
		selected = new int[M];
		
	}

}
