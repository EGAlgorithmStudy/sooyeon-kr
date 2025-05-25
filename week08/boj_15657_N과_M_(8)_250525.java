import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class boj_15657_N과_M_(8)_250525 {	
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

	private static void dfs(int cnt, int idx, StringBuilder sb) {
		if(cnt == M) {
			sb.append(
					Arrays.stream(selected)
					.mapToObj(String::valueOf)
					.collect(Collectors.joining(" "))
			).append('\n');
			return;
		}
		
		for(int i=idx; i<N; ++i) {
			selected[cnt] = nums[i];
			dfs(cnt+1, i, sb);
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
