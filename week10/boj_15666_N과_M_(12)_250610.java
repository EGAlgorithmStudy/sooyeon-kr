import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class boj_15666_N과_M_(12)_250610 {	
	static int N, M;
	static int[] nums;
	static int[] sels;
	static Set<List<Integer>> set;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		input(br);
		dfs(0, 0);
		List<List<Integer>> list = new ArrayList<>(set);
		
		list.sort((a, b) -> {
			for (int i = 0; i < a.size(); i++) {
				if (!a.get(i).equals(b.get(i))) {
					return Integer.compare(a.get(i), b.get(i));
				}
			}
			return 0;
		});

		for (List<Integer> s : list) {
			for (int num : s) {
				sb.append(num).append(' ');
			}
			sb.append('\n');
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static void dfs(int cnt, int idx) {
		if (cnt == M) {
			List<Integer> list = new ArrayList<>();
			for (int sel : sels) {
				list.add(sel);
			}
			set.add(list);
			return;
		}
		
		for(int i=idx; i<N; ++i) {
			sels[cnt] = nums[i];
			dfs(cnt + 1, i);
		}
	}

	private static void input(BufferedReader br) throws Exception{
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		set = new HashSet<>();
		nums = new int[N];
		sels = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; ++i) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
	}

}
