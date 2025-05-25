package algo;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class boj_15656_N과_M_(7)_250525 {
	static int N, M;
	static int[] selected;
	static int[] nums;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./src/algo/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		input(br);
		
		dfs(0, sb);
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static void dfs(int cnt, StringBuilder sb) {
		if(cnt == M) {
			sb.append(
					Arrays.stream(selected)
					.mapToObj(String::valueOf)
					.collect(Collectors.joining(" "))
					).append('\n');
			return;
		}
		
		for(int idx=0; idx<N; ++idx) {
			selected[cnt] = nums[idx];
			dfs(cnt+1, sb);
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
