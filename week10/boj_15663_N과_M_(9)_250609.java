import java.io.*;
import java.util.*;

public class boj_15663_N과_M_(9)_250609 {

	static int N, M;
	static int[] nums;
	static int[] sels;
	static boolean[] visited;
	static Set<List<Integer>> set;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		input(br);

		perm(0);

		List<List<Integer>> list = new ArrayList<>(set);
		
		list.sort((a, b) -> {
			for (int i = 0; i < a.size(); i++) {
				if (!a.get(i).equals(b.get(i))) {
					return Integer.compare(a.get(i), b.get(i));
				}
			}
			return 0;
		});

		StringBuilder sb = new StringBuilder();
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

	private static void perm(int cnt) {
		if (cnt == M) {
			List<Integer> list = new ArrayList<>();
			for (int sel : sels) {
				list.add(sel);
			}
			set.add(list);
			return;
		}

		for (int i = 0; i < N; ++i) {
			if (visited[i]) continue;
			sels[cnt] = nums[i];
			visited[i] = true;
			perm(cnt + 1);
			visited[i] = false;
		}
	}

	private static void input(BufferedReader br) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		nums = new int[N];
		sels = new int[M];
		visited = new boolean[N];
		set = new HashSet<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(nums);
	}
}
