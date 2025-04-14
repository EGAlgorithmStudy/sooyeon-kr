import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class boj_1365_꼬인_전깃줄_250414 {
	static int N;
	static int[] lines;
	static List<Integer> lis = new ArrayList<>();
	public static void main(String[] args) throws Exception {

		input();

        for (int i = 0; i < N; i++) {
            int cur = lines[i];

            if (lis.isEmpty() || lis.get(lis.size() - 1) < cur) {
                lis.add(cur);
            } else {
                int idx = lower(cur);
                lis.set(idx, cur);
            }
        }
        
        System.out.println(N - lis.size());

	}

	private static int lower(int target) {
		int left = 0;
        int right = lis.size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (lis.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		lines = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	}
}
