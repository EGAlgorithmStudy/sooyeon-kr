import java.io.*;
import java.util.*;

public class boj_2295_세_수의_합_250414 {
	static int N;
	static int[] nums;
	static List<Integer> sum = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		input();

		int answer = 0;
		Arrays.sort(nums); 

		for (int i = N - 1; i >= 0; i--) {
			for (int j = 0; j < N; j++) {
				int target = nums[i] - nums[j];
				if (binary(target)) {
					System.out.println(nums[i]);
					return;
				}
			}
		}
	}

	private static boolean binary(int target) {
		int left = 0;
		int right = sum.size() - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (sum.get(mid) == target) {
				return true;
			} else if (sum.get(mid) < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return false;
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		nums = new int[N]; 
		for (int i = 0; i < N; ++i) {
			nums[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < N; ++i) {
			for (int j = i; j < N; ++j) {
				sum.add(nums[i] + nums[j]);
			}
		}

		Collections.sort(sum);
	}
}
